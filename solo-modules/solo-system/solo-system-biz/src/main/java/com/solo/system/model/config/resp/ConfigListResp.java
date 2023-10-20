package com.solo.system.model.config.resp;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 系统配置列表对象 resp
 * @author 十一
 * @since 2023-10-19 15:08
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class ConfigListResp {

    /**
     * 配置id
     */
    private Long configId;

    /**
     * 配置名称
     */
    private String configName;

    /**
     * 配置键
     */
    private String configKey;

    /**
     * 配置值
     */
    private String configValue;

    /**
     * 系统标识[0:否 1:是]
     */
    private Boolean isSys;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 备注
     */
    private String remark;

}
