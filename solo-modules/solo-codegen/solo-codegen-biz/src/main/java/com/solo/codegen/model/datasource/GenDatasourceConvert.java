package com.solo.codegen.model.datasource;

import com.solo.codegen.api.entity.GenDatasource;
import com.solo.codegen.model.datasource.req.DatasourceCreateReq;
import com.solo.codegen.model.datasource.req.DatasourceUpdateReq;
import com.solo.codegen.model.datasource.resp.DatasourceGetResp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 数据源实体转换类
 * @author 十一
 * @since 2023/10/09 11:10
 * 人生若只如初见，何事秋风悲画扇
 **/
@Mapper
public interface GenDatasourceConvert {

    GenDatasourceConvert INSTANCE = Mappers.getMapper(GenDatasourceConvert.class);

    GenDatasource convert(DatasourceCreateReq req);
    
    GenDatasource convert(DatasourceUpdateReq req);

    DatasourceGetResp convertGet(GenDatasource entity);

}
