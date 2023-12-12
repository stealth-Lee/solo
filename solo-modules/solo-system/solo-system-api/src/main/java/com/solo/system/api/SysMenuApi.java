package com.solo.system.api;

import java.util.Set;

/**
 * 系统菜单远程调用API
 * @author 十一
 * @since 2023/11/30 10:52
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface SysMenuApi {

    public Set<String> selectMenuPermissions(Long userId);

}
