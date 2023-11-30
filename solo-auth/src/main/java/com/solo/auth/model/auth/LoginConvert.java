package com.solo.auth.model.auth;

import com.solo.satoken.model.LoginUser;
import com.solo.system.api.entity.SysUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 部门实体转换类
 * @author 十一
 * @since 2023/09/08 10:10
 * 人生若只如初见，何事秋风悲画扇
 **/
@Mapper
public interface LoginConvert {

    LoginConvert INSTANCE = Mappers.getMapper(LoginConvert.class);

    LoginUser convert(SysUser bean);

}
