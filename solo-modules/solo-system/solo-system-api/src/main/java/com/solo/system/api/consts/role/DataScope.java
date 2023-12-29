package com.solo.system.api.consts.role;

import com.fasterxml.jackson.annotation.JsonValue;
import com.mybatisflex.annotation.EnumValue;
import com.solo.common.core.base.enums.BasicDict;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 数据权限枚举类
 * @author 十一
 * @since 2023/09/22 17:19
 * 人生若只如初见，何事秋风悲画扇
 **/
@Getter
@AllArgsConstructor
public enum DataScope implements BasicDict<Integer> {

    ALL(1, "全部数据权限"),
    DEPT(2, "本部门数据权限"),
    DEPT_BELOW(3, "本部门及以下数据权限"),
    CUSTOM(4, "自定义数据权限"),
    ONLY_ME(5, "仅本人数据权限");

    @EnumValue
    @JsonValue
    private final Integer value;
    private final String label;

}
