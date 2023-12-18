package com.solo.system.service;

import com.solo.common.core.base.service.BasicService;
import com.solo.system.api.entity.SysRole;

/**
 * 系统角色Service接口类
 * @author 十一
 * @since 2023/09/22 17:28
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface SysRoleService extends BasicService<SysRole> {

    boolean create(SysRole entity);

    boolean update(SysRole entity);

}
