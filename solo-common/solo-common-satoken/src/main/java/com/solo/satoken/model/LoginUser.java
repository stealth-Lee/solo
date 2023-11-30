package com.solo.satoken.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

/**
 * 用户信息
 * @author Gentleman.Lee
 * @since 2023/11/27 15:20
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@NoArgsConstructor
public class LoginUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 所属部门id
     */
    private Long deptId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
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
     * 角色权限
     */
    private Set<String> rolePermission;

    /**
     * 菜单权限
     */
    private Set<String> menuPermission;

    /**
     * 获取登录id
     */
    public String getLoginId() {
        if (userId == null) {
            throw new IllegalArgumentException("用户ID不能为空");
        }
        return String.valueOf(userId);
    }

}
