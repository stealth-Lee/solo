package com.solo.system.model.log.login;

import com.solo.system.api.entity.SysLogLogin;
import com.solo.system.model.log.login.resp.LogLoginGetResp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 操作日志实体转换类
 * @author 十一
 * @since 2023-12-14 15:18
 * 人生若只如初见，何事秋风悲画扇
 **/
@Mapper
public interface SysLogLoginConvert {

    SysLogLoginConvert INSTANCE = Mappers.getMapper(SysLogLoginConvert.class);

    LogLoginGetResp convertGet(SysLogLogin bean);

}
