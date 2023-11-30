package com.solo.auth.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.StpUtil;
import com.solo.auth.model.auth.LoginConvert;
import com.solo.auth.model.auth.req.LoginReq;
import com.solo.auth.service.AuthService;
import com.solo.satoken.model.LoginUser;
import com.solo.satoken.utils.LoginHelper;
import com.solo.system.api.SysUserApi;
import com.solo.system.api.entity.SysUser;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.solo.common.core.utils.ServiceExceptionUtil.exception;

/**
 * 账号密码认证实现类
 * @author Gentleman.Lee
 * @since 2023/11/24 11:16
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
public class PasswordAuthServiceImpl implements AuthService {

    @DubboReference
    private SysUserApi sysUserApi;

    /**
     * 登录实现
     * @param loginReq 登录请求对象
     * @return 登录token
     */
    @Override
    public String login(LoginReq loginReq) {
        SysUser sysUser = sysUserApi.query(loginReq.getUsername());
        if (!BCrypt.checkpw(loginReq.getPassword(), sysUser.getPassword())) {
            throw exception("密码错误");
        }
        LoginUser loginUser = LoginConvert.INSTANCE.convert(sysUser);
        Set<String> codes = sysUserApi.selectRolePermission(loginUser.getUserId());
        loginUser.setRolePermission(codes);
        Set<String> menus = sysUserApi.selectMenuPermission(loginUser.getUserId());
        loginUser.setMenuPermission(menus);
        SaLoginModel model = new SaLoginModel();
        model.setDevice("PC");
        LoginHelper.login(loginUser, model);
        return StpUtil.getTokenValue();
    }

}
