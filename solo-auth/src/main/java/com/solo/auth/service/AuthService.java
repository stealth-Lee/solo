package com.solo.auth.service;

import com.solo.auth.model.auth.req.LoginReq;
import com.solo.auth.model.auth.resp.LoginResp;

/**
 * 授权认证服务接口
 * @author 十一
 * @since 2023/11/24 11:16
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface AuthService {

    LoginResp login(LoginReq loginReq);

}
