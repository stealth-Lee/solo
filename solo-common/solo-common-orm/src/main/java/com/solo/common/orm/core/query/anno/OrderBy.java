package com.solo.common.orm.core.query.anno;

import com.solo.common.orm.core.query.enums.Order;

import java.lang.annotation.*;

/**
 * 排序注解, 作用于查询实体类的属性上, 用于指定排序方式
 * 优先级高于 @Query.orderBy
 * @author 十一
 * @since 2023/12/27 14:49
 * 人生若只如初见，何事秋风悲画扇
 **/
// 先不做，因为，查询实体类中的属性，可能不参与查询，仅仅是排序，没必要写到实体类中
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Inherited
@Deprecated
public @interface OrderBy {

    Order value() default Order.DESC;

}
