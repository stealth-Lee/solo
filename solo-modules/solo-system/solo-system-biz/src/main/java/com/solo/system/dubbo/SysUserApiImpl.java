package com.solo.system.dubbo;

import com.mybatisflex.core.query.QueryChain;
import com.solo.system.api.SysUserApi;
import com.solo.system.api.entity.SysUser;
import com.solo.system.mapper.SysMenuMapper;
import com.solo.system.mapper.SysRoleMapper;
import com.solo.system.mapper.SysUserMapper;
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
import static com.solo.system.api.entity.table.SysUserTableDef.SysUserTable;

@Service
@DubboService
public class SysUserApiImpl implements SysUserApi {

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public SysUser query(String username) {
        return QueryChain.of(sysUserMapper).where(SysUserTable.Username.eq(username)).one();
    }

    @Override
    public Set<String> selectRolePermission(Long userId) {
        List<String> codes = QueryChain.of(sysRoleMapper).select(SysRoleTable.Code).from(SysRoleTable)
                .leftJoin(SysUserRoleTable).on(SysRoleTable.RoleId.eq(SysUserRoleTable.RoleId))
                .where(SysUserRoleTable.UserId.eq(userId)).listAs(String.class);
        return new HashSet<>(codes);
    }

    @Override
    public Set<String> selectMenuPermission(Long userId) {
        List<String> menuPermission = QueryChain.of(sysMenuMapper).select(SysMenuTable.Permission).from(SysMenuTable)
                .leftJoin(SysRoleMenuTable).on(SysMenuTable.MenuId.eq(SysRoleMenuTable.MenuId))
                .leftJoin(SysUserRoleTable).on(SysRoleMenuTable.RoleId.eq(SysUserRoleTable.RoleId))
                .leftJoin(SysRoleTable).on(SysUserRoleTable.RoleId.eq(SysRoleTable.RoleId))
                .where(SysUserRoleTable.UserId.eq(userId))
                .listAs(String.class);
        return new HashSet<>(menuPermission);
    }
}
