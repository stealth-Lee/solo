package com.solo.common.orm.core.query;

import cn.hutool.core.util.ReflectUtil;
import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.query.QueryCondition;
import com.mybatisflex.core.query.QueryTable;
import com.mybatisflex.core.query.QueryWrapper;
import com.solo.common.core.exception.NotFoundAnnoException;
import com.solo.common.core.utils.AnnotationUtils;
import com.solo.common.core.utils.ObjectUtils;
import com.solo.common.core.utils.StringUtils;
import com.solo.common.orm.core.query.anno.Query;
import com.solo.common.orm.core.query.enums.Connector;

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
    public static QueryWrapper buildWhere(Object entity) {
        QueryWrapper queryWrapper = QueryWrapper.create();
        Class<?> clas = entity.getClass();
        com.solo.common.orm.core.query.anno.Wrappers wrappers = AnnotationUtils.getAnnotation(clas, com.solo.common.orm.core.query.anno.Wrappers.class);
        if (ObjectUtils.isNull(wrappers)) {
            throw new NotFoundAnnoException("orm", String.format("在类[%s], 未找到 @Wrappers 注解", clas.getName()));
        }
        Field[] fields = ReflectUtil.getFields(clas);
        for (Field field : fields) {
            Object fieldValue = ReflectUtil.getFieldValue(entity, field);
            Query query = AnnotationUtils.getAnnotation(field, Query.class);
            if (ObjectUtils.isEmpty(fieldValue) || ObjectUtils.isNull(query)) continue;
            String value = StringUtils.isNotBlank(query.value()) ? query.value() :
                    (wrappers.camelToUnderline() ? StringUtils.toUnderlineCase(field.getName()) : field.getName());
            QueryColumn column = new QueryColumn(value);
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
