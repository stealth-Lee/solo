package com.solo.common.core.global;

import com.solo.common.core.constant.ErrorCode;
import com.solo.common.core.constant.enums.GlobalErrorCode;
import lombok.Data;

import java.io.Serializable;

/**
 * 响应信息主体类
 * @author 十一
 * @since 2023/08/31 16:53
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class R<T> implements Serializable {

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应信息提示
     */
    private String message;

    /**
     * 响应数据
     */
    private  T data;

    /**
     * 私有化构造器，不允许外部随意创建错误码，必须通过GlobalErrorCode创建
     */
    private R() {}

    public static <T> R<T> global(Integer code, String message, T data) {
        R<T> result = new R<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    /**
     * 自定义错误码
     * @param global 错误码枚举
     * @return 响应信息主体类
     */
    public static <T> R<T> global(ErrorCode global) {
        return global(global, null);
    }

    /**
     * 自定义错误码,携带响应数据
     * @param global 错误码枚举
     * @param data 响应数据
     * @return 响应信息主体类
     */
    public static <T> R<T> global(ErrorCode global, T data) {
        return global(global.code(), global.message(), data);
    }

    /**
     * 返回成功消息
     * @return 成功消息
     */
    public static <T> R<T> success() {
        return success(null);
    }

    /**
     * 返回成功消息，携带响应数据
     * @param data 响应数据
     * @return 成功消息
     */
    public static <T> R<T> success(T data) {
        return global(GlobalErrorCode.SUCCESS, data);
    }

    /**
     * 返回错误信息
     * @return 错误信息
     */
    public static <T> R<T> failed() {
        return global(GlobalErrorCode.FAILED, null);
    }

    /**
     * 返回错误信息,自定义错误信息提示
     * @param message 错误信息提示
     * @return 错误信息
     */
    public static <T> R<T> failed(String message) {
        return global(GlobalErrorCode.FAILED.code(), message, null);
    }

    /**
     * 返回错误信息,携带响应数据
     * @param data 响应数据
     * @return 错误信息
     */
    public static <T> R<T> failed(T data) {
        return global(GlobalErrorCode.FAILED, data);
    }

    /**
     * 返回错误信息,自定义错误信息提示,携带响应数据
     * @param message 错误信息提示
     * @param data 响应数据
     * @return 错误信息
     */
    public static <T> R<T> failed(String message, T data) {
        return global(GlobalErrorCode.FAILED.code(), message, data);
    }

}
