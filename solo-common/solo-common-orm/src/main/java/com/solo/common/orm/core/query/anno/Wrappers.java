package com.solo.common.orm.core.query.anno;

import java.lang.annotation.*;

/**
 * 查询条件包装注解, 作用于查询实体类上
 * @author 十一
 * @since 2023/09/19 09:16
 * 人生若只如初见，何事秋风悲画扇
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
public @interface Wrappers {

    /**
     * 默认为 驼峰属性 转换为 下划线字段
     */
    boolean camelToUnderline() default true;

}
