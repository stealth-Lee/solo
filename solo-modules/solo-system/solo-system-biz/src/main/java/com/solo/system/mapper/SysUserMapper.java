package com.solo.system.mapper;


import com.solo.common.core.base.mapper.BasicMapper;
import com.solo.system.api.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户Mapper
 * @author 十一
 * @since 2023/08/30 17:38
 * 人生若只如初见，何事秋风悲画扇
 **/
@Mapper
public interface SysUserMapper extends BasicMapper<SysUser> {

}
