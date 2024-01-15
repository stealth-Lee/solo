package com.solo.system.web;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.solo.common.core.global.R;
import com.solo.common.logger.annotation.Logger;
import com.solo.common.logger.enums.LoggerType;
import com.solo.common.orm.core.query.Wrappers;
import com.solo.system.model.log.operate.SysLogOperateConvert;
import com.solo.system.model.log.operate.req.LogOperateQueryReq;
import com.solo.system.model.log.operate.resp.LogOperateGetResp;
import com.solo.system.model.log.operate.resp.LogOperateListResp;
import com.solo.system.service.SysLogOperateService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

import static com.solo.system.api.entity.table.SysLogOperateTableDef.SysLogOperateTable;

/**
 * 操作日志控制器
 * @author 十一
 * @since 2023-12-14 15:18
 * 人生若只如初见，何事秋风悲画扇
 **/
@RestController
@RequestMapping("/system/log-operate")
public class SysLogOperateController {

    @Resource
    private SysLogOperateService sysOperateLogService;

    /**
     * 删除操作日志
     * @param operateIds 操作日志集合
     * @return 响应信息
     */
    @DeleteMapping("/{operateIds}")
    @SaCheckPermission("system-log-operate-delete")
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
    @SaCheckPermission("system-log-operate-query")
    public R<LogOperateGetResp> get(@PathVariable Long operateId) {
        return R.success(SysLogOperateConvert.INSTANCE.convertGet(sysOperateLogService.getById(operateId)));
    }

    /**
     * 分页查询操作日志列表
     * @param page 分页对象
     * @param req 操作日志查询对象
     * @return 响应信息
     */
    @GetMapping("/page")
    @SaCheckPermission("system-log-operate-query")
    public R<Page<LogOperateListResp>> page(Page<LogOperateListResp> page, LogOperateQueryReq req) {
        QueryWrapper wrapper = Wrappers.builder(req).orderBy(SysLogOperateTable.CreateTime.desc());
        Page<LogOperateListResp> list = sysOperateLogService.pageAs(page, wrapper, LogOperateListResp.class);
        return R.success(list);
    }

}
