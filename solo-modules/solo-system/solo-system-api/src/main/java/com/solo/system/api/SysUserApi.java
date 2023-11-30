package com.solo.system.api;


import com.solo.system.api.entity.SysUser;

import java.util.Set;

public interface SysUserApi {

    public SysUser query(String username);

    public Set<String> selectRolePermission(Long userId);

    public Set<String> selectMenuPermission(Long userId);

}
