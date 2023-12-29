package com.solo.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.core.update.UpdateChain;
import com.solo.common.core.base.service.impl.BasicServiceImpl;
import com.solo.system.api.entity.SysRoleMenu;
import com.solo.system.mapper.SysRoleMenuMapper;
import com.solo.system.model.role.req.RoleMenuReq;
import com.solo.system.service.SysRoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.solo.system.api.entity.table.SysRoleMenuTableDef.SysRoleMenuTable;

/**
 * 角色菜单关联 Service实现类
 * @author 十一
 * @since 2023-12-25 16:57
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
public class SysRoleMenuServiceImpl extends BasicServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean assignMenu(RoleMenuReq req) {
        UpdateChain.of(mapper).where(SysRoleMenuTable.RoleId.eq(req.getRoleId())).remove();
        Set<Long> menuIds = req.getMenuIds();
        if (CollUtil.isEmpty(menuIds)) {
            return Boolean.TRUE;
        }
        List<SysRoleMenu> sysRoleMenus = menuIds.stream().map(menuId -> {
            SysRoleMenu roleMenu = new SysRoleMenu();
            roleMenu.setRoleId(req.getRoleId());
            roleMenu.setMenuId(menuId);
            return roleMenu;
        }).toList();
        mapper.insertBatch(sysRoleMenus);
        return Boolean.TRUE;
    }

    @Override
    public Set<Long> selectMenuIds(Long roleId) {
        List<Long> menuIds = QueryChain.of(mapper)
                .select(SysRoleMenuTable.MenuId)
                .where(SysRoleMenuTable.RoleId.eq(roleId)).listAs(Long.class);
        return new HashSet<>(menuIds);
    }

}