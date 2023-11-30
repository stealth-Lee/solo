package com.solo.system.api.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.solo.common.orm.base.entity.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单实体类
 * @author 十一
 * @since 2023-11-14 14:11
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Table("sys_menu")
public class SysMenu extends BasicEntity {

    /**
     * id
     */
    @Id(keyType = KeyType.Auto)
    private Long menuId;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 菜单类型[M:菜单 B:按钮]
     */
    private String type;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 路由地址
     */
    private String path;

    /**
     * 权限标识
     */
    private String permission;

    /**
     * 是否可见[0:否 1:是]
     */
    private Boolean visible;

    /**
     * 是否缓存[0:否 1:是]
     */
    private Boolean keepAlive;

    /**
     * 菜单排序
     */
    private Integer sort;

}
