package com.solo.system.api.constant.global;

import cn.hutool.core.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonValue;
import com.mybatisflex.annotation.EnumValue;
import com.solo.common.orm.base.enums.BasicDict;
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
public enum YesNo implements BasicDict<Boolean> {

    NO(false, "否"),
    YES(true, "是");

    @EnumValue
    @JsonValue
    private final Boolean value;
    private final String label;

    public static void main(String[] args) {
        YesNo by = EnumUtil.getBy(YesNo::getValue, true);
        System.out.println(by);
    }

}
