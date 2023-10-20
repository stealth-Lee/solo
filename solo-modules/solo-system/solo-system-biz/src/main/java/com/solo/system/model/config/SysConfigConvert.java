package com.solo.system.model.config;

import com.solo.system.api.entity.SysConfig;
import com.solo.system.model.config.req.ConfigCreateReq;
import com.solo.system.model.config.req.ConfigUpdateReq;
import com.solo.system.model.config.resp.ConfigGetResp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 系统配置实体转换类
 * @author 十一
 * @since 2023-10-18 16:46
 * 人生若只如初见，何事秋风悲画扇
 **/
@Mapper
public interface SysConfigConvert {

    SysConfigConvert INSTANCE = Mappers.getMapper(SysConfigConvert.class);

    SysConfig convert(ConfigCreateReq bean);

    SysConfig convert(ConfigUpdateReq bean);

    ConfigGetResp convertGet(SysConfig bean);

}
