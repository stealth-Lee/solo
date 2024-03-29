package com.solo.system.api.consts.user;

import com.fasterxml.jackson.annotation.JsonValue;
import com.mybatisflex.annotation.EnumValue;
import com.solo.common.core.base.enums.BasicDict;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户性别枚举类
 * @author 十一
 * @since 2023/09/22 09:12
 * 人生若只如初见，何事秋风悲画扇
 **/
@Getter
@AllArgsConstructor
public enum Sex implements BasicDict<Integer> {

    GENTLEMAN(0, "男"),
    WOMAN(1, "女");

    @EnumValue
    @JsonValue
    private final Integer value;
    private final String label;

}
