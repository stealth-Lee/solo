package com.solo.system.model.config.req;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 系统配置修改对象 req
 * @author 十一
 * @since 2023-10-18 16:46
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class ConfigUpdateReq extends ConfigCreateReq {

    /**
     * 配置id
     */
    @NotNull(message = "{config.required.configId}")
    private Long configId;

}
