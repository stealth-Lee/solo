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
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CodegenEngine {

    private final TemplateEngine templateEngine;

    /**
     * 初始化 TemplateEngine 属性
     */
    public CodegenEngine() {
        TemplateConfig config = new TemplateConfig();
        config.setResourceMode(TemplateConfig.ResourceMode.CLASSPATH);
        this.templateEngine = new VelocityEngine(config);
    }

    public Map<String, String> execute(GenTable table, List<GenColumn> columns, List<GenColumn> dictColumns) {
        Map<String, String> result = Maps.newLinkedHashMapWithExpectedSize(Template.values().length); // 有序
        Dict dict = Dict.create();
        dict.set("table", table).set("columns", columns);
        dict.set("now", DateUtil.format(new DateTime(), DatePattern.NORM_DATETIME_MINUTE_PATTERN));
        String modelClassName = StringUtils.removePreAndUpperFirst(table.getTableName(), Symbols.UNDERLINE_CHAR);
        dict.set("modelClassName", modelClassName);
        for (Template template : Template.values()) {
            if (Template.CONSTANT.equals(template)) {
                // 单独处理字典
                dict.set("dictColumns", dictColumns);
                for (GenColumn dictColumn : dictColumns) {
                    String enumName = NamingCase.toPascalCase(dictColumn.getDictCode());
                    dict.set("enumName", enumName);
                    dict.set("dicts", "");
                    result.put(buildPath(table, Template.CONSTANT, enumName), templateEngine.getTemplate(template.getTemplatePath()).render(dict));
                }
            } else {
                result.put(buildPath(table, template, modelClassName), templateEngine.getTemplate(template.getTemplatePath()).render(dict));
            }
        }

        return result;
    }


    /**
     * 构建文件路径
     * @param table 业务表对象
     * @param template 模版
     * @param modelClassName model对象名
     * @return {@link String}
     */
    private String buildPath(GenTable table, Template template, String modelClassName) {
        Map<String, String> map = new HashMap<>();
        map.put("moduleName", table.getModuleName());
        map.put("module", template.getModule());
        map.put("packageName", StringUtils.replace(table.getPackageName(), Symbols.DOT, Symbols.SLASH));
        map.put("packagePath", StringUtils.format(template.getPackagePath(), table.getBusinessName()));
        map.put("fileName", getFileName(table.getClassName(), template, modelClassName));
        return StringUtils.format("solo-{moduleName}-{module}/src/main/java/{packageName}/{packagePath}/{fileName}", map);
    }

    /**
     * 获取文件名
     * @param className 实体类名
     * @param template 模版
     * @param modelClassName model对象名
     * @return {@link String}
     */
    private String getFileName(String className, Template template, String modelClassName) {
        String templatePath = template.getTemplatePath();
        String suffix = templatePath.substring(templatePath.lastIndexOf(Symbols.SLASH)+1, templatePath.lastIndexOf(Symbols.DOT));

        if (StringUtils.contains(template.getTemplatePath(), "req")
                || StringUtils.contains(template.getTemplatePath(), "resp")) {
            // 如果是req或者resp，需要将实体名去掉模块前缀+后缀，比如SysUser -> UserCreateReq.java
            return modelClassName + suffix;
        } else if (StringUtils.contains(template.getTemplatePath(), "constant")) {
            // 如果是常量，直接以字典类型转大驼峰，比如sys_user -> SysUser.java
            return modelClassName + FileSuffix.JAVA;
        } else if (StringUtils.contains(template.getTemplatePath(), "entity")) {
            // 如果是entity，直接返回
            return className + FileSuffix.JAVA;
        } else {
            // 其它情况，直接返回类名+后缀 如：SysUserService.java
            return className + suffix;
        }
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
        CONSTANT("constant/{}", "codegen/java/constant/Constant.java.vm", "api"),
        ENTITY("api/entity", "codegen/java/entity/Entity.java.vm", "api"),
        CONVERT("model", "codegen/java/model/Convert.java.vm", "biz"),
        CREATE_REQ("model/{}/req", "codegen/java/model/req/CreateReq.java.vm", "biz"),
        UPDATE_REQ("model/{}/req", "codegen/java/model/req/UpdateReq.java.vm", "biz"),
        QUERY_REQ("model/{}/req", "codegen/java/model/req/QueryReq.java.vm", "biz"),
        GET_RESP("model/{}/resp", "codegen/java/model/resp/GetResp.java.vm", "biz"),
        LIST_RESP("model/{}/resp", "codegen/java/model/resp/ListResp.java.vm", "biz"),
        MAPPER("mapper", "codegen/java/mapper/Mapper.java.vm", "biz"),
        SERVICE("service", "codegen/java/service/Service.java.vm", "biz"),
        SERVICE_IMPL("service/impl", "codegen/java/service/ServiceImpl.java.vm", "biz"),
        CONTROLLER("web", "codegen/java/web/Controller.java.vm", "biz"),
        ;

        /**
         * 各种类的部分包路径
         */
        private final String packagePath;

        /**
         * 模版路径
         */
        private final String templatePath;

        private final String module;
    }

}
