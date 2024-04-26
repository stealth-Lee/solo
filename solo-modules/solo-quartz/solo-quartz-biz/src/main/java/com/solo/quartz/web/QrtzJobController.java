package com.solo.quartz.web;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.mybatisflex.core.paginate.Page;
import com.solo.common.core.global.R;
import com.solo.common.logger.annotation.Logger;
import com.solo.common.logger.enums.LoggerType;
import com.solo.common.orm.core.query.Wrappers;
import com.solo.quartz.api.entity.QrtzJob;
import com.solo.quartz.model.job.QrtzJobConvert;
import com.solo.quartz.model.job.req.JobCreateReq;
import com.solo.quartz.model.job.req.JobQueryReq;
import com.solo.quartz.model.job.req.JobUpdateReq;
import com.solo.quartz.model.job.resp.JobGetResp;
import com.solo.quartz.model.job.resp.JobListResp;
import com.solo.quartz.service.QrtzJobService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * 定时任务控制器
 * @author 十一
 * @since 2024-04-25 14:56
 * 人生若只如初见，何事秋风悲画扇
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/quartz/job")
public class QrtzJobController {

    private final QrtzJobService qrtzJobService;

    /**
     * 新增定时任务
     * @param req 定时任务新增对象
     * @return 响应信息
     */
    @PostMapping
    @SaCheckPermission("quartz-job-create")
    @Logger(value = "新增定时任务", type = LoggerType.CREATE)
    public R<Boolean> create(@Valid @RequestBody JobCreateReq req) {
        QrtzJob entity = QrtzJobConvert.INSTANCE.convert(req);
        return R.success(qrtzJobService.save(entity));
    }

    /**
     * 删除定时任务
     * @param jobIds 定时任务集合
     * @return 响应信息
     */
    @DeleteMapping("/{jobIds}")
    @SaCheckPermission("quartz-job-delete")
    @Logger(value = "删除定时任务", type = LoggerType.DELETE)
    public R<Boolean> delete(@PathVariable Long[] jobIds) {
        return R.success(qrtzJobService.removeByIds(Arrays.asList(jobIds)));
    }

    /**
     * 更新定时任务
     * @param req 定时任务更新对象
     * @return 响应信息
     */
    @PutMapping
    @SaCheckPermission("quartz-job-update")
    @Logger(value = "更新定时任务", type = LoggerType.UPDATE)
    public R<Boolean> update(@Valid @RequestBody JobUpdateReq req) {
        QrtzJob entity = QrtzJobConvert.INSTANCE.convert(req);
        return R.success(qrtzJobService.updateById(entity));
    }

    /**
     * 获取定时任务
     * @param jobId 定时任务
     * @return 响应信息
     */
    @GetMapping("/{jobId}")
    @SaCheckPermission("quartz-job-query")
    public R<JobGetResp> get(@PathVariable Long jobId) {
        return R.success(QrtzJobConvert.INSTANCE.convertGet(qrtzJobService.getById(jobId)));
    }

    /**
     * 分页查询定时任务列表
     * @param page 分页对象
     * @param req 定时任务查询对象
     * @return 响应信息
     */
    @GetMapping("/page")
    @SaCheckPermission("quartz-job-query")
    public R<Page<JobListResp>> page(Page<JobListResp> page, JobQueryReq req) {
        Page<JobListResp> list = qrtzJobService.pageAs(page, Wrappers.builder(req), JobListResp.class);
        return R.success(list);
    }

}
