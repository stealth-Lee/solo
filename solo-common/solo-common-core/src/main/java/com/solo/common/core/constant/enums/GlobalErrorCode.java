package com.solo.common.core.constant.enums;

import com.solo.common.core.constant.ErrorCode;

/**
 * 全局错误码枚举
 * @author 十一
 * @since 2023/09/11 10:18
 * 人生若只如初见，何事秋风悲画扇
 **/
public enum GlobalErrorCode implements ErrorCode {

    SUCCESS(0, "success"),
    FAILED(1, "failed"),

    // 客户端错误
    BAD_REQUEST(400, "badRequest"),
    UNAUTHORIZED(401, "unauthorized"),
    FORBIDDEN(403, "forbidden"),
    NOT_FOUND(404, "notFound"),
    METHOD_NOT_ALLOWED(405, "methodNotAllowed"),
    REQUEST_TIME_OUT(408, "requestTimeOut"),

    //
    ERROR(500, "error");

    private final Integer code;
    private final String i18nKey;


    GlobalErrorCode(Integer code, String i18nKey) {
        this.code = code;
        this.i18nKey = i18nKey;
    }

    @Override
    public Integer code() {
        return this.code;
    }

    @Override
    public String i18nKey() {
        return this.i18nKey;
    }

}
