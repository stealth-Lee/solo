package com.solo.auth.model.auth.resp;

import lombok.Data;

import java.util.List;

/**
 * 登录响应对象
 * @author 十一
 * @since 2023/11/15 10:26
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class LoginResp {

    /**
     * 授权令牌
     */
    private String accessToken;

    /**
     * 刷新令牌
     */
    private String refreshToken;

    /**
     * 授权令牌 access_token 的有效期
     */
    private Long expires;

    /**
     * 刷新令牌 refresh_token 的有效期
     */
    private Long refreshExpires;

    /**
     * 角色集合
     */
    private List<String> roles;

    /**
     * 用户名
     */
    private String username;

}
