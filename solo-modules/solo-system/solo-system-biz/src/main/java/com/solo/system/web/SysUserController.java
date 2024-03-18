package com.solo.system.web;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.solo.common.core.global.R;
import com.solo.common.logger.annotation.Logger;
import com.solo.common.logger.enums.LoggerType;
import com.solo.common.orm.core.query.Wrappers;
import com.solo.satoken.utils.LoginHelper;
import com.solo.system.api.entity.SysUser;
import com.solo.system.model.user.SysUserConvert;
import com.solo.system.model.user.req.*;
import com.solo.system.model.user.resp.UserGetResp;
import com.solo.system.service.SysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.solo.system.api.entity.table.SysUserTableDef.SysUserTable;

/**
 * 用户控制器
 * @author 十一
 * @since 2023/09/04 17:28
 * 人生若只如初见，何事秋风悲画扇
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/system/user")
@Tag(name = "管理后台 - 用户")
public class SysUserController {

    private final SysUserService sysUserService;

    /**
     * 创建用户
     * @param req 用户新增对象
     * @return 响应信息
     */
    @PostMapping
    @SaCheckPermission("system-user-create")
    @Logger(value = "创建用户", type = LoggerType.CREATE)
    public R<Boolean> create(@Valid @RequestBody UserCreateReq req) {
        return R.success(sysUserService.create(req));
    }

    /**
     * 删除用户
     * @param userId 用户id
     * @return 响应信息
     */
    @Operation(summary = "删除用户")
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
    public R<Boolean> resetPassword(@Valid @RequestBody ResetPasswordReq req) {
        sysUserService.resetPassword(req);
        return R.success(true);
    }

    /**
     * 修改密码
     * @param req 修改密码对象
     * @return 响应信息
     */
    @PutMapping("/change-password")
    @Logger(value = "修改密码", type = LoggerType.UPDATE)
    public R<Boolean> changePassword(@Valid @RequestBody ChangePasswordReq req) {
        sysUserService.changePassword(req);
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
        return R.success(sysUserService.update(req));
    }

    /**
     * 修改个人信息
     */
    @PutMapping("/personal-info")
    @Logger(value = "修改个人信息", type = LoggerType.UPDATE)
    public R<Boolean> updatePersonalInfo(@Valid @RequestBody PersonalInfoReq req) {
        SysUser entity = SysUserConvert.INSTANCE.convert(req);
        return R.success(sysUserService.updateById(entity));
    }

    /**
     * 获取用户信息
     * @param userId 用户id
     * @return 响应信息
     */
    @GetMapping("/{userId}")
    @SaCheckPermission("system-user-query")
    public R<UserGetResp> get(@PathVariable Long userId) {
        return R.success(sysUserService.queryByUserId(userId));
    }

    /**
     * 获取当前登录用户信息
     * @return 当前登录用户信息
     */
    @GetMapping("/current")
    @SaCheckPermission("system-user-query")
    public R<UserGetResp> current() {
        return R.success(sysUserService.queryByUserId(LoginHelper.getUserId()));
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
        QueryWrapper queryWrapper = Wrappers.builder(req).orderBy(SysUserTable.CreateTime.desc());
        Page<SysUser> list = sysUserService.page(page, queryWrapper);
        return R.success(list);
    }

}
