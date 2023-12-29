package com.solo.system.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.core.update.UpdateChain;
import com.solo.common.core.base.service.impl.BasicServiceImpl;
import com.solo.common.core.utils.NumberUtils;
import com.solo.system.api.entity.SysUser;
import com.solo.system.mapper.SysUserMapper;
import com.solo.system.model.user.req.UserResetPasswordReq;
import com.solo.system.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

import static com.solo.common.core.utils.ServiceExceptionUtil.exception;
import static com.solo.system.api.entity.table.SysUserTableDef.SysUserTable;
import static com.solo.system.api.consts.SystemCode.*;

/**
 * 用户Service实现类
 * @author 十一
 * @since 2023/09/04 17:27
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
public class SysUserServiceImpl extends BasicServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    @Transactional
    public boolean create(SysUser entity) {
        long count = QueryChain.of(mapper).where(SysUserTable.Username.eq(entity.getUsername())).count();
        if (NumberUtils.isPositiveInteger(count)) {
            throw exception(USERNAME_EXISTS);
        }
        entity.setPassword(BCrypt.hashpw(entity.getPassword()));
        return super.save(entity);
    }

    @Override
    @Transactional
    public void resetPassword(UserResetPasswordReq req) {
        SysUser sysUser = mapper.selectOneById(req.getUserId());
        if (Objects.isNull(sysUser)) {
            throw exception(USERNAME_EXISTS);
        }
        String password = BCrypt.hashpw(req.getPassword());
        UpdateChain.of(SysUser.class).set(SysUserTable.Password, password)
                .where(SysUserTable.UserId.eq(sysUser.getUserId())).update();
    }

    @Override
    public boolean update(SysUser entity) {
        return super.updateById(entity);
    }

}
