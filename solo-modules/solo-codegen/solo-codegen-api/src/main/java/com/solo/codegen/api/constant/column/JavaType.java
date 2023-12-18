package com.solo.codegen.api.constant.column;

import com.fasterxml.jackson.annotation.JsonValue;
import com.mybatisflex.annotation.EnumValue;
import com.solo.common.core.base.enums.BasicDict;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * java类型枚举类
 * @author 十一
 * @since 2023/10/25 15:38
 * 人生若只如初见，何事秋风悲画扇
 **/
@Getter
@AllArgsConstructor
public enum JavaType implements BasicDict<String> {

    STRING("String", "字符串", "string"),
    INTEGER("Integer", "整型", "number"),
    LONG("Long", "长整型", "number"),
    FLOAT("Float", "浮点型", "number"),
    DOUBLE("Double", "双精度浮点型", "number"),
    BIG_DECIMAL("BigDecimal", "高精度浮点型", "date"),
    LOCAL_DATE_TIME("LocalDateTime", "日期时间类型", "date"),
    LOCAL_DATE("LocalDate", "日期类型", "date"),
    LOCAL_TIME("LocalTime", "时间类型", "date"),
    BOOLEAN("Boolean", "布尔类型", "boolean"),
    OBJECT("Object", "对象类型", "object");

    @EnumValue
    @JsonValue
    private final String value;
    private final String label;

    /**
     * vue参数类型
     */
    private final String vueType;

}
