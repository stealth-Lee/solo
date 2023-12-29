package com.solo.system.api.consts.dict;

import com.fasterxml.jackson.annotation.JsonValue;
import com.mybatisflex.annotation.EnumValue;
import com.solo.common.core.base.enums.BasicDict;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 字典类型枚举类
 * @author 十一
 * @since 2023/10/24 11:11
 * 人生若只如初见，何事秋风悲画扇
 **/
@Getter
@AllArgsConstructor
public enum DictType implements BasicDict<Integer> {

    STRING(1, "string"),
    NUMBER(2, "number"),
    BOOLEAN(3, "boolean");

    @EnumValue
    @JsonValue
    private final Integer value;
    private final String label;

}

