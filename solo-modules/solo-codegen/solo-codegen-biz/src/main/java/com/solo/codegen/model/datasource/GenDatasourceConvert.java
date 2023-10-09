package com.solo.codegen.model.datasource;

import com.solo.codegen.api.entity.GenDatasource;
import com.solo.codegen.model.datasource.req.DatasourceCreateReq;
import com.solo.codegen.model.datasource.req.DatasourceUpdateReq;
import com.solo.codegen.model.datasource.resp.DatasourceGetResp;
import org.mapstruct.factory.Mappers;

public interface GenDatasourceConvert {

    GenDatasourceConvert INSTANCE = Mappers.getMapper(GenDatasourceConvert.class);

    GenDatasource convert(DatasourceCreateReq req);
    
    GenDatasource convert(DatasourceUpdateReq req);

    DatasourceGetResp convertGet(GenDatasource byId);
}
