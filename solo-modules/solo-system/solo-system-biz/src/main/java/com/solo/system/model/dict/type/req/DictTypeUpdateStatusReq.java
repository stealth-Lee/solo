package com.solo.system.model.dict.type.req;

import com.solo.system.api.consts.global.GlobalStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 字典类型状态修改 req
 * @author 十一
 * @since 2023-10-25 17:02
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class DictTypeUpdateStatusReq {
    /**
     * 字典类型id
     */
    @NotNull(message = "{dictType.required.typeId}")
    private Long typeId;

    /**
     * 状态[0停用 1正常]
     */
    @NotNull(message = "{dictType.required.status}")
    private GlobalStatus status;

}
