package com.solo.system.model.user;

import com.solo.system.api.entity.SysUser;
import com.solo.system.model.user.req.PersonalInfoReq;
import com.solo.system.model.user.req.UserCreateReq;
import com.solo.system.model.user.req.UserUpdateReq;
import com.solo.system.model.user.resp.UserGetResp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户实体转换类
 * @author 十一
 * @since 2023/09/08 10:10
 * 人生若只如初见，何事秋风悲画扇
 **/
@Mapper
public interface SysUserConvert {

    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    SysUser convert(UserCreateReq bean);

    SysUser convert(UserUpdateReq bean);

    SysUser convert(PersonalInfoReq bean);

    UserGetResp convertGet(SysUser bean);

}
