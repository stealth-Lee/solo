package com.solo.system.service.impl;

import com.solo.common.orm.base.service.impl.BasicServiceImpl;
import com.solo.system.api.entity.SysUser;
import com.solo.system.mapper.SysUserMapper;
import com.solo.system.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * 用户Service实现类
 * @author 十一
 * @since 2023/09/04 17:27
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
public class SysUserServiceImpl extends BasicServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
