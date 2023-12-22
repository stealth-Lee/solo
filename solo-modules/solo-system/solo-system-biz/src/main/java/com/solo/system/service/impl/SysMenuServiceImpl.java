package com.solo.system.service.impl;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import com.mybatisflex.core.query.QueryChain;
import com.solo.common.core.base.service.impl.BasicServiceImpl;
import com.solo.system.api.constant.global.GlobalStatus;
import com.solo.system.api.constant.menu.Meta;
import com.solo.system.api.constant.menu.Router;
import com.solo.system.api.entity.SysMenu;
import com.solo.system.mapper.SysMenuMapper;
import com.solo.system.service.SysMenuService;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.solo.system.api.entity.table.SysMenuTableDef.SysMenuTable;
import static com.solo.system.api.entity.table.SysRoleMenuTableDef.SysRoleMenuTable;
import static com.solo.system.api.entity.table.SysRoleTableDef.SysRoleTable;
import static com.solo.system.api.entity.table.SysUserRoleTableDef.SysUserRoleTable;
import static com.solo.system.api.entity.table.SysUserTableDef.SysUserTable;


/**
 * 菜单 Service实现类
 * @author 十一
 * @since 2023-11-14 14:13
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
public class SysMenuServiceImpl extends BasicServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Override
    public List<SysMenu> list(Long userId) {
        return QueryChain.of(mapper).from(SysMenuTable)
                .leftJoin(SysRoleMenuTable).on(SysMenuTable.MenuId.eq(SysRoleMenuTable.MenuId))
                .leftJoin(SysUserRoleTable).on(SysRoleMenuTable.RoleId.eq(SysUserRoleTable.RoleId))
                .leftJoin(SysRoleTable).on(SysUserRoleTable.RoleId.eq(SysRoleTable.RoleId))
                .leftJoin(SysUserTable).on(SysUserRoleTable.UserId.eq(SysUserTable.UserId))
                .where(SysUserTable.UserId.eq(userId)).and(SysMenuTable.Type.in("D", "M"))
                    .and(SysRoleTable.Status.eq(GlobalStatus.NORMAL))
                .orderBy(SysMenuTable.ParentId.desc(), SysMenuTable.Sort.desc())
                .list();
    }

    @Override
    public List<Tree<Long>> buildRouters(List<SysMenu> menus, String type, Long parentId) {
        List<TreeNode<Long>> collect = menus.stream()
//                .filter(menuTypePredicate(type))
                .map(getNodeFunction())
                .collect(Collectors.toList());

        Long parent = parentId == null ? 0 : parentId;
        return TreeUtil.build(collect, parent);
    }

    @NotNull
    private Function<SysMenu, TreeNode<Long>> getNodeFunction() {
        return menu -> {
            TreeNode<Long> node = new TreeNode<>();
            node.setId(menu.getMenuId());
            node.setParentId(menu.getParentId());
            node.setName(menu.getName());
            node.setWeight(menu.getSort());
            // 扩展属性
            Map<String, Object> extra = new HashMap<>();
            extra.put(Router.PATH, menu.getPath());
            extra.put(Router.REDIRECT, null);
            extra.put(Router.COMPONENT, null);

            Map<String, Object> meta = new HashMap<>();
            meta.put(Meta.TITLE, menu.getName());
            meta.put(Meta.ICON, menu.getIcon());
            meta.put(Meta.SHOW_LINK, menu.getVisible());
            meta.put(Meta.SHOW_PARENT, true);
            meta.put(Meta.ROLES, null);
            List<String> auths = QueryChain.of(mapper).select(SysMenuTable.Permission).from(SysMenuTable)
                    .where(SysMenuTable.ParentId.eq(menu.getMenuId()))
                    // TODO 此处修改成枚举
                    .and(SysMenuTable.Type.eq("B")).listAs(String.class);
            meta.put(Meta.AUTHS, auths);
            meta.put(Meta.KEEP_ALIVE, menu.getKeepAlive());
            meta.put(Meta.FRAME_SRC, null);
            meta.put(Meta.FRAME_LOADING, null);
            meta.put(Meta.HIDDEN_TAG, null);
            meta.put(Meta.DYNAMIC_LEVEL, null);
            extra.put(Router.META, meta);
            node.setExtra(extra);
            return node;
        };
    }

    /**
     * menu 类型断言
     * @param type 类型
     * @return Predicate
     */
//    private Predicate<SysMenu> menuTypePredicate(String type) {
//        return vo -> {
//            if (MenuTypeEnum.TOP_MENU.getDescription().equals(type)) {
//                return MenuTypeEnum.TOP_MENU.getType().equals(vo.getMenuType());
//            }
//            // 其他查询 左侧 + 顶部
//            return !MenuTypeEnum.BUTTON.getType().equals(vo.getMenuType());
//        };
//    }

}
