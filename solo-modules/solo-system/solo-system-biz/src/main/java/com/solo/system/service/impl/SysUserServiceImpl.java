package com.solo.system.service.impl;

import com.mybatisflex.core.query.QueryChain;
import com.solo.common.core.utils.NumberUtils;
import com.solo.common.core.base.service.impl.BasicServiceImpl;
import com.solo.system.api.entity.SysUser;
import com.solo.system.mapper.SysUserMapper;
import com.solo.system.service.SysUserService;
import org.springframework.stereotype.Service;

import static com.solo.common.core.utils.ServiceExceptionUtil.exception;
import static com.solo.system.api.entity.table.SysUserTableDef.SysUserTable;

/**
 * 用户Service实现类
 * @author 十一
 * @since 2023/09/04 17:27
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
public class SysUserServiceImpl extends BasicServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public boolean create(SysUser entity) {
        long count = QueryChain.of(mapper).where(SysUserTable.Username.eq(entity.getUsername())).count();
        if (NumberUtils.isPositiveInteger(count)) {
            throw exception("用户名已存在");
        }
        return super.save(entity);
    }

    @Override
    public boolean update(SysUser entity) {
        return super.updateById(entity);
    }

}
