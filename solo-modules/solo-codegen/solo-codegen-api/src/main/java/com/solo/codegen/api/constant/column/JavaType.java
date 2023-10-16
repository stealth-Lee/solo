package com.solo.codegen.api.constant.column;

import com.fasterxml.jackson.annotation.JsonValue;
import com.mybatisflex.annotation.EnumValue;
import com.solo.common.orm.base.enums.BasicDict;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JavaType implements BasicDict<String> {

    STRING("String", "字符串"),
    INTEGER("Integer", "整型"),
    LONG("Long", "长整型"),
    FLOAT("Float", "浮点型"),
    DOUBLE("Double", "双精度浮点型"),
    BIG_DECIMAL("BigDecimal", "高精度浮点型"),
    LOCAL_DATE_TIME("LocalDateTime", "日期时间类型"),
    LOCAL_DATE("LocalDate", "日期类型"),
    LOCAL_TIME("LocalTime", "时间类型"),
    BOOLEAN("Boolean", "布尔类型"),
    OBJECT("Object", "对象类型");

    @EnumValue
    @JsonValue
    private final String value;
    private final String label;

}
