package com.solo.quartz.model.job.req;

import com.solo.common.orm.core.query.anno.Query;
import com.solo.common.orm.core.query.anno.Wrappers;
import lombok.Data;


/**
 * 定时任务查询对象 req
 * @author 十一
 * @since 2024-04-25 14:56
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@Wrappers
public class JobQueryReq {

    /**
     * 任务名称
     */
    @Query
    private String name;

    /**
     * 处理器名称
     */
    @Query
    private String handlerName;

    /**
     * 处理器参数
     */
    @Query
    private String handlerParams;

    /**
     * cron表达式
     */
    @Query
    private String cron;

    /**
     * 重试次数
     */
    @Query
    private Integer retryCount;

    /**
     * 重试间隔
     */
    @Query
    private Integer retryInterval;

    /**
     * 执行策略[1立即执行 2执行一次]
     */
    @Query
    private Integer policy;

    /**
     * 是否允许并发执行[0禁止 1允许]
     */
    @Query
    private Boolean concurrent;

    /**
     * 任务状态[1运行 2暂停]
     */
    @Query
    private Boolean status;

}
