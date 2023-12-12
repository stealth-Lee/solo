package com.solo.system.dubbo;

import com.mybatisflex.core.query.QueryChain;
import com.solo.system.api.SysRoleApi;
import com.solo.system.mapper.SysRoleMapper;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.solo.system.api.entity.table.SysRoleTableDef.SysRoleTable;
import static com.solo.system.api.entity.table.SysUserRoleTableDef.SysUserRoleTable;

/**
 * 系统角色远程调用实现类
 * @author 十一
 * @since 2023/11/30 10:51
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
@DubboService
public class SysRoleApiImpl implements SysRoleApi {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public Set<String> selectRolePermissions(Long userId) {
        List<String> codes = QueryChain.of(sysRoleMapper)
                .select(SysRoleTable.Code)
                .from(SysRoleTable)
                .leftJoin(SysUserRoleTable).on(SysRoleTable.RoleId.eq(SysUserRoleTable.RoleId))
                .where(SysUserRoleTable.UserId.eq(userId)).listAs(String.class);
        return new HashSet<>(codes);
    }

}
