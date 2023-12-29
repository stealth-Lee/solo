package com.solo.system.service;

import com.solo.common.core.base.service.BasicService;
import com.solo.system.api.entity.SysRoleMenu;
import com.solo.system.model.role.req.RoleMenuReq;

import java.util.Set;

/**
 * 角色菜单关联 Service
 * @author 十一
 * @since 2023-12-25 16:57
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface SysRoleMenuService extends BasicService<SysRoleMenu> {

    /**
     * 为角色分配菜单权限
     * @param req 要求
     * @return boolean
     */
    boolean assignMenu(RoleMenuReq req);

    /**
     * 查询指定角色的菜单id集合
     * @param roleId 角色id
     * @return 拥有的菜单id集合
     */
    Set<Long> selectMenuIds(Long roleId);

}
