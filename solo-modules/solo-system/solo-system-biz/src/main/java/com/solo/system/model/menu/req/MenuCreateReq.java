package com.solo.system.model.menu.req;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 菜单新增对象 req
 * @author 十一
 * @since 2023-11-14 14:13
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class MenuCreateReq {

    /**
     * 父级id
     */
    @NotNull(message = "{menu.required.parentId}")
    private Long parentId;

    /**
     * 菜单类型[M:菜单 B:按钮]
     */
    @NotEmpty(message = "{menu.required.type}")
    @Size(message = "{menu.size.type}", max = 1)
    private String type;

    /**
     * 菜单名称
     */
    @NotEmpty(message = "{menu.required.name}")
    @Size(message = "{menu.size.name}", max = 32)
    private String name;

    /**
     * 菜单图标
     */
    @Size(message = "{menu.size.icon}", max = 32)
    private String icon;

    /**
     * 路由地址
     */
    @Size(message = "{menu.size.path}", max = 128)
    private String path;

    /**
     * 权限标识
     */
    @Size(message = "{menu.size.permission}", max = 32)
    private String permission;

    /**
     * 是否可见[0:否 1:是]
     */
    @NotNull(message = "{menu.required.visible}")
    private Boolean visible;

    /**
     * 是否缓存[0:否 1:是]
     */
    @NotNull(message = "{menu.required.keepAlive}")
    private Boolean keepAlive;

    /**
     * 菜单排序
     */
    private Integer sort;

    /**
     * 备注
     */
    @Size(message = "{menu.size.remark}", max = 512)
    private String remark;

}
