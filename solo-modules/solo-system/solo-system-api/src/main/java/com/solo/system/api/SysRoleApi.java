package com.solo.system.api;

import java.util.Set;

/**
 * 系统角色远程调用API
 * @author 十一
 * @since 2023/11/30 10:50
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface SysRoleApi {

    public Set<String> selectRolePermissions(Long userId);

}
