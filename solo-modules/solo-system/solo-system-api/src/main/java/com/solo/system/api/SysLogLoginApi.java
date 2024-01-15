package com.solo.system.api;

import com.solo.system.api.entity.SysLogLogin;

/**
 * 登录日志api
 * @author 十一
 * @since 2024/01/02 15:43
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface SysLogLoginApi {

    public int save(SysLogLogin entity);

}
