package com.solo.auth.consts;

import com.solo.common.core.base.consts.BasicCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * 认证中心错误码枚举类
 * 认证中心，使用 1-01-01-001 段
 * @author Gentleman.Lee
 * @since 2023/12/25 09:40
 * 人生若只如初见，何事秋风悲画扇
 **/
@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public enum AuthCode implements BasicCode {

    // 用户名和密码不匹配
    AUTH_USERNAME_PASSWORD_NOT_MATCH(10101001, "AuthUsernamePasswordNotMatch"),
    ;

    private final Integer code;
    private final String i18nKey;

}
