package com.solo.common.orm.core.query.enums;

/**
 * 查询模式枚举类
 *
 * @author 十一
 * @since 2023/09/18 15:05
 * 人生若只如初见，何事秋风悲画扇
 **/
public enum QueryMode {

    /**
     * 等于 =
     * 例: eq("name", "老王")--->name = '老王'
     */
    EQ,

    /**
     * 不等于 <>
     * 例: ne("name", "老王")--->name <> '老王'
     */
    NE,

    /**
     * 大于 >
     * 例: gt("age", 18)--->age > 18
     */
    GT,

    /**
     * 大于等于 >=
     * 例: ge("age", 18)--->age >= 18
     */
    GE,

    /**
     * 小于 <
     * 例: lt("age", 18)--->age < 18
     */
    LT,

    /**
     * 小于等于 <=
     * 例: le("age", 18)--->age <= 18
     */
    LE,

    /**
     * 介于 BETWEEN 值1 AND 值2
     * 例: between("age", 18, 30)--->age between 18 and 30
     */
    BETWEEN,

    /**
     * LIKE '%值%'
     * 例: like("name", "王")--->name like '%王%'
     */
    LIKE,

    /**
     * NOT LIKE '%值%'
     * 例: notLike("name", "王")--->name not like '%王%'
     */
    NOT_LIKE,

    /**
     * LIKE '%值'
     * 例: likeLeft("name", "王")--->name like '%王'
     */
    LIKE_LEFT,

    /**
     * LIKE '值%'
     * 例: likeRight("name", "王")--->name like '王%'
     */
    LIKE_RIGHT,

    /**
     * NOT LIKE '%值'
     * 例: notLikeLeft("name", "王")--->name not like '%王'
     */
    NOT_LIKE_LEFT,

    /**
     * notLikeRight(R column, Object val)
     * notLikeRight(boolean condition, R column, Object val)
     */
    NOT_LIKE_RIGHT,

    /**
     * 字段 IS NULL
     * 例: isNull("name")--->name is null
     */
    IS_NULL,

    /**
     * 字段 IS NOT NULL
     * 例: isNotNull("name")--->name is not null
     */
    IS_NOT_NULL,

    /**
     * 字段 IN (value.get(0), value.get(1), ...)
     * 例: in("age",{1,2,3})--->age in (1,2,3)
     */
    IN,

    /**
     * 字段 NOT IN (value.get(0), value.get(1), ...)
     * 例: notIn("age",{1,2,3})--->age not in (1,2,3)
     */
    NOT_IN,

    /**
     * 排序：ORDER BY 字段, ...
     * 例: orderBy(true, true, "id", "name")--->order by id ASC,name ASC
     */
    ORDER_BY,

    /**
     * 排序：ORDER BY 字段, ... ASC
     * 例: orderByAsc("id", "name")--->order by id ASC,name ASC
     */
    ORDER_BY_ASC,

    /**
     * 排序：ORDER BY 字段, ... DESC
     * 例: orderByDesc("id", "name")--->order by id DESC,name DESC
     */
    ORDER_BY_DESC,

}
