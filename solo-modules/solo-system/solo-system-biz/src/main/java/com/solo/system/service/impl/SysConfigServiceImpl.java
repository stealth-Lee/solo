package com.solo.system.service.impl;

import com.solo.common.orm.base.service.impl.BasicServiceImpl;
import com.solo.system.api.entity.SysConfig;
import com.solo.system.mapper.SysConfigMapper;
import com.solo.system.service.SysConfigService;
import org.springframework.stereotype.Service;

/**
 * 系统配置表 Service实现类
 * @author 十一
 * @since 2023-10-18 16:33
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
public class SysConfigServiceImpl extends BasicServiceImpl<SysConfigMapper, SysConfig> implements SysConfigService {

}
