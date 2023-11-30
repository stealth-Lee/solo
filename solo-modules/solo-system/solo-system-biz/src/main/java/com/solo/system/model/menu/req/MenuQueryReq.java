package com.solo.system.model.menu.req;

import com.solo.common.orm.core.query.anno.Query;
import com.solo.common.orm.core.query.anno.Wrappers;
import lombok.Data;

/**
 * 菜单查询对象 req
 * @author 十一
 * @since 2023-11-14 14:13
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@Wrappers
public class MenuQueryReq {

    /**
     * 父级id
     */
    @Query
    private Long parentId;

    /**
     * 菜单类型[M:菜单 B:按钮]
     */
    @Query
    private String type;

    /**
     * 菜单名称
     */
    @Query
    private String name;

    /**
     * 菜单图标
     */
    @Query
    private String icon;

    /**
     * 路由地址
     */
    @Query
    private String path;

    /**
     * 权限标识
     */
    @Query
    private String permission;

    /**
     * 是否可见[0:否 1:是]
     */
    @Query
    private Boolean visible;

    /**
     * 是否缓存[0:否 1:是]
     */
    @Query
    private Boolean keepAlive;

    /**
     * 菜单排序
     */
    @Query
    private Integer sort;

}
