package com.solo.system.web;

import com.mybatisflex.core.paginate.Page;
import com.solo.common.core.global.R;
import com.solo.common.orm.core.query.Wrappers;
import com.solo.system.api.entity.SysRole;
import com.solo.system.model.role.SysRoleConvert;
import com.solo.system.model.role.req.RoleCreateReq;
import com.solo.system.model.role.req.RoleQueryReq;
import com.solo.system.model.role.req.RoleUpdateReq;
import com.solo.system.model.role.resp.RoleGetResp;
import com.solo.system.model.role.resp.RoleListResp;
import com.solo.system.service.SysRoleService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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
    public R<Boolean> create(@Valid @RequestBody RoleCreateReq req) {
        SysRole entity = SysRoleConvert.INSTANCE.convert(req);
        return R.success(sysRoleService.create(entity));
    }

    /**
     * 删除角色
     * @param roleId 角色id
     * @return 响应信息
     */
    @DeleteMapping("/{roleId}")
    public R<Boolean> delete(@PathVariable Long roleId) {
        return R.success(sysRoleService.removeById(roleId));
    }

    /**
     * 更新角色
     * @param req 角色更新对象
     * @return 响应信息
     */
    @PutMapping
    public R<Boolean> update(@Valid @RequestBody RoleUpdateReq req) {
        SysRole entity = SysRoleConvert.INSTANCE.convert(req);
        return R.success(sysRoleService.update(entity));
    }

    /**
     * 获取角色
     * @param roleId 角色id
     * @return 响应信息
     */
    @GetMapping("/{roleId}")
    public R<RoleGetResp> get(@PathVariable Long roleId) {
        return R.success(SysRoleConvert.INSTANCE.convertGet(sysRoleService.getById(roleId)));
    }

    /**
     * 分页查询角色列表
     * @param page 分页对象
     * @param req 角色查询对象
     * @return 响应信息
     */
    @GetMapping("/page")
    public R<Page<RoleListResp>> page(Page<RoleListResp> page, RoleQueryReq req) {
        Page<RoleListResp> list = sysRoleService.pageAs(page, Wrappers.buildWhere(req), RoleListResp.class);
        return R.success(list);
    }

}
