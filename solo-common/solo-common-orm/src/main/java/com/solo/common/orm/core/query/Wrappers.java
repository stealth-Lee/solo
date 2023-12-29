package com.solo.common.orm.core.query;

import cn.hutool.core.text.NamingCase;
import cn.hutool.core.util.ReflectUtil;
import com.mybatisflex.core.query.*;
import com.solo.common.core.utils.AnnotationUtils;
import com.solo.common.core.utils.ObjectUtils;
import com.solo.common.core.utils.StringUtils;
import com.solo.common.orm.core.query.anno.Query;
import com.solo.common.orm.core.query.enums.ColumnStyle;
import com.solo.common.orm.core.query.enums.Connector;
import com.solo.common.orm.exception.NotFoundAnnoException;

import java.lang.reflect.Field;

/**
 * 查询条件包装工具类
 * @author 十一
 * @since 2023/09/19 10:24
 * 人生若只如初见，何事秋风悲画扇
 **/
public class Wrappers {

    /**
     * 构建查询条件包装器
     * @param entity 查询实体
     * @return 查询条件包装器
     */
    public static QueryWrapper builder(Object entity) {
        QueryWrapper queryWrapper = QueryWrapper.create();
        Class<?> clas = entity.getClass();
        com.solo.common.orm.core.query.anno.Wrappers wrappers = AnnotationUtils.getAnnotation(clas, com.solo.common.orm.core.query.anno.Wrappers.class);
        if (ObjectUtils.isNull(wrappers)) {
            throw new NotFoundAnnoException("orm", String.format("在类[%s], 未找到 @Wrappers 注解", clas.getName()));
        }
        Field[] fields = ReflectUtil.getFields(clas);
        for (Field field : fields) {
            // 排序方式
//            OrderBy orderBy = AnnotationUtils.getAnnotation(field, OrderBy.class);
//            if (ObjectUtils.isNotNull(orderBy)) {
//                queryWrapper.orderBy(columnName, orderBy.value().equals(Order.ASC));
//            }
            Object fieldValue = ReflectUtil.getFieldValue(entity, field);
            Query query = AnnotationUtils.getAnnotation(field, Query.class);
            if (ObjectUtils.isEmpty(fieldValue) || ObjectUtils.isNull(query)) continue;
            // 如果指定了@Query注解的value,则直接使用value作为列名，否则默认使用字段名转@Wrappers style风格作为列名
            String columnName = StringUtils.isNotBlank(query.value()) ? query.value() : toColumnName(field.getName(), wrappers.style());
            QueryColumn column = new QueryColumn(columnName);
            String alias = query.alias();
            if (StringUtils.isNotBlank(alias)) {
                column.setTable(new QueryTable(alias));
            }
            QueryCondition condition = initCondition(query, column, fieldValue);
            if (query.connector().equals(Connector.AND)) {
                queryWrapper.and(condition);
            } else {
                queryWrapper.or(condition);
            }
        }
        return queryWrapper;
    }

    /**
     * 将字段名转换为指定风格的列名
     * 如果需要拓展其他风格，可以在这里添加，并在 {@link ColumnStyle} 中添加枚举值
     * @param fieldName 字段名称
     * @param style     风格
     * @return {@link String}
     */
    private static String toColumnName(String fieldName, ColumnStyle style) {
        return switch (style) {
            case camel_to_underline -> NamingCase.toUnderlineCase(fieldName);
            case PascalCase -> NamingCase.toPascalCase(fieldName);
            default -> fieldName;
        };
    }

    /**
     * 初始化查询条件
     * @param query 查询注解
     * @param column 查询列
     * @param fieldValue 字段值
     * @return 查询条件
     */
    private static QueryCondition initCondition(Query query, QueryColumn column, Object fieldValue) {
        return switch (query.mode()) {
            case NE -> column.ne(fieldValue);
            case GT -> column.gt(fieldValue);
            case GE -> column.ge(fieldValue);
            case LT -> column.lt(fieldValue);
            case LE -> column.le(fieldValue);
            case BETWEEN -> {
                try {
                    Object[] values = (Object[]) fieldValue;
                    yield column.between(values[0], values[1]);
                } catch (Exception e) {
                    // TODO 这里异常优化一下
                    throw new RuntimeException("BETWEEN 模式下，字段值必须为数组");
                }
            }
            case LIKE -> column.like(fieldValue);
            case NOT_LIKE -> column.notLike(fieldValue);
            case LIKE_LEFT -> column.likeLeft(fieldValue);
            case LIKE_RIGHT -> column.likeRight(fieldValue);
            case NOT_LIKE_LEFT -> column.notLikeLeft(fieldValue);
            case NOT_LIKE_RIGHT -> column.notLikeRight(fieldValue);
            case IS_NULL -> column.isNull();
            case IS_NOT_NULL -> column.isNotNull();
            case IN -> column.in(fieldValue);
            case NOT_IN -> column.notIn(fieldValue);
            default -> column.eq(fieldValue);
        };
    }

}
