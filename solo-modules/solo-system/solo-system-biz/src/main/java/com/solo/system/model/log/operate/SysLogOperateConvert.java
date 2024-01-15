package com.solo.system.model.log.operate;

import com.solo.system.api.entity.SysLogOperate;
import com.solo.system.model.log.operate.resp.LogOperateGetResp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 操作日志实体转换类
 * @author 十一
 * @since 2023-12-14 15:18
 * 人生若只如初见，何事秋风悲画扇
 **/
@Mapper
public interface SysLogOperateConvert {

    SysLogOperateConvert INSTANCE = Mappers.getMapper(SysLogOperateConvert.class);

    LogOperateGetResp convertGet(SysLogOperate bean);

}
