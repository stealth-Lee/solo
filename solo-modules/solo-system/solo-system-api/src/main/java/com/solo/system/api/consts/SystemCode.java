package com.solo.system.api.consts;

import com.solo.common.core.base.consts.BasicCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * 系统模块错误码枚举
 * 系统模块，使用 1-02-01-001 段
 * @author 十一
 * @since 2023/09/11 17:34
 * 人生若只如初见，何事秋风悲画扇
 **/
@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public enum SystemCode implements BasicCode {

    // 01用户模块
    USER_NOT_EXISTS(10201001, "UserNotExists"),
    USERNAME_EXISTS(10201002, "UsernameExists"),

    // 02角色模块
    ROLE_CODE_EXISTS(10202001, "RoleCodeExists"),

    // 03菜单模块

    // 04部门模块
    DEPT_CODE_EXISTS(10204001, "DeptCodeExists"),
    DEPT_EXISTS_CHILDREN(10204002, "DeptExistsChildren"),

    // 05字典模块
    DICT_CODE_EXISTS(10205001, "DictCodeExists"),

    // 06参数模块
    ;

    private final Integer code;
    private final String i18nKey;

}
