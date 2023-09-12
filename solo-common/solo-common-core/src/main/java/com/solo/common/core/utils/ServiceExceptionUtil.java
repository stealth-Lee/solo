package com.solo.common.core.utils;

import com.solo.common.core.constant.ErrorCode;
import com.solo.common.core.constant.enums.GlobalErrorCode;
import com.solo.common.core.exception.ServiceException;

/**
 * 业务异常工具类
 * @author 十一
 * @since 2023/09/11 16:32
 * 人生若只如初见，何事秋风悲画扇
 **/
public class ServiceExceptionUtil {

    private static ServiceException init(Integer code, String message) {
        return new ServiceException(code, message);
    }

    public static ServiceException exception(String message) {
        return init(GlobalErrorCode.FAILED.code(), message);
    }

    public static ServiceException exception(ErrorCode global) {
        return init(global.code(), global.message());
    }

}
