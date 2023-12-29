package com.solo.common.core.base.service.impl;

import com.mybatisflex.core.BaseMapper;
import com.mybatisflex.core.query.QueryWrapper;
import com.solo.common.core.base.mapper.BasicMapper;
import com.solo.common.core.base.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 基础Service实现类,扩展BaseServiceImpl
 * @param <M> Mapper
 * @param <T> Entity
 * @author 十一
 * @date 2023/08/30 15:30
 * 人生若只如初见，何事秋风悲画扇
 */
public class BasicServiceImpl<M extends BasicMapper<T>, T> implements BasicService<T> {

    @Autowired
    protected M mapper;

    public BasicServiceImpl() {
    }

    public BaseMapper<T> getMapper() {
        return this.mapper;
    }

    @Override
    public List<T> list(QueryWrapper query) {
        //获取当前用户信息，为 queryWrapper 添加额外的条件
        return BasicService.super.list(query);
    }

}
