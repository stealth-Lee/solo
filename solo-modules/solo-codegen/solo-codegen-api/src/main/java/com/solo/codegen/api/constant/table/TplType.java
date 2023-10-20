package com.solo.codegen.api.constant.table;

import com.fasterxml.jackson.annotation.JsonValue;
import com.mybatisflex.annotation.EnumValue;
import com.solo.common.orm.base.enums.BasicDict;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 模版类型枚举类
 * @author 十一
 * @since 2023/10/08 15:36
 * 人生若只如初见，何事秋风悲画扇
 **/
@Getter
@AllArgsConstructor
public enum TplType implements BasicDict<Integer> {

    SINGLE_TABLE(1, "单表结构"),
    TREE_TABLE(2, "树表结构"),
    PRIMARY_CHILD_TABLE(3, "主子表结构");

    @EnumValue
    @JsonValue
    private final Integer value;
    private final String label;

}
