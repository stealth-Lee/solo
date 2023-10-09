package com.solo.codegen.service.impl;

import com.solo.codegen.api.entity.GenDatasource;
import com.solo.codegen.mapper.GenDatasourceMapper;
import com.solo.codegen.service.GenDatasourceService;
import com.solo.common.orm.base.service.impl.BasicServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 代码生成数据源Service实现类
 * @author 十一
 * @since 2023/10/08 17:34
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
public class GenDatasourceServiceImpl extends BasicServiceImpl<GenDatasourceMapper, GenDatasource> implements GenDatasourceService {

    @Override
    public boolean create(GenDatasource entity) {
        return false;
    }

    @Override
    public boolean update(GenDatasource entity) {
        return false;
    }

}
