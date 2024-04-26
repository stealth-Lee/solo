package com.solo.quartz.model.job.req;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 定时任务修改对象 req
 * @author 十一
 * @since 2024-04-25 14:56
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class JobUpdateReq {

    /**
     * id
     */
    @NotNull(message = "{job.required.jobId}")
    private Long jobId;

    /**
     * 任务名称
     */
    @NotEmpty(message = "{job.required.name}")
    @Size(message = "{job.size.name}", max = 32)
    private String name;

    /**
     * 处理器名称
     */
    @NotEmpty(message = "{job.required.handlerName}")
    @Size(message = "{job.size.handlerName}", max = 32)
    private String handlerName;

    /**
     * 处理器参数
     */
    @Size(message = "{job.size.handlerParams}", max = 255)
    private String handlerParams;

    /**
     * cron表达式
     */
    @Size(message = "{job.size.cron}", max = 32)
    private String cron;

    /**
     * 重试次数
     */
    private Integer retryCount;

    /**
     * 重试间隔
     */
    private Integer retryInterval;

    /**
     * 执行策略[1立即执行 2执行一次]
     */
    private Integer policy;

    /**
     * 是否允许并发执行[0禁止 1允许]
     */
    private Boolean concurrent;

    /**
     * 任务状态[1运行 2暂停]
     */
    private Boolean status;

    /**
     * 备注
     */
    @Size(message = "{job.size.remark}", max = 512)
    private String remark;

}
