package com.solo.system.model.dict.type;

import com.solo.system.api.entity.SysDictType;
import com.solo.system.model.dict.type.req.DictTypeCreateReq;
import com.solo.system.model.dict.type.req.DictTypeUpdateReq;
import com.solo.system.model.dict.type.resp.DictTypeGetResp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 字典类型转换类
 * @author 十一
 * @since 2023/09/22 16:26
 * 人生若只如初见，何事秋风悲画扇
 **/
@Mapper
public interface SysDictTypeConvert {

    SysDictTypeConvert INSTANCE = Mappers.getMapper(SysDictTypeConvert.class);

    SysDictType convert(DictTypeCreateReq req);

    SysDictType convert(DictTypeUpdateReq req);

    DictTypeGetResp convertGet(SysDictType entity);
}
