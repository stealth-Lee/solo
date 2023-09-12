package com.solo.common.core.constant.enums;

import com.solo.common.core.constant.ErrorCode;

/**
 * 全局错误码枚举
 * @author 十一
 * @since 2023/09/11 10:18
 * 人生若只如初见，何事秋风悲画扇
 **/
public enum GlobalErrorCode implements ErrorCode {

    SUCCESS(0, "操作成功", "success"),
    FAILED(1, "操作失败", "failed"),
    ERROR(500, "系统异常", "error");

    private final Integer code;
    private final String message;
    private final String i18nKey;


    GlobalErrorCode(Integer code, String message, String i18nKey) {
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
