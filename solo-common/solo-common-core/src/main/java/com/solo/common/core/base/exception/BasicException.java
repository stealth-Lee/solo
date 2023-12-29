package com.solo.common.core.base.exception;

import lombok.Getter;

import java.io.Serial;

/**
 * 基础异常
 * @author 十一
 * @since 2023/09/19 09:58
 * 人生若只如初见，何事秋风悲画扇
 **/
@Getter
public class BasicException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 所属模块
     */
    private final String module;

    /**
     * 错误码
     */
    private final Integer code;

    /**
     * 错误消息
     */
    private final String message;

    public BasicException(String module, Integer code, String message) {
        this.module = module;
        this.code = code;
        this.message = message;
    }

    public BasicException(String module, Integer code) {
        this(module, code, null);
    }

    public BasicException(String module, String message) {
        this(module, null, message);
    }

    public BasicException(String message) {
        this(null, null, message);
    }

}
