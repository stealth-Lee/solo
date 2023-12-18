package com.solo.system.model.operate;

import com.solo.system.api.entity.SysOperateLog;
import com.solo.system.model.operate.req.OperateLogCreateReq;
import com.solo.system.model.operate.req.OperateLogUpdateReq;
import com.solo.system.model.operate.resp.OperateLogGetResp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 操作日志实体转换类
 * @author 十一
 * @since 2023-12-14 15:18
 * 人生若只如初见，何事秋风悲画扇
 **/
@Mapper
public interface SysOperateLogConvert {

    SysOperateLogConvert INSTANCE = Mappers.getMapper(SysOperateLogConvert.class);

    SysOperateLog convert(OperateLogCreateReq bean);

    SysOperateLog convert(OperateLogUpdateReq bean);

    OperateLogGetResp convertGet(SysOperateLog bean);

}
