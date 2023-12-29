package com.solo.system.service.impl;

import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.core.update.UpdateChain;
import com.solo.common.core.utils.NumberUtils;
import com.solo.common.core.utils.ObjectUtils;
import com.solo.common.core.base.service.impl.BasicServiceImpl;
import com.solo.system.api.entity.SysRole;
import com.solo.system.mapper.SysRoleMapper;
import com.solo.system.model.role.req.RoleMenuReq;
import com.solo.system.service.SysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.solo.common.core.utils.ServiceExceptionUtil.exception;
import static com.solo.system.api.entity.table.SysRoleTableDef.SysRoleTable;
import static com.solo.system.api.consts.SystemCode.ROLE_CODE_EXISTS;

/**
 * 系统角色Service实现类
 * @author 十一
 * @since 2023/09/22 17:29
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
public class SysRoleServiceImpl extends BasicServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Override
    public boolean create(SysRole entity) {
        long count = QueryChain.of(mapper).where(SysRoleTable.Code.eq(entity.getCode())).count();
        if (NumberUtils.isPositiveInteger(count)) {
            throw exception(ROLE_CODE_EXISTS);
        }
        return super.save(entity);
    }

    @Override
    public boolean update(SysRole entity) {
        SysRole result = QueryChain.of(mapper).select(SysRoleTable.RoleId)
                .where(SysRoleTable.Code.eq(entity.getCode())).one();
        if (ObjectUtils.isNotEmpty(result) && !result.getRoleId().equals(entity.getRoleId())) {
            throw exception(ROLE_CODE_EXISTS);
        }
        return super.updateById(entity);
    }

}
