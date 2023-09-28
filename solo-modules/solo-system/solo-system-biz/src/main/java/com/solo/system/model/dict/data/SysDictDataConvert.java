package com.solo.system.model.dict.data;

import com.solo.system.api.entity.SysDictData;
import com.solo.system.model.dict.data.req.DictDataCreateReq;
import com.solo.system.model.dict.data.req.DictDataUpdateReq;
import com.solo.system.model.dict.data.resp.DictDataGetResp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 字典数据转换类
 * @author 十一
 * @since 2023/09/26 11:33
 * 人生若只如初见，何事秋风悲画扇
 **/
@Mapper
public interface SysDictDataConvert {

    SysDictDataConvert INSTANCE = Mappers.getMapper(SysDictDataConvert.class);

    SysDictData convert(DictDataCreateReq req);

    SysDictData convert(DictDataUpdateReq req);

    DictDataGetResp convertGet(SysDictData entity);
}
