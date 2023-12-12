package com.solo.system.api;

import com.solo.system.api.entity.SysConfig;

/**
 * 系统配置Api接口类
 * @author 十一
 * @since 2023/12/11 17:18
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface SysConfigApi {

    SysConfig selectConfigByKey(String key);

}
