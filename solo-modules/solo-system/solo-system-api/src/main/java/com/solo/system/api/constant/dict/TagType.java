package com.solo.system.api.constant.dict;

import com.fasterxml.jackson.annotation.JsonValue;
import com.mybatisflex.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 标签类型枚举类
 * @author 十一
 * @since 2023/09/27 11:01
 * 人生若只如初见，何事秋风悲画扇
 **/
@Getter
@AllArgsConstructor
public enum TagType {

    DEFAULT(0, "default"),
    PRIMARY(1, "primary"),
    SUCCESS(2, "success"),
    INFO(3, "info"),
    WARNING(4, "warning"),
    DANGER(5, "danger");

    @EnumValue
    private final Integer value;
    @JsonValue
    private final String label;

}
