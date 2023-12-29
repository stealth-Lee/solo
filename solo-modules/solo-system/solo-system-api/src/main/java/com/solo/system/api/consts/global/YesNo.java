package com.solo.system.api.consts.global;

import com.fasterxml.jackson.annotation.JsonValue;
import com.mybatisflex.annotation.EnumValue;
import com.solo.common.core.base.enums.BasicDict;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 是否枚举类
 * @author 十一
 * @since 2023/09/22 16:00
 * 人生若只如初见，何事秋风悲画扇
 **/
@Getter
@AllArgsConstructor
public enum YesNo implements BasicDict<Integer> {

    NO(0, "否"),
    YES(1, "是");

    @EnumValue
    @JsonValue
    private final Integer value;
    private final String label;

}
