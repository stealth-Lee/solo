package com.solo.system.web;

import com.mybatisflex.core.query.QueryWrapper;
import com.solo.common.core.global.R;
import com.solo.system.api.entity.SysUser;
import com.solo.system.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/list")
    public R list(SysUser sysUser) {
        List<SysUser> list = sysUserService.list(QueryWrapper.create(sysUser));
        return R.success(list);
    }

}
