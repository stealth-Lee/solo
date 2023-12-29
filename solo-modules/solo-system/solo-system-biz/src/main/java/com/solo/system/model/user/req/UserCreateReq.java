package com.solo.system.model.user.req;

import com.solo.system.api.consts.global.GlobalStatus;
import com.solo.system.api.consts.user.Sex;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 用户新增实体类
 * @author 十一
 * @since 2023/09/21 14:30
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class UserCreateReq {

    /**
     * 所属部门id
     */
    private Long deptId;

    /**
     * 用户名
     */
    @NotBlank(message = "{user.required.username}")
    @Size(message = "{user.size.username}", min = 4, max = 30)
    private String username;

    /**
     * 用户密码
     */
    @NotBlank(message = "{user.required.password}")
    @Size(message = "{user.size.password}", max = 64)
    private String password;

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
     * 帐号状态
     */
    @NotNull(message = "{user.required.status}")
    private GlobalStatus status;

    /**
     * 备注
     */
    @Size(message = "{user.size.remark}", max = 512)
    private String remark;

}
