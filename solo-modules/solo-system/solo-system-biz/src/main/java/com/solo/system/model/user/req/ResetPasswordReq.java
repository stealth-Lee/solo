package com.solo.system.model.user.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 用户重置密码请求对象
 * @author 十一
 * @since 2023/12/19 15:39
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class ResetPasswordReq {

    /**
     * 用户id
     */
    @NotNull(message = "{user.required.userId}")
    private Long userId;

    /**
     * 新密码
     */
    @NotBlank(message = "{user.required.newPassword}")
    @Size(message = "{user.size.newPassword}", max = 64)
    private String password;

}
