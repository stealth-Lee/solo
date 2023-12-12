package com.solo.system.api;

import com.solo.system.api.entity.SysUser;

/**
 * 系统用户远程调用API
 * @author 十一
 * @since 2023/11/30 10:49
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface SysUserApi {

    public SysUser query(String username);

}
