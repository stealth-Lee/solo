package com.solo.system.web;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.solo.common.core.global.R;
import com.solo.common.logger.annotation.Logger;
import com.solo.common.logger.enums.LoggerType;
import com.solo.system.model.role.req.RoleMenuReq;
import com.solo.system.service.SysRoleMenuService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * 角色菜单权限控制器
 * @author 十一
 * @since 2023/12/26 10:42
 * 人生若只如初见，何事秋风悲画扇
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/system/role-menu")
public class SysRoleMenuController {

    private final SysRoleMenuService sysRoleMenuService;

    @PutMapping("/assign")
    @SaCheckPermission("system-role-menu-assign")
    @Logger(value = "分配菜单权限", type = LoggerType.UPDATE)
    public R<Boolean> assignMenu(@Valid @RequestBody RoleMenuReq req) {
        return R.success(sysRoleMenuService.assignMenu(req));
    }

    @GetMapping("/{roleId}")
//    @SaCheckPermission("system-role-menu-assign")
    public R<Set<Long>> menuIds(@PathVariable("roleId") Long roleId) {
        return R.success(sysRoleMenuService.selectMenuIds(roleId));
    }

}
