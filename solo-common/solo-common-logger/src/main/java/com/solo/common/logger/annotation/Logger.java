package com.solo.common.logger.annotation;

import com.solo.common.logger.enums.LoggerType;

import java.lang.annotation.*;

/**
 * 日志注解
 * @author Gentleman.Lee
 * @since 2023/12/13 17:04
 * 人生若只如初见，何事秋风悲画扇
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Logger {

    /**
     * 日志描述
     */
    String value() default "";

    /**
     * 日志类型
     */
    LoggerType type() default LoggerType.OTHER;

}
