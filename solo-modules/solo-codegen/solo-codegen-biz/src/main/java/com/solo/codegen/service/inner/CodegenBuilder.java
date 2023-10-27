package com.solo.codegen.service.inner;

import cn.hutool.core.text.NamingCase;
import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.EnumUtil;
import cn.hutool.core.util.ReflectUtil;
import com.mybatisflex.codegen.entity.Column;
import com.mybatisflex.codegen.entity.Table;
import com.solo.codegen.api.constant.column.FormType;
import com.solo.codegen.api.constant.column.JavaType;
import com.solo.codegen.api.constant.column.QueryMode;
import com.solo.codegen.api.entity.GenColumn;
import com.solo.codegen.api.entity.GenTable;
import com.solo.common.core.constant.Symbols;
import com.solo.common.core.utils.StringUtils;
import com.solo.common.orm.base.entity.BasicEntity;
import com.solo.system.api.entity.SysConfig;
import com.solo.system.api.feign.SysConfigApi;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CodegenBuilder {

    @Resource
    private SysConfigApi sysConfigApi;

    /**
     * 基础实体类的字段
     */
    public static final Set<String> BASIC_ENTITY_FIELDS = new HashSet<>();

    /**
     * 创建操作, 忽略的字段
     */
    public static final Set<String> CREATE_IGNORE_FIELDS = new HashSet<>();

    /**
     * 更新操作, 忽略的字段
     */
    public static final Set<String> UPDATE_IGNORE_FIELDS = new HashSet<>();

    /**
     * 查询操作, 忽略的字段
     */
    public static final Set<String> QUERY_IGNORE_FIELDS = new HashSet<>();

    /**
     * 列表操作, 忽略的字段
     */
    public static final Set<String> LIST_IGNORE_FIELDS = new HashSet<>();

    static {
        Arrays.stream(ReflectUtil.getFields(BasicEntity.class)).forEach(field -> BASIC_ENTITY_FIELDS.add(field.getName()));
        CREATE_IGNORE_FIELDS.addAll(BASIC_ENTITY_FIELDS);
        CREATE_IGNORE_FIELDS.remove("remark");
        UPDATE_IGNORE_FIELDS.addAll(BASIC_ENTITY_FIELDS);
        UPDATE_IGNORE_FIELDS.remove("remark");
        QUERY_IGNORE_FIELDS.addAll(BASIC_ENTITY_FIELDS);
        LIST_IGNORE_FIELDS.addAll(BASIC_ENTITY_FIELDS);
        LIST_IGNORE_FIELDS.remove("remark");
        LIST_IGNORE_FIELDS.remove("createTime");
    }

    /**
     * 构建表对象
     * @param table 表信息
     */
    public void buildTable(Table table, GenTable genTable) {
        genTable.setTableName(table.getName());
        genTable.setTableComment(table.getComment());
        genTable.setClassName(NamingCase.toPascalCase(table.getName()));
        genTable.setFunctionName(StringUtils.replaceLast(table.getComment(), "表", ""));
        List<String> split = StringUtils.split(genTable.getTableName(), Symbols.UNDERLINE_CHAR, 2);
        genTable.setPackageName("com.solo." + split.get(0));
        genTable.setModuleName(split.get(0));
        genTable.setBusinessName(StringUtils.replace(split.get(1), Symbols.UNDERLINE, Symbols.DOT));
        SysConfig genClassTail = sysConfigApi.selectConfigByKey("gen_class_tail").getData();
        SysConfig genAuthor = sysConfigApi.selectConfigByKey("gen_author").getData();
        genTable.setClassTail(genClassTail.getConfigValue());
        genTable.setAuthor(genAuthor.getConfigValue());
        genTable.setIsSwitch(false);
    }

    /**
     * 构建列对象
     * @param tableId 表id
     * @param columns 字段信息
     * @return 列对象
     */
    public List<GenColumn> buildColumn(Long tableId, List<Column> columns) {
        List<GenColumn> genColumns = new ArrayList<>();
        int index = 0;
        for (Column column : columns) {
            GenColumn genColumn = new GenColumn();
            genColumn.setTableId(tableId);
            genColumn.setColumnName(column.getName());
            genColumn.setColumnType(column.getRawType());
            genColumn.setColumnSort(index++);
            genColumn.setJavaType(StringUtils.isNotBlank(column.getPropertyType())
                    ? EnumUtil.getBy(JavaType::getValue, StringUtils.subAfter(column.getPropertyType(), Symbols.DOT, true))
                    : JavaType.OBJECT);
            genColumn.setJavaField(column.getProperty());
            genColumn.setJavaComment(column.getComment());
            genColumn.setIsPk(column.isPrimaryKey());
            genColumn.setIsCreate(!CodegenBuilder.CREATE_IGNORE_FIELDS.contains(column.getProperty()) && !column.isPrimaryKey());
            genColumn.setIsUpdate(!CodegenBuilder.UPDATE_IGNORE_FIELDS.contains(column.getProperty()));
            genColumn.setIsRequired(!BooleanUtil.toBoolean(String.valueOf(column.getNullable())));
            genColumn.setIsList(!CodegenBuilder.LIST_IGNORE_FIELDS.contains(column.getProperty()) && !column.isPrimaryKey());
            genColumn.setIsQuery(!CodegenBuilder.QUERY_IGNORE_FIELDS.contains(column.getProperty()) && !column.isPrimaryKey());
            genColumn.setQueryMode(QueryMode.EQ);
            genColumn.setFormType(initFormType(genColumn));
            genColumns.add(genColumn);
        }
        return genColumns;
    }

    /**
     * 初始化表单类型
     * @param genColumn 字段信息
     * @return 表单类型
     */
    private FormType initFormType(GenColumn genColumn) {
        return switch (genColumn.getJavaType()) {
            case LOCAL_DATE_TIME -> FormType.DATE_TIME;
            case LOCAL_DATE -> FormType.DATE;
            case LOCAL_TIME -> FormType.TIME;
            case BOOLEAN -> FormType.SWITCH;
            case INTEGER, LONG, FLOAT, DOUBLE, BIG_DECIMAL -> FormType.NUMBER;
            case STRING -> {
                // TODO 11 判断某情况下是textarea，下周做数据库加个长度字段，当长度大于某个值时，就是textarea
//                if (genColumn.get)
                yield FormType.INPUT;
            }
            case null, default -> FormType.INPUT;
        };
    }

}
