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
import com.solo.common.core.base.entity.BasicEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CodegenBuilder {

    /**
     * 作者
     */
    @Value("${codegen.author}")
    private String author;

    /**
     * 类尾部注释
     */
    @Value("${codegen.tail}")
    private String tail;

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
        genTable.setName(table.getName());
        genTable.setComment(table.getComment());
        genTable.setClassName(NamingCase.toPascalCase(table.getName()));
        genTable.setFunctionName(StringUtils.replaceLast(table.getComment(), "表", ""));
        List<String> split = StringUtils.split(genTable.getName(), Symbols.UNDERLINE_CHAR, 2);
        genTable.setPackageName("com.solo." + split.get(0));
        genTable.setModuleName(split.get(0));
        genTable.setBusinessName(StringUtils.replace(split.get(1), Symbols.UNDERLINE, Symbols.DOT));
        genTable.setAuthor(author);
        genTable.setClassTail(tail);
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
            genColumn.setName(column.getName());
            genColumn.setType(column.getRawType() + "(" + column.getRawLength() + ")");
            genColumn.setLength(column.getRawLength());
            genColumn.setSort(index++);
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
            genColumn.setFormType(initFormType(genColumn, column.getRawLength()));
            genColumns.add(genColumn);
        }
        return genColumns;
    }

    /**
     * 初始化表单类型
     * @param genColumn 字段信息
     * @return 表单类型
     */
    private FormType initFormType(GenColumn genColumn, int rawLength) {
        return switch (genColumn.getJavaType()) {
            case LOCAL_DATE_TIME -> FormType.DATE_TIME;
            case LOCAL_DATE -> FormType.DATE;
            case LOCAL_TIME -> FormType.TIME;
            case BOOLEAN -> FormType.SWITCH;
            case INTEGER, LONG, FLOAT, DOUBLE, BIG_DECIMAL -> FormType.NUMBER;
            case STRING -> {
                if (rawLength > 200)
                    yield FormType.TEXTAREA;
                yield FormType.INPUT;
            }
            case null, default -> FormType.INPUT;
        };
    }

}
