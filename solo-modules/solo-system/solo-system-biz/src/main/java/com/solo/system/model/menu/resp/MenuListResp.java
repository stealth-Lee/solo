package com.solo.system.model.menu.resp;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 菜单列表对象 resp
 * @author 十一
 * @since 2023-11-14 14:13
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class MenuListResp {

    /**
     * id
     */
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

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 备注
     */
    private String remark;

}
