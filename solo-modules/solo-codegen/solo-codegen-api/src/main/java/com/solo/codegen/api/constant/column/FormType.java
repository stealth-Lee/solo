package com.solo.codegen.api.constant.column;

import com.fasterxml.jackson.annotation.JsonValue;
import com.mybatisflex.annotation.EnumValue;
import com.solo.common.orm.base.enums.BasicDict;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 表单类型枚举类
 * @author 十一
 * @since 2023/10/10 17:14
 * 人生若只如初见，何事秋风悲画扇
 **/
@Getter
@AllArgsConstructor
public enum FormType implements BasicDict<String> {

    INPUT("input", "文本框"),
    TEXTAREA("textarea", "文本域"),
    SELECT("select", "下拉框"),
    CHECKBOX("checkbox", "复选框"),
    RADIO("radio", "单选按钮"),
    DATE("date", "日期控件");

    @EnumValue
    @JsonValue
    private final String value;
    private final String label;

}
