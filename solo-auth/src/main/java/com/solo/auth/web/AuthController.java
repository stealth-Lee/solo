package com.solo.auth.web;

import cn.dev33.satoken.stp.StpUtil;
import com.solo.auth.model.auth.req.LoginReq;
import com.solo.auth.model.auth.resp.LoginResp;
import com.solo.auth.service.AuthService;
import com.solo.common.core.global.R;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * token认证控制器
 * @author 十一
 * @since 2023/11/24 11:02
 * 人生若只如初见，何事秋风悲画扇
 **/
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private AuthService loginService;

    /**
     * 登录
     * @param loginReq 登录请求
     * @return {@link String}
     */
    @PostMapping("/login")
    public R<LoginResp> login(@Valid @RequestBody LoginReq loginReq) {
        return R.success(loginService.login(loginReq));
    }

    /**
     * 退出登录
     */
    @DeleteMapping("/logout")
    public void logout() {
        StpUtil.logout();
    }

}
