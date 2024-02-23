package com.solo.system.web;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.solo.common.core.global.R;
import com.solo.common.logger.annotation.Logger;
import com.solo.common.logger.enums.LoggerType;
import com.solo.common.orm.core.query.Wrappers;
import com.solo.system.model.log.login.SysLogLoginConvert;
import com.solo.system.model.log.login.resp.LogLoginListResp;
import com.solo.system.model.log.login.req.LogLoginQueryReq;
import com.solo.system.model.log.login.resp.LogLoginGetResp;
import com.solo.system.service.SysLogLoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * 登录日志控制器
 * @author 十一
 * @since 2024/01/03 11:14
 * 人生若只如初见，何事秋风悲画扇
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/system/log-login")
public class SysLogLoginController {

    private final SysLogLoginService sysLogLoginService;

    /**
     * 删除登录日志
     * @param loginIds 登录日志集合
     * @return 响应信息
     */
    @DeleteMapping("/{loginIds}")
    @SaCheckPermission("system-log-login-delete")
    @Logger(value = "删除登录日志", type = LoggerType.DELETE)
    public R<Boolean> delete(@PathVariable Long[] loginIds) {
        return R.success(sysLogLoginService.removeByIds(Arrays.asList(loginIds)));
    }

    /**
     * 获取登录日志
     * @param loginId 登录日志
     * @return 响应信息
     */
    @GetMapping("/{loginId}")
    @SaCheckPermission("system-log-login-query")
    public R<LogLoginGetResp> get(@PathVariable Long loginId) {
        return R.success(SysLogLoginConvert.INSTANCE.convertGet(sysLogLoginService.getById(loginId)));
    }

    /**
     * 分页查询登录日志列表
     * @param page 分页对象
     * @param req 登录日志查询对象
     * @return 响应信息
     */
    @GetMapping("/page")
    @SaCheckPermission("system-log-login-query")
    public R<Page<LogLoginListResp>> page(Page<LogLoginListResp> page, LogLoginQueryReq req) {
        QueryWrapper wrapper = Wrappers.builder(req);
        Page<LogLoginListResp> list = sysLogLoginService.pageAs(page, wrapper, LogLoginListResp.class);
        return R.success(list);
    }

}
