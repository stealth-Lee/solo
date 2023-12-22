package com.solo.system.web;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.mybatisflex.core.paginate.Page;
import com.solo.common.core.global.R;
import com.solo.common.logger.annotation.Logger;
import com.solo.common.logger.enums.LoggerType;
import com.solo.common.orm.core.query.Wrappers;
import com.solo.system.api.entity.SysRole;
import com.solo.system.model.role.SysRoleConvert;
import com.solo.system.model.role.req.RoleCreateReq;
import com.solo.system.model.role.req.RoleQueryReq;
import com.solo.system.model.role.req.RoleUpdateReq;
import com.solo.system.model.role.req.RoleUpdateStatusReq;
import com.solo.system.model.role.resp.RoleGetResp;
import com.solo.system.model.role.resp.RoleListResp;
import com.solo.system.service.SysRoleService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * 系统角色控制器
 * @author 十一
 * @since 2023/09/22 17:29
 * 人生若只如初见，何事秋风悲画扇
 **/
@RestController
@RequestMapping("/system/role")
public class SysRoleController {

    @Resource
    private SysRoleService sysRoleService;

    /**
     * 新增角色
     * @param req 角色新增对象
     * @return 响应信息
     */
    @PostMapping
    @SaCheckPermission("system-role-create")
    @Logger(value = "新增角色", type = LoggerType.CREATE)
    public R<Boolean> create(@Valid @RequestBody RoleCreateReq req) {
        SysRole entity = SysRoleConvert.INSTANCE.convert(req);
        return R.success(sysRoleService.create(entity));
    }

    /**
     * 删除角色
     * @param roleIds 角色id集合
     * @return 响应信息
     */
    @DeleteMapping("/{roleIds}")
    @SaCheckPermission("system-role-delete")
    @Logger(value = "删除角色", type = LoggerType.DELETE)
    public R<Boolean> delete(@PathVariable Long[] roleIds) {
        return R.success(sysRoleService.removeByIds(Arrays.asList(roleIds)));
    }

    /**
     * 更新角色
     * @param req 角色更新对象
     * @return 响应信息
     */
    @PutMapping
    @SaCheckPermission("system-role-update")
    @Logger(value = "更新角色", type = LoggerType.UPDATE)
    public R<Boolean> update(@Valid @RequestBody RoleUpdateReq req) {
        SysRole entity = SysRoleConvert.INSTANCE.convert(req);
        return R.success(sysRoleService.update(entity));
    }

    /**
     * 角色状态切换
     * @param req 系统角色修改状态对象
     * @return 响应信息
     */
    @PutMapping("/update-status")
    @SaCheckPermission("system-role-update")
    @Logger(value = "角色状态切换", type = LoggerType.UPDATE)
    public R<Boolean> updateStatus(@Valid @RequestBody RoleUpdateStatusReq req) {
        SysRole entity = SysRoleConvert.INSTANCE.convert(req);
        return R.success(sysRoleService.updateById(entity));
    }

    /**
     * 获取角色
     * @param roleId 角色id
     * @return 响应信息
     */
    @GetMapping("/{roleId}")
    @SaCheckPermission("system-role-query")
    public R<RoleGetResp> get(@PathVariable("roleId") Long roleId) {
        return R.success(SysRoleConvert.INSTANCE.convertGet(sysRoleService.getById(roleId)));
    }

    /**
     * 分页查询角色列表
     * @param page 分页对象
     * @param req 角色查询对象
     * @return 响应信息
     */
    @GetMapping("/page")
    @SaCheckPermission("system-role-query")
    public R<Page<RoleListResp>> page(Page<RoleListResp> page, RoleQueryReq req) {
        Page<RoleListResp> list = sysRoleService.pageAs(page, Wrappers.buildWhere(req), RoleListResp.class);
        return R.success(list);
    }

}
