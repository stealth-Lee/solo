package com.solo.system.api.constant.global;

import com.fasterxml.jackson.annotation.JsonValue;
import com.mybatisflex.annotation.EnumValue;
import com.solo.common.core.base.enums.BasicDict;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 全局状态枚举类
 * @author 十一
 * @since 2023/09/22 16:00
 * 人生若只如初见，何事秋风悲画扇
 **/
@Getter
@AllArgsConstructor
public enum GlobalStatus implements BasicDict<Integer> {

    DEACTIVATE(0, "停用"),
    NORMAL(1, "正常");

    @EnumValue
    @JsonValue
    private final Integer value;
    private final String label;

}
