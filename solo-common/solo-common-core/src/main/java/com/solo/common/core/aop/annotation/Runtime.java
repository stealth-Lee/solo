package com.solo.common.core.aop.annotation;

import java.lang.annotation.*;

/**
 * 运行时间注解，用于记录方法运行时间
 * @author 十一
 * @since 2023/11/09 16:21
 * 人生若只如初见，何事秋风悲画扇
 **/
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Runtime {

}
