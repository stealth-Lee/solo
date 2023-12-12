package com.solo.codegen.service.inner;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.text.NamingCase;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.engine.velocity.VelocityEngine;
import com.alibaba.nacos.shaded.com.google.common.collect.Maps;
import com.solo.codegen.api.entity.GenColumn;
import com.solo.codegen.api.entity.GenTable;
import com.solo.common.core.constant.FileSuffix;
import com.solo.common.core.constant.Symbols;
import com.solo.common.core.utils.StringUtils;
import com.solo.in.api.TranslateApi;
import com.solo.in.api.entity.UniversalTranslation;
import com.solo.system.api.SysDictApi;
import com.solo.system.api.entity.SysDictData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CodegenEngine {

    /**
     * 生成语言包的默认语言列表
     */
    @Value("${codegen.languages}")
    private String languages;
    private final TemplateEngine templateEngine;
    @DubboReference
    private SysDictApi sysDictApi;
    @DubboReference
    private TranslateApi translateApi;

    /**
     * 初始化 TemplateEngine 属性
     */
    public CodegenEngine() {
        TemplateConfig config = new TemplateConfig();
        config.setResourceMode(TemplateConfig.ResourceMode.CLASSPATH);
        this.templateEngine = new VelocityEngine(config);
    }

    /**
     * 执行代码生成
     * @param table 业务表
     * @param columns 业务字段列表
     * @return {@link Map}<{@link String}, {@link String}>
     */
    public Map<String, String> execute(GenTable table, List<GenColumn> columns) {
        Map<String, String> result = Maps.newLinkedHashMapWithExpectedSize(Template.values().length); // 有序
        Dict dict = Dict.create();
        dict.set("table", table).set("columns", columns);
        GenColumn primaryColumn = columns.stream().filter(GenColumn::getIsPk).findFirst().orElse(null);
        dict.set("primaryColumn", primaryColumn); // 主键列
        List<GenColumn> dictColumns = columns.stream().filter(column -> StringUtils.isNotBlank(column.getDictCode())).toList();
        dict.set("dictColumns", dictColumns); // 字典列
        dict.set("now", DateUtil.format(new DateTime(), DatePattern.NORM_DATETIME_MINUTE_PATTERN));
        String modelClassName = NamingCase.toPascalCase(StringUtils.removePreAndUpperFirst(table.getName(), Symbols.UNDERLINE_CHAR));
        dict.set("modelClassName", modelClassName);
        dict.set("basicEntity", CodegenBuilder.BASIC_ENTITY_FIELDS);
        dict.set("StringUtils", new StringUtils());
        for (Template template : Template.values()) {
            switch (template) {
                case CONSTANT -> {
                    // 单独处理字典
                    for (GenColumn dictColumn : dictColumns) {
                        String enumName = NamingCase.toPascalCase(dictColumn.getDictCode());
                        dict.set("enumName", enumName);
                        List<SysDictData> data = sysDictApi.selectByCode(dictColumn.getDictCode());
                        dict.set("dicts", data);
                        result.put(buildPath(template, table, enumName),
                                templateEngine.getTemplate(template.getTemplatePath()).render(dict));
                    }
                }
                case UPDATE_STATUS_REQ -> {
                    if (table.getIsSwitch())
                        result.put(buildPath(template, table, modelClassName),
                                templateEngine.getTemplate(template.getTemplatePath()).render(dict));
                }
                case LANGUAGE -> {
                    List<String> languageList = StringUtils.split(languages, Symbols.COMMA);
                    languageList.forEach(language -> {
                        columns.forEach(column -> {
                            if ((column.getIsQuery() || column.getIsUpdate() || column.getIsCreate() || column.getIsRequired()) && !column.getIsPk()) {
                                String javaComment = column.getJavaComment();
                                if (StringUtils.isBlank(javaComment)) {
                                    javaComment = StringUtils.replace(column.getName(), Symbols.UNDERLINE, " ");
                                }
                                column.setJavaComment(handelLanguage(language, javaComment));
                            }
                        });
                        dict.set("i18nColumns", columns);
                        dict.set("i18nFunctionName", handelLanguage(language, table.getFunctionName()));
                        dict.set("i18nBusinessName", StringUtils.toCamelCase(table.getBusinessName(), Symbols.DOT_CHAT));
                        dict.set("i18nInputTip", StringUtils.replaceLast(handelLanguage(language, "请输入996"), "996", ""));
                        dict.set("i18nSelectTip", StringUtils.replaceLast(handelLanguage(language, "请选择996"), "996", ""));
                        dict.set("i18nNotNullMessage", StringUtils.replaceFirst(handelLanguage(language, "996不能为空"), "996", ""));
                        result.put(buildPath(template, table, language),
                                templateEngine.getTemplate(template.getTemplatePath()).render(dict));
                    });
                }
                default -> result.put(buildPath(template, table, modelClassName),
                        templateEngine.getTemplate(template.getTemplatePath()).render(dict));
            }
        }
        return result;
    }


    private String handelLanguage(String to, String q) {
        UniversalTranslation universalTranslation = new UniversalTranslation();
        universalTranslation.setTo(to);
        universalTranslation.setQ(q);
        String text = translateApi.text(universalTranslation);
        return StringUtils.capitalizeEnglishWords(text);
    }

    /**
     * 构建文件路径
     * @param template 模版
     * @param table 业务表对象
     * @param className 对象名
     * @return {@link String}
     */
    private String buildPath(Template template, GenTable table, String className) {
        Map<String, String> map = new HashMap<>();
        map.put("moduleName", table.getModuleName());
        map.put("businessName", table.getBusinessName());
        map.put("module", StringUtils.format(template.getModule(), map));
        map.put("packageName", StringUtils.replace(table.getPackageName(), Symbols.DOT, Symbols.SLASH));
        map.put("packagePath", StringUtils.format(template.getPackagePath(), map));
        map.put("fileName", getFileName(template, table, className));
        return StringUtils.format("{module}/src/{packagePath}/{fileName}", map);
    }

    /**
     * 获取文件名
     * @param template 模版
     * @param table 业务表对象
     * @param className 对象名
     * @return {@link String}
     */
    private String getFileName(Template template, GenTable table, String className) {
        String templatePath = template.getTemplatePath();
        // codegen/java/mapper/Mapper.java.vm -> Mapper.java
        String suffix = templatePath.substring(templatePath.lastIndexOf(Symbols.SLASH)+1, templatePath.lastIndexOf(Symbols.DOT));
        return switch (template) {
            // 如果是req或者resp，需要将实体名去掉模块前缀+后缀，比如SysUser -> UserCreateReq.java
            case CREATE_REQ, UPDATE_REQ, QUERY_REQ, GET_RESP, LIST_RESP, UPDATE_STATUS_REQ ->
                    // model的对象名,去掉表的前缀并大写首字母 sys_user -> User
                    className + suffix;
            // 如果是常量枚举，直接以字典类型转大驼峰，比如del_flag -> DelFlag.java
            case CONSTANT -> className + FileSuffix.JAVA;
            // 如果是entity，直接返回SysUser + .java -> 直接返回SysUser.java
            case ENTITY -> table.getClassName() + FileSuffix.JAVA;
            // 如果是vue页面，直接返回后缀index.vue/form.vue/menu.sql.vm
            case INDEX, FORM, SQL -> suffix;
            // 如果是ts，直接返回SysUser
            case TS -> table.getBusinessName() + FileSuffix.TS;
            // 如果是语言包，直接返回指定名称+后缀 如en + .yaml -> en.yaml
            case LANGUAGE -> className + FileSuffix.YAML;
            // 其它情况，直接返回类名+后缀 如：SysUser + Service.java -> SysUserService.java
            default -> table.getClassName() + suffix;
        };
    }

    /**
     * 模版枚举
     * @author 十一
     * @since 2023/10/16 08:45
     * 人生若只如初见，何事秋风悲画扇
     **/
    @Getter
    @AllArgsConstructor
    private enum Template {

        CONSTANT("codegen/java/constant/Constant.java.vm", "solo-{moduleName}-api", "main/java/{packageName}/api/constant/{businessName}"),
        ENTITY("codegen/java/entity/Entity.java.vm", "solo-{moduleName}-api", "main/java/{packageName}/api/entity"),
        CONVERT("codegen/java/model/Convert.java.vm", "solo-{moduleName}-biz", "main/java/{packageName}/model/{businessName}"),
        CREATE_REQ("codegen/java/model/req/CreateReq.java.vm", "solo-{moduleName}-biz", "main/java/{packageName}/model/{businessName}/req"),
        UPDATE_REQ("codegen/java/model/req/UpdateReq.java.vm", "solo-{moduleName}-biz", "main/java/{packageName}/model/{businessName}/req"),
        QUERY_REQ("codegen/java/model/req/QueryReq.java.vm", "solo-{moduleName}-biz", "main/java/{packageName}/model/{businessName}/req"),
        UPDATE_STATUS_REQ("codegen/java/model/req/UpdateStatusReq.java.vm", "solo-{moduleName}-biz", "main/java/{packageName}/model/{businessName}/req"),
        GET_RESP("codegen/java/model/resp/GetResp.java.vm", "solo-{moduleName}-biz", "main/java/{packageName}/model/{businessName}/resp"),
        LIST_RESP("codegen/java/model/resp/ListResp.java.vm", "solo-{moduleName}-biz", "main/java/{packageName}/model/{businessName}/resp"),
        MAPPER("codegen/java/mapper/Mapper.java.vm", "solo-{moduleName}-biz", "main/java/{packageName}/mapper"),
        SERVICE("codegen/java/service/Service.java.vm", "solo-{moduleName}-biz", "main/java/{packageName}/service"),
        SERVICE_IMPL("codegen/java/service/ServiceImpl.java.vm", "solo-{moduleName}-biz", "main/java/{packageName}/service/impl"),
        CONTROLLER("codegen/java/web/Controller.java.vm", "solo-{moduleName}-biz", "main/java/{packageName}/web"),
        SQL("codegen/sql/menu.sql.vm", "sql", ""),
        TS("codegen/ts/index.ts.vm", "solo-ui", "api/{moduleName}"),
        INDEX("codegen/vue/index.vue.vm", "solo-ui", "view/{moduleName}/{businessName}"),
        FORM("codegen/vue/form.vue.vm", "solo-ui", "view/{moduleName}/{businessName}"),
        // TODO 一定要把语言包的模版放在最后，因为语言包的模版需要修改columns的javaComment, 一定要在其它模版执行完毕后再执行
        LANGUAGE("codegen/vue/i18n/language.yaml.vm", "solo-ui", "view/{moduleName}/{businessName}/i18n");

        /**
         * 模版路径
         */
        private final String templatePath;

        /**
         * 所属模块
         */
        private final String module;

        /**
         * 部分包路径
         */
        private final String packagePath;

    }

}
