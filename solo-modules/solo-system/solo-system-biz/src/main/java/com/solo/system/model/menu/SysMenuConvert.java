package com.solo.system.model.menu;

import com.solo.system.api.entity.SysMenu;
import com.solo.system.model.menu.req.MenuCreateReq;
import com.solo.system.model.menu.req.MenuUpdateReq;
import com.solo.system.model.menu.resp.MenuGetResp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 菜单实体转换类
 * @author 十一
 * @since 2023-11-14 14:13
 * 人生若只如初见，何事秋风悲画扇
 **/
@Mapper
public interface SysMenuConvert {

    SysMenuConvert INSTANCE = Mappers.getMapper(SysMenuConvert.class);

    SysMenu convert(MenuCreateReq bean);

    SysMenu convert(MenuUpdateReq bean);

    MenuGetResp convertGet(SysMenu bean);

}
