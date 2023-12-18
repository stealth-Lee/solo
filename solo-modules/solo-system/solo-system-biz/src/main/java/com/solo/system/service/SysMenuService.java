package com.solo.system.service;

import cn.hutool.core.lang.tree.Tree;
import com.solo.common.core.base.service.BasicService;
import com.solo.system.api.entity.SysMenu;

import java.util.List;

/**
 * 菜单 Service
 * @author 十一
 * @since 2023-11-14 14:13
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface SysMenuService extends BasicService<SysMenu> {


    /**
     * 根据用户id查询菜单列表
     * @param userId 用户id
     * @return {@link List}<{@link SysMenu}>
     */
    public List<SysMenu> list(Long userId);

    /**
     * 构建路由
     * @param menus 菜单
     * @return {@link List}<{@link Tree}>
     */
    public List<Tree<Long>> buildRouters(List<SysMenu> menus, String type, Long parentId);

}
