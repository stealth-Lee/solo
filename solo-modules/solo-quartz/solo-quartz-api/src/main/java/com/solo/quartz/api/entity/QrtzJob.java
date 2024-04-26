package com.solo.quartz.api.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.solo.common.core.base.entity.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 定时任务实体类
 * @author 十一
 * @since 2024-04-25 14:56
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Table("qrtz_job")
public class QrtzJob extends BasicEntity {

    /**
     * id
     */
    @Id(keyType = KeyType.Auto)
    private Long jobId;

    /**
     * 任务名称
     */
    private String name;

    /**
     * 处理器名称
     */
    private String handlerName;

    /**
     * 处理器参数
     */
    private String handlerParams;

    /**
     * cron表达式
     */
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

}
