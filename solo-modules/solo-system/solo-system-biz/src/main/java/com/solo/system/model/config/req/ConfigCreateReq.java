package com.solo.system.model.config.req;

import lombok.Data;

/**
 * 系统配置新增对象 req
 * @author 十一
 * @since 2023-10-18 16:46
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class ConfigCreateReq {

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
