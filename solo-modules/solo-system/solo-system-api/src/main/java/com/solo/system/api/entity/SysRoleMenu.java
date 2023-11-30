package com.solo.system.api.entity;

import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * 角色菜单信息
 * @author Gentleman.Lee
 * @since 2023/11/27 17:21
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@Table("sys_role_menu")
public class SysRoleMenu {

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 菜单id
     */
    private Long menuId;

}
