package com.solo.system.web;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.mybatisflex.core.paginate.Page;
import com.solo.common.core.global.R;
import com.solo.common.logger.annotation.Logger;
import com.solo.common.logger.enums.LoggerType;
import com.solo.common.orm.core.query.Wrappers;
import com.solo.system.model.operate.SysOperateLogConvert;
import com.solo.system.model.operate.req.OperateLogQueryReq;
import com.solo.system.model.operate.resp.OperateLogGetResp;
import com.solo.system.model.operate.resp.OperateLogListResp;
import com.solo.system.service.SysOperateLogService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * 操作日志控制器
 * @author 十一
 * @since 2023-12-14 15:18
 * 人生若只如初见，何事秋风悲画扇
 **/
@RestController
@RequestMapping("/system/operate-log")
public class SysOperateLogController {

    @Resource
    private SysOperateLogService sysOperateLogService;

    /**
     * 删除操作日志
     * @param operateIds 操作日志集合
     * @return 响应信息
     */
    @DeleteMapping("/{operateIds}")
    @SaCheckPermission("system-operate-log-delete")
    @Logger(value = "删除操作日志", type = LoggerType.DELETE)
    public R<Boolean> delete(@PathVariable Long[] operateIds) {
        return R.success(sysOperateLogService.removeByIds(Arrays.asList(operateIds)));
    }

    /**
     * 获取操作日志
     * @param operateId 操作日志
     * @return 响应信息
     */
    @GetMapping("/{operateId}")
    @SaCheckPermission("system-operate-log-query")
    public R<OperateLogGetResp> get(@PathVariable Long operateId) {
        return R.success(SysOperateLogConvert.INSTANCE.convertGet(sysOperateLogService.getById(operateId)));
    }

    /**
     * 分页查询操作日志列表
     * @param page 分页对象
     * @param req 操作日志查询对象
     * @return 响应信息
     */
    @GetMapping("/page")
    @SaCheckPermission("system-operate-log-query")
    public R<Page<OperateLogListResp>> page(Page<OperateLogListResp> page, OperateLogQueryReq req) {
        Page<OperateLogListResp> list = sysOperateLogService.pageAs(page, Wrappers.buildWhere(req), OperateLogListResp.class);
        return R.success(list);
    }

}
