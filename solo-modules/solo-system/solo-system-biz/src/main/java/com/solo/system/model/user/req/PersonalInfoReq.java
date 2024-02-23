package com.solo.system.model.user.req;

import com.solo.system.api.consts.user.Sex;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 个人信息请求对象
 */
@Data
public class PersonalInfoReq {

    /**
     * 用户id
     */
    @NotNull(message = "{user.required.userId}")
    private Long userId;

    /**
     * 用户昵称
     */
    @NotBlank(message = "{user.required.nickname}")
    @Size(message = "{user.size.nickname}", max = 32)
    private String nickname;

    /**
     * 用户姓名
     */
    @Size(message = "{user.size.mobile}", max = 16)
    private String name;

    /**
     * 用户性别
     */
    private Sex sex;

    /**
     * 用户电话
     */
    @Size(message = "{user.size.mobile}", max = 16)
    private String mobile;

    /**
     * 用户邮箱
     */
    @Email(message = "{user.format.email}")
    @Size(message = "{user.size.email}", max = 64)
    private String email;

    /**
     * 头像地址
     */
    @Size(message = "{user.size.avatar}", max = 512)
    private String avatar;

}
