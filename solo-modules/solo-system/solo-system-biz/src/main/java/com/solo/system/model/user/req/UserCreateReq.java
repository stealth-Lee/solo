package com.solo.system.model.user.req;

import com.solo.system.api.constant.user.Sex;
import com.solo.system.api.constant.user.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
    @NotBlank(message = "用户名不能为空")
    @Size(min = 4, max = 30, message = "用户名长度为 ${min}-${max} 个字符")
    private String username;

    /**
     * 用户密码
     */
    @NotEmpty(message = "用户密码不能为空")
    private String password;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户性别
     */
    private Sex sex;

    /**
     * 用户电话
     */
    private String mobile;

    /**
     * 用户邮箱
     */
    @Email(message = "邮箱格式不正确")
    private String email;

    /**
     * 帐号状态
     */
    private Status status;

    /**
     * 备注
     */
    private String remark;

}
