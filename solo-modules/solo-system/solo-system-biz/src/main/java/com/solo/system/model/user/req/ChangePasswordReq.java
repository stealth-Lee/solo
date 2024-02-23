package com.solo.system.model.user.req;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 修改密码请求对象
 */
@Data
public class ChangePasswordReq {

    /**
     * 旧密码
     */
    @NotNull(message = "{user.required.oldPassword}")
    @Size(message = "{user.size.oldPassword}", max = 64)
    private String oldPassword;

    /**
     * 新密码
     */
    @NotNull(message = "{user.required.newPassword}")
    @Size(message = "{user.size.newPassword}", max = 64)
    private String newPassword;

    /**
     * 确认密码
     */
    @NotNull(message = "{user.required.confirmPassword}")
    @Size(message = "{user.size.confirmPassword}", max = 64)
    private String confirmPassword;

}
