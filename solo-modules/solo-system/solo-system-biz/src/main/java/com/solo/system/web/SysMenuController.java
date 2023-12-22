package com.solo.system.web;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.hutool.core.lang.tree.Tree;
import com.mybatisflex.core.query.QueryWrapper;
import com.solo.common.core.global.R;
import com.solo.common.logger.annotation.Logger;
import com.solo.common.logger.enums.LoggerType;
import com.solo.common.orm.core.query.Wrappers;
import com.solo.satoken.utils.LoginHelper;
import com.solo.system.api.SysRoleApi;
import com.solo.system.api.entity.SysMenu;
import com.solo.system.model.menu.SysMenuConvert;
import com.solo.system.model.menu.req.MenuCreateReq;
import com.solo.system.model.menu.resp.MenuSimpleResp;
import com.solo.system.model.menu.req.MenuQueryReq;
import com.solo.system.model.menu.req.MenuUpdateReq;
import com.solo.system.model.menu.resp.MenuGetResp;
import com.solo.system.model.menu.resp.MenuListResp;
import com.solo.system.service.SysMenuService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static com.solo.system.api.entity.table.SysMenuTableDef.SysMenuTable;

/**
 * 菜单控制器
 * @author 十一
 * @since 2023-11-14 14:31
 * 人生若只如初见，何事秋风悲画扇
 **/
@RestController
@RequestMapping("/system/menu")
public class SysMenuController {

    @Resource
    private SysMenuService sysMenuService;
    @DubboReference
    private SysRoleApi sysRoleApi;

    /**
     * 新增菜单
     * @param req 菜单新增对象
     * @return 响应信息
     */
    @PostMapping
    @SaCheckPermission("system-menu-create")
    @Logger(value = "新增菜单", type = LoggerType.CREATE)
    public R<Boolean> create(@Valid @RequestBody MenuCreateReq req) {
        SysMenu entity = SysMenuConvert.INSTANCE.convert(req);
        return R.success(sysMenuService.save(entity));
    }

    /**
     * 删除菜单
     * @param menuIds 菜单集合
     * @return 响应信息
     */
    @DeleteMapping("/{menuIds}")
    @SaCheckPermission("system-menu-delete")
    @Logger(value = "删除菜单", type = LoggerType.DELETE)
    public R<Boolean> delete(@PathVariable Long[] menuIds) {
        return R.success(sysMenuService.removeByIds(Arrays.asList(menuIds)));
    }

    /**
     * 更新菜单
     * @param req 菜单更新对象
     * @return 响应信息
     */
    @PutMapping
    @SaCheckPermission("system-menu-update")
    @Logger(value = "更新菜单", type = LoggerType.UPDATE)
    public R<Boolean> update(@Valid @RequestBody MenuUpdateReq req) {
        SysMenu entity = SysMenuConvert.INSTANCE.convert(req);
        return R.success(sysMenuService.updateById(entity));
    }

    /**
     * 获取菜单
     * @param menuId 菜单
     * @return 响应信息
     */
    @GetMapping("/{menuId}")
    @SaCheckPermission("system-menu-query")
    public R<MenuGetResp> get(@PathVariable Long menuId) {
        return R.success(SysMenuConvert.INSTANCE.convertGet(sysMenuService.getById(menuId)));
    }

    /**
     * 查询菜单列表精简信息
     * @return 响应信息
     */
    @GetMapping("/list-simple")
    @SaCheckPermission("system-menu-query")
    public R<List<MenuSimpleResp>> listSimple() {
        return R.success(
                sysMenuService.queryChain()
                 // TODO 这里的类型需要改成枚举
                .where(SysMenuTable.Type.in("D", "M"))
                .listAs(MenuSimpleResp.class)
        );
    }

    /**
     * 查询菜单列表
     * @param req 查询对象
     * @return 响应信息
     */
    @GetMapping("/list")
    @SaCheckPermission("system-menu-query")
    public R<List<MenuListResp>> list(MenuQueryReq req) {
        QueryWrapper queryWrapper = Wrappers.buildWhere(req);
        return R.success(sysMenuService.listAs(queryWrapper, MenuListResp.class));
    }

    @GetMapping
    public R<List<Tree<Long>>> routers() {
        List<SysMenu> list = sysMenuService.list(LoginHelper.getUserId());
        return R.success(sysMenuService.buildRouters(list, null, null));
    }

}
