package com.solo.system.model.menu.resp;

import lombok.Data;

/**
 * 菜单列表精简信息 resp
 * @author 十一
 * @since 2023/12/13 09:18
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class MenuSimpleResp {

    /**
     * id
     */
    private Long menuId;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 菜单名称
     */
    private String name;

}
