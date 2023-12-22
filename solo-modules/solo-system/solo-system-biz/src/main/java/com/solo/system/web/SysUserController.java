package com.solo.system.web;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.mybatisflex.core.paginate.Page;
import com.solo.common.core.global.R;
import com.solo.common.logger.annotation.Logger;
import com.solo.common.logger.enums.LoggerType;
import com.solo.common.orm.core.query.Wrappers;
import com.solo.system.api.entity.SysUser;
import com.solo.system.model.user.SysUserConvert;
import com.solo.system.model.user.req.UserCreateReq;
import com.solo.system.model.user.req.UserQueryReq;
import com.solo.system.model.user.req.UserResetPasswordReq;
import com.solo.system.model.user.req.UserUpdateReq;
import com.solo.system.model.user.resp.UserGetResp;
import com.solo.system.service.SysUserService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制器
 * @author 十一
 * @since 2023/09/04 17:28
 * 人生若只如初见，何事秋风悲画扇
 **/
@RestController
@RequestMapping("/system/user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    /**
     * 创建用户
     * @param req 用户新增对象
     * @return 响应信息
     */
    @PostMapping
    @SaCheckPermission("system-user-create")
    @Logger(value = "创建用户", type = LoggerType.CREATE)
    public R<Boolean> create(@Valid @RequestBody UserCreateReq req) {
        SysUser entity = SysUserConvert.INSTANCE.convert(req);
        return R.success(sysUserService.create(entity));
    }

    /**
     * 删除用户
     * @param userId 用户id
     * @return 响应信息
     */
    @DeleteMapping("/{userId}")
    @SaCheckPermission("system-user-delete")
    @Logger(value = "删除用户", type = LoggerType.DELETE)
    public R<Boolean> delete(@PathVariable Long userId) {
        return R.success(sysUserService.removeById(userId));
    }

    /**
     * 重置密码
     * @param req 重置密码对象
     * @return 响应信息
     */
    @PutMapping("/reset-password")
    @SaCheckPermission("system-user-reset-password")
    @Logger(value = "重置密码", type = LoggerType.UPDATE)
    public R<Boolean> resetPassword(@Valid @RequestBody UserResetPasswordReq req) {
        sysUserService.resetPassword(req);
        return R.success(true);
    }

    /**
     * 更新用户
     * @param req 用户更新对象
     * @return 响应信息
     */
    @PutMapping
    @SaCheckPermission("system-user-update")
    @Logger(value = "更新用户", type = LoggerType.UPDATE)
    public R<Boolean> update(@Valid @RequestBody UserUpdateReq req) {
        SysUser entity = SysUserConvert.INSTANCE.convert(req);
        return R.success(sysUserService.update(entity));
    }

    /**
     * 获取用户信息
     * @param userId 用户id
     * @return 响应信息
     */
    @GetMapping("/{userId}")
    @SaCheckPermission("system-user-query")
    public R<UserGetResp> get(@PathVariable Long userId) {
        return R.success(SysUserConvert.INSTANCE.convertGet(sysUserService.getById(userId)));
    }

    /**
     * 分页查询用户列表
     * @param page 分页对象
     * @param req 用户查询对象
     * @return 响应信息
     */
    @GetMapping("/page")
    @SaCheckPermission("system-user-query")
    public R<Page<SysUser>> page(Page<SysUser> page, UserQueryReq req) {
        Page<SysUser> list = sysUserService.page(page, Wrappers.buildWhere(req));
        return R.success(list);
    }

}
