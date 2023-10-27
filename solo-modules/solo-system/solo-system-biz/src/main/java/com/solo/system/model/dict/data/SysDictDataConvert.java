package com.solo.system.model.dict.data;

import com.solo.system.api.entity.SysDictData;
import com.solo.system.model.dict.data.req.DictDataCreateReq;
import com.solo.system.model.dict.data.req.DictDataUpdateReq;
import com.solo.system.model.dict.data.req.DictDataUpdateStatusReq;
import com.solo.system.model.dict.data.resp.DictDataGetResp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 字典数据实体转换类
 * @author 十一
 * @since 2023-10-27 16:08
 * 人生若只如初见，何事秋风悲画扇
 **/
@Mapper
public interface SysDictDataConvert {

    SysDictDataConvert INSTANCE = Mappers.getMapper(SysDictDataConvert.class);

    SysDictData convert(DictDataCreateReq bean);

    SysDictData convert(DictDataUpdateStatusReq req);

    SysDictData convert(DictDataUpdateReq bean);

    DictDataGetResp convertGet(SysDictData bean);

}
