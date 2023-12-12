package com.solo.auth.model.auth.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 登录请求对象
 * @author 十一
 * @since 2023/11/15 10:20
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class LoginReq {

    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空")
    @Length(min = 3, max = 16, message = "用户名长度为 3-16 位")
    private String username;

    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    @Length(min = 6, max = 16, message = "密码长度为 6-16 位")
    private String password;

}
