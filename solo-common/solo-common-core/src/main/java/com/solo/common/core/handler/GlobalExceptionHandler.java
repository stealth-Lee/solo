package com.solo.common.core.handler;

import com.solo.common.core.exception.ServiceException;
import com.solo.common.core.global.R;
import com.solo.common.core.constant.enums.GlobalErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 * @author 十一
 * @since 2023/09/11 11:11
 * 人生若只如初见，何事秋风悲画扇
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public R<?> handlerException(Exception e) {
        log.error("全局异常信息 ex={}", e.getMessage(), e);
        return R.global(GlobalErrorCode.ERROR);
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(ServiceException.class)
    public R<?> handlerServiceException(ServiceException e) {
        log.error("业务异常信息 ex={}", e.getMessage(), e);
        return R.global(e.getCode(), e.getMessage(), null);
    }

}
