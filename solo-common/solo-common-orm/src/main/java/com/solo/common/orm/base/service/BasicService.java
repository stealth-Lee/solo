package com.solo.common.orm.base.service;

import com.mybatisflex.core.service.IService;

import java.util.List;

/**
 * 基础Service,扩展mybatis-flex的IService
 * @param <T> Entity
 * @author 十一
 * @date 2023/08/30 15:30
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface BasicService<T> extends IService<T> {

    default <R> List<R> listAs(Class<R> asType) {
        return IService.super.listAs(this.query(), asType);
    }

}
