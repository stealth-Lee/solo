package com.solo.system.model.config.req;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotEmpty(message = "{config.required.name}")
    @Size(message = "{config.size.name}", max = 64)
    private String name;

    /**
     * 配置键
     */
    @NotEmpty(message = "{config.required.key}")
    @Size(message = "{config.size.key}", max = 64)
    private String key;

    /**
     * 配置值
     */
    @NotEmpty(message = "{config.required.value}")
    @Size(message = "{config.size.value}", max = 64)
    private String value;

    /**
     * 系统标识[0:否 1:是]
     */
    @NotNull(message = "{config.required.isSys}")
    private Boolean isSys;

    /**
     * 备注
     */
    @Size(message = "{config.size.remark}", max = 64)
    private String remark;

}
