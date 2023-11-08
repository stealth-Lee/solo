package com.solo.system.model.config.resp;

import lombok.Data;

/**
 * 系统配置详情对象 resp
 * @author 十一
 * @since 2023-10-18 17:36
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class ConfigGetResp {

    /**
     * 配置id
     */
    private Long configId;

    /**
     * 配置名称
     */
    private String name;

    /**
     * 配置键
     */
    private String key;

    /**
     * 配置值
     */
    private String value;

    /**
     * 系统标识[0:否 1:是]
     */
    private Boolean isSys;

    /**
     * 备注
     */
    private String remark;

}
