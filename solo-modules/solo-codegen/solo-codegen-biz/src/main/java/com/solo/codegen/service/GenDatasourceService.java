package com.solo.codegen.service;

import com.solo.codegen.api.entity.GenDatasource;
import com.solo.common.orm.base.service.BasicService;

/**
 * 代码生成数据源Service接口类
 * @author 十一
 * @since 2023/10/08 17:33
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface GenDatasourceService extends BasicService<GenDatasource> {

    boolean create(GenDatasource entity);

    boolean update(GenDatasource entity);
}
