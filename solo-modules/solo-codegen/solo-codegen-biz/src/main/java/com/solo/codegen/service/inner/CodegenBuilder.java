package com.solo.codegen.service.inner;

import cn.hutool.core.util.ReflectUtil;
import com.solo.common.orm.base.entity.BasicEntity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CodegenBuilder {

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

}
