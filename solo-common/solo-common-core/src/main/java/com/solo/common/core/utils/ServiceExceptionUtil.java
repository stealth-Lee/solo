package com.solo.common.core.utils;

import com.solo.common.core.base.consts.BasicCode;
import com.solo.common.core.consts.GlobalCode;
import com.solo.common.core.exception.ServiceException;

/**
 * 业务异常工具类
 * @author 十一
 * @since 2023/09/11 16:32
 * 人生若只如初见，何事秋风悲画扇
 **/
public class ServiceExceptionUtil {

    /**
     * 初始化一个业务异常
     * @param code 错误码
     * @param message 错误信息
     * @return 业务异常
     */
    private static ServiceException init(Integer code, String message) {
        return new ServiceException(code, message);
    }

    /**
     * 抛出一个自定义错误信息的业务异常，错误码默认为 FAILED(1)
     * 该方法不支持国际化，如果需要国际化，请使用 {@link #exception(BasicCode)}
     * @param message 错误信息
     * @return 业务异常
     */
    public static ServiceException exception(String message) {
        return init(GlobalCode.FAILED.code(), message);
    }

    /**
     * 抛出一个自定义错误码和错误信息的业务异常
     * global 错误码 支持国际化
     * @return 业务异常
     */
    public static ServiceException exception(BasicCode global) {
        return init(global.code(), global.message());
    }

}
