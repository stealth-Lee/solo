package com.solo.common.core.consts;

import com.solo.common.core.base.consts.BasicCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * 全局错误码枚举
 * @author 十一
 * @since 2023/09/11 10:18
 * 人生若只如初见，何事秋风悲画扇
 **/
@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public enum GlobalCode implements BasicCode {

    SUCCESS(0, "success"),
    FAILED(1, "failed"),

    // 客户端错误
    BAD_REQUEST(400, "badRequest"),
    UNAUTHORIZED(401, "unauthorized"),
    FORBIDDEN(403, "forbidden"),
    NOT_FOUND(404, "notFound"),
    METHOD_NOT_ALLOWED(405, "methodNotAllowed"),
    REQUEST_TIME_OUT(408, "requestTimeOut"),

    // 服务端错误
    ERROR(500, "error");

    private final Integer code;
    private final String i18nKey;

}
