package com.solo.system.model.role;

import com.solo.system.api.entity.SysRole;
import com.solo.system.model.role.req.RoleCreateReq;
import com.solo.system.model.role.req.RoleUpdateReq;
import com.solo.system.model.role.req.RoleUpdateStatusReq;
import com.solo.system.model.role.resp.RoleGetResp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 系统角色实体转换类
 * @author 十一
 * @since 2023/09/22 17:32
 * 人生若只如初见，何事秋风悲画扇
 **/
@Mapper
public interface SysRoleConvert {

    SysRoleConvert INSTANCE = Mappers.getMapper(SysRoleConvert.class);

    SysRole convert(RoleCreateReq req);

    SysRole convert(RoleUpdateReq req);

    SysRole convert(RoleUpdateStatusReq req);

    RoleGetResp convertGet(SysRole entity);

}
