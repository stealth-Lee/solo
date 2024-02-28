package com.solo.system.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.update.UpdateChain;
import com.solo.common.core.base.service.impl.BasicServiceImpl;
import com.solo.common.core.utils.NumberUtils;
import com.solo.common.core.utils.StringUtils;
import com.solo.satoken.model.LoginUser;
import com.solo.satoken.utils.LoginHelper;
import com.solo.system.api.entity.SysUser;
import com.solo.system.mapper.SysUserMapper;
import com.solo.system.model.user.SysUserConvert;
import com.solo.system.model.user.req.ChangePasswordReq;
import com.solo.system.model.user.req.UserCreateReq;
import com.solo.system.model.user.req.ResetPasswordReq;
import com.solo.system.model.user.req.UserUpdateReq;
import com.solo.system.model.user.resp.UserGetResp;
import com.solo.system.service.SysUserPostService;
import com.solo.system.service.SysUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

import static com.solo.common.core.utils.ServiceExceptionUtil.exception;
import static com.solo.system.api.consts.SystemCode.*;
import static com.solo.system.api.entity.table.SysUserPostTableDef.SysUserPostTable;
import static com.solo.system.api.entity.table.SysUserTableDef.SysUserTable;

/**
 * 用户Service实现类
 * @author 十一
 * @since 2023/09/04 17:27
 * 人生若只如初见，何事秋风悲画扇
 **/
@Slf4j
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BasicServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private final SysUserPostService sysUserPostService;

    @Override
    @Transactional
    public boolean create(UserCreateReq req) {
        SysUser entity = SysUserConvert.INSTANCE.convert(req);
        long count = QueryChain.of(mapper).where(SysUserTable.Username.eq(entity.getUsername())).count();
        if (NumberUtils.isPositiveInteger(count)) {
            throw exception(USERNAME_EXISTS);
        }
        entity.setPassword(BCrypt.hashpw(entity.getPassword()));
        save(entity);
        sysUserPostService.save(entity.getUserId(), req.getPostIds());
        return true;
    }

    @Override
    @Transactional
    public void resetPassword(ResetPasswordReq req) {
        SysUser sysUser = mapper.selectOneById(req.getUserId());
        if (Objects.isNull(sysUser)) {
            throw exception(USERNAME_EXISTS);
        }
        String password = BCrypt.hashpw(req.getPassword());
        UpdateChain.of(SysUser.class).set(SysUserTable.Password, password)
                .where(SysUserTable.UserId.eq(sysUser.getUserId())).update();
    }

    @Override
    @Transactional
    public void changePassword(ChangePasswordReq req) {
        LoginUser loginUser = LoginHelper.getLoginUser();
        if (Objects.isNull(loginUser)) {
            throw exception(USER_NOT_LOGIN);
        }
        if (!BCrypt.checkpw(req.getOldPassword(), loginUser.getPassword())) {
            throw exception(OLD_PASSWORD_ERROR);
        }
        if (!StringUtils.equals(req.getNewPassword(), req.getConfirmPassword())) {
            throw exception(PASSWORD_NOT_EQUALS);
        }
        if (StringUtils.equals(req.getNewPassword(), req.getOldPassword())) {
            throw exception(NEW_PASSWORD_EQUALS_OLD);
        }
        // TODO 修改密码错误次数达到一定时，锁定账号
        String newPassword = BCrypt.hashpw(req.getNewPassword());
        UpdateChain.of(SysUser.class).set(SysUserTable.Password, newPassword)
                .where(SysUserTable.UserId.eq(loginUser.getUserId())).update();
    }

    @Override
    @Transactional
    public boolean update(UserUpdateReq req) {
        SysUser entity = SysUserConvert.INSTANCE.convert(req);
        sysUserPostService.updateChain().where(SysUserPostTable.UserId.eq(req.getUserId())).remove();
        sysUserPostService.save(req.getUserId(), req.getPostIds());
        return super.updateById(entity);
    }

    @Override
    public UserGetResp queryByUserId(Long userId) {
        QueryWrapper queryWrapper = QueryWrapper.create().select(SysUserTable.DefaultColumns)
                .where(SysUserTable.UserId.eq(userId));
        return mapper.selectOneWithRelationsByQueryAs(queryWrapper, UserGetResp.class);
    }

}
