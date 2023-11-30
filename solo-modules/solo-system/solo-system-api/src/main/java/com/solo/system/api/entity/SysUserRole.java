package com.solo.system.api.entity;

import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户角色信息
 * @author Gentleman.Lee
 * @since 2023/11/24 16:46
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@Table("sys_user_role")
public class SysUserRole implements Serializable {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;

}
