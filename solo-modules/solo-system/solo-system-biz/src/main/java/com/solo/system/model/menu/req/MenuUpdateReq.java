package com.solo.system.model.menu.req;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 菜单修改对象 req
 * @author 十一
 * @since 2023-11-14 14:13
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class MenuUpdateReq extends MenuCreateReq {

    /**
     * id
     */
    @NotNull(message = "{menu.required.menuId}")
    private Long menuId;

}
