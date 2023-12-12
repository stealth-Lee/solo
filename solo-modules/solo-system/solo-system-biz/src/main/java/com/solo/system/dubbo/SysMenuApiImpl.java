package com.solo.system.dubbo;

import com.mybatisflex.core.query.QueryChain;
import com.solo.system.api.SysMenuApi;
import com.solo.system.mapper.SysMenuMapper;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.solo.system.api.entity.table.SysMenuTableDef.SysMenuTable;
import static com.solo.system.api.entity.table.SysRoleMenuTableDef.SysRoleMenuTable;
import static com.solo.system.api.entity.table.SysRoleTableDef.SysRoleTable;
import static com.solo.system.api.entity.table.SysUserRoleTableDef.SysUserRoleTable;

/**
 * 系统菜单远程调用实现类
 * @author 十一
 * @since 2023/11/30 10:54
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
@DubboService
public class SysMenuApiImpl implements SysMenuApi {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public Set<String> selectMenuPermissions(Long userId) {
        List<String> menuPermission = QueryChain.of(sysMenuMapper).select(SysMenuTable.Permission).from(SysMenuTable)
                .leftJoin(SysRoleMenuTable).on(SysMenuTable.MenuId.eq(SysRoleMenuTable.MenuId))
                .leftJoin(SysUserRoleTable).on(SysRoleMenuTable.RoleId.eq(SysUserRoleTable.RoleId))
                .leftJoin(SysRoleTable).on(SysUserRoleTable.RoleId.eq(SysRoleTable.RoleId))
                .where(SysUserRoleTable.UserId.eq(userId))
                .listAs(String.class);
        return new HashSet<>(menuPermission);
    }

}
