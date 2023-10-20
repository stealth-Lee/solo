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
import com.solo.common.core.global.R;
import com.solo.common.core.utils.StringUtils;
import com.solo.system.api.constant.global.YesNo;
import com.solo.system.api.entity.SysDictData;
import com.solo.system.api.feign.SysDictApi;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CodegenEngine {

    @Autowired
    private SysDictApi sysDictApi;
    private final TemplateEngine templateEngine;

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
        GenColumn primaryColumn = columns.stream().filter(column -> column.getIsPk() == YesNo.YES).findFirst().orElse(null);
        dict.set("primaryColumn", primaryColumn); // 主键列
        List<GenColumn> dictColumns = columns.stream().filter(column -> StringUtils.isNotBlank(column.getDictCode())).toList();
        dict.set("dictColumns", dictColumns); // 字典列
        dict.set("now", DateUtil.format(new DateTime(), DatePattern.NORM_DATETIME_MINUTE_PATTERN));
        String modelClassName = StringUtils.removePreAndUpperFirst(table.getTableName(), Symbols.UNDERLINE_CHAR);
        dict.set("modelClassName", modelClassName);
        dict.set("basicEntity", CodegenBuilder.BASIC_ENTITY_FIELDS);
        for (Template template : Template.values()) {
            if (Template.CONSTANT.equals(template)) {
                // 单独处理字典
                for (GenColumn dictColumn : dictColumns) {
                    String enumName = NamingCase.toPascalCase(dictColumn.getDictCode());
                    dict.set("enumName", enumName);
                    R<List<SysDictData>> listR = sysDictApi.selectByDictCode(dictColumn.getDictCode());
                    List<SysDictData> data = listR.getData();
                    dict.set("dicts", data);
                    dict.set("StringUtils", new StringUtils());
                    result.put(buildPath(template, table, enumName), templateEngine.getTemplate(template.getTemplatePath()).render(dict));
                }
            } else {
                result.put(buildPath(template, table, null), templateEngine.getTemplate(template.getTemplatePath()).render(dict));
            }
        }

        return result;
    }


    /**
     * 构建文件路径
     * @param template 模版
     * @param table 业务表对象
     * @param modelClassName model对象名
     * @return {@link String}
     */
    private String buildPath(Template template, GenTable table, String modelClassName) {
        Map<String, String> map = new HashMap<>();
        map.put("moduleName", table.getModuleName());
        map.put("businessName", table.getBusinessName());
        map.put("module", StringUtils.format(template.getModule(), map));
        map.put("packageName", StringUtils.replace(table.getPackageName(), Symbols.DOT, Symbols.SLASH));
        map.put("packagePath", StringUtils.format(template.getPackagePath(), map));
        map.put("fileName", getFileName(template, table, modelClassName));
        return StringUtils.format("{module}/src/{packagePath}/{fileName}", map);
    }

    /**
     * 获取文件名
     * @param template 模版
     * @param table 业务表对象
     * @param enumName 枚举名称
     * @return {@link String}
     */
    private String getFileName(Template template, GenTable table, String enumName) {
        String templatePath = template.getTemplatePath();
        // codegen/java/mapper/Mapper.java.vm -> Mapper.java
        String suffix = templatePath.substring(templatePath.lastIndexOf(Symbols.SLASH)+1, templatePath.lastIndexOf(Symbols.DOT));
        return switch (template) {
            // 如果是req或者resp，需要将实体名去掉模块前缀+后缀，比如SysUser -> UserCreateReq.java
            case CREATE_REQ, UPDATE_REQ, QUERY_REQ, GET_RESP, LIST_RESP ->
                    // model的对象名,去掉表的前缀并大写首字母 sys_user -> User
                    StringUtils.removePreAndUpperFirst(table.getTableName(), Symbols.UNDERLINE_CHAR) + suffix;
            // 如果是常量枚举，直接以字典类型转大驼峰，比如del_flag -> DelFlag.java
            case CONSTANT -> enumName + FileSuffix.JAVA;
            // 如果是entity，直接返回SysUser + .java -> 直接返回SysUser.java
            case ENTITY -> table.getClassName() + FileSuffix.JAVA;
            // 如果是vue页面，直接返回后缀index.vue/form.vue/menu.sql.vm
            case INDEX, FORM, SQL -> suffix;
            // 如果是ts，直接返回SysUser
            case TS -> table.getBusinessName() + FileSuffix.TS;
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
        GET_RESP("codegen/java/model/resp/GetResp.java.vm", "solo-{moduleName}-biz", "main/java/{packageName}/model/{businessName}/resp"),
        LIST_RESP("codegen/java/model/resp/ListResp.java.vm", "solo-{moduleName}-biz", "main/java/{packageName}/model/{businessName}/resp"),
        SERVICE("codegen/java/service/Service.java.vm", "solo-{moduleName}-biz", "main/java/{packageName}/service"),
        SERVICE_IMPL("codegen/java/service/ServiceImpl.java.vm", "solo-{moduleName}-biz", "main/java/{packageName}/service/impl"),
        CONTROLLER("codegen/java/web/Controller.java.vm", "solo-{moduleName}-biz", "main/java/{packageName}/web"),
        MAPPER("codegen/java/mapper/Mapper.java.vm", "solo-{moduleName}-biz", "main/java/{packageName}/mapper"),
        SQL("codegen/sql/menu.sql.vm", "sql", ""),
        INDEX("codegen/vue/index.vue.vm", "solo-ui", "view/{moduleName}/{businessName}"),
        FORM("codegen/vue/form.vue.vm", "solo-ui", "view/{moduleName}/{businessName}"),
        TS("codegen/ts/index.ts.vm", "solo-ui", "api/{moduleName}");

        /**
         * 模版路径
         */
        private final String templatePath;

        /**
         * 所属模块[api biz]
         */
        private final String module;

        /**
         * 各种类的部分包路径
         */
        private final String packagePath;

    }

}
