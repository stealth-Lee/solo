package com.solo.common.orm.core.query.anno;

import com.solo.common.orm.core.query.enums.Connector;
import com.solo.common.orm.core.query.enums.QueryMode;

import java.lang.annotation.*;

/**
 * 查询条件注解
 * @author 十一
 * @since 2023/09/18 11:00
 * 人生若只如初见，何事秋风悲画扇
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Inherited
public @interface Query {

    /**
     * 字段名, 默认为属性名转下划线 （userName -> user_name）
     */
    String value() default "";

    /**
     * 表名别名, 默认为空
     */
    String alias() default "";

    /**
     * 查询模式, 默认为全匹配查询
     */
    QueryMode mode() default QueryMode.EQ;

    /**
     * 连接方式, 默认为 AND
     */
    Connector connector() default Connector.AND;

}
