package com.solo.auth.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.date.DateUtil;
import com.solo.auth.model.auth.LoginConvert;
import com.solo.auth.model.auth.req.LoginReq;
import com.solo.auth.model.auth.resp.LoginResp;
import com.solo.auth.service.AuthService;
import com.solo.auth.service.LoginService;
import com.solo.satoken.model.LoginUser;
import com.solo.satoken.utils.LoginHelper;
import com.solo.system.api.SysMenuApi;
import com.solo.system.api.SysRoleApi;
import com.solo.system.api.SysUserApi;
import com.solo.system.api.entity.SysUser;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

import static com.solo.auth.consts.AuthCode.AUTH_USERNAME_PASSWORD_NOT_MATCH;
import static com.solo.common.core.utils.ServiceExceptionUtil.exception;

/**
 * 账号密码认证实现类
 * @author 十一
 * @since 2023/11/24 11:16
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
public class PasswordAuthServiceImpl implements AuthService {

    @DubboReference
    private SysUserApi sysUserApi;
    @DubboReference
    private SysRoleApi sysRoleApi;
    @DubboReference
    private SysMenuApi sysMenuApi;
    @Resource
    private LoginService loginService;

    /**
     * 账号密码登录实现
     * @param loginReq 登录请求对象
     * @return 登录token
     */
    @Override
    public LoginResp login(LoginReq loginReq) {
        SysUser sysUser = sysUserApi.query(loginReq.getUsername());
        if (!BCrypt.checkpw(loginReq.getPassword(), sysUser.getPassword())) {
            throw exception(AUTH_USERNAME_PASSWORD_NOT_MATCH);
        }
        LoginUser loginUser = LoginConvert.INSTANCE.convert(sysUser);
        Long userId = loginUser.getUserId();
        Set<String> roles = sysRoleApi.selectRolePermissions(userId);
        Set<String> menus = sysMenuApi.selectMenuPermissions(userId);
        loginUser.setRolePermissions(roles);
        loginUser.setMenuPermissions(menus);
        LoginHelper.login(loginUser);

        loginService.saveLoginLog(loginReq.getUsername());

        LoginResp loginResp = new LoginResp();
        loginResp.setUsername(loginUser.getUsername());
        loginResp.setRoles(new ArrayList<>(roles));
        loginResp.setAccessToken(StpUtil.getTokenValue());
        long expires = DateUtil.current() + StpUtil.getTokenTimeout() * 1000;
        loginResp.setExpires(expires);
        return loginResp;
    }

}
