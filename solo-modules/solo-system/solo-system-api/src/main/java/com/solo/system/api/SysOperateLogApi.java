package com.solo.system.api;

import com.solo.system.api.entity.SysOperateLog;

/**
 * 操作日志api
 * @author Gentleman.Lee
 * @since 2023/12/15 10:40
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface SysOperateLogApi {

    public int save(SysOperateLog entity);

}
