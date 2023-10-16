package com.solo.codegen.api.constant.column;

import com.fasterxml.jackson.annotation.JsonValue;
import com.mybatisflex.annotation.EnumValue;
import com.solo.common.orm.base.enums.BasicDict;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 查询模式枚举类
 * @author 十一
 * @since 2023/10/10 17:14
 * 人生若只如初见，何事秋风悲画扇
 **/
@Getter
@AllArgsConstructor
public enum QueryMode implements BasicDict<String> {

    EQ("eq", "="),
    NE("ne", "<>"),
    GT("gt", ">"),
    GE("ge", ">="),
    LT("lt", "<"),
    LE("le", "<="),
    BETWEEN("between", "between"),
    LIKE("like", "like"),
    LIKE_LEFT("likeLeft", "%like"),
    LIKE_RIGHT("likeRight", "like%");

    @EnumValue
    @JsonValue
    private final String value;
    private final String label;

}
