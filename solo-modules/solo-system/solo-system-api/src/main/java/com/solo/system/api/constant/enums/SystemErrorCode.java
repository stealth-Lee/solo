package com.solo.system.api.constant.enums;

import com.solo.common.core.constant.ErrorCode;

/**
 * 系统模块错误码枚举
 * @author 十一
 * @since 2023/09/11 17:34
 * 人生若只如初见，何事秋风悲画扇
 **/
public enum SystemErrorCode implements ErrorCode {

    ;

    private final Integer code;
    private final String message;
    private final String i18nKey;

    SystemErrorCode(Integer code, String message, String i18nKey) {
        this.code = code;
        this.message = message;
        this.i18nKey = i18nKey;
    }

    @Override
    public Integer code() {
        return this.code;
    }

    @Override
    public String message() {
        return this.message;
    }

    @Override
    public String i18nKey() {
        return this.i18nKey;
    }

}
