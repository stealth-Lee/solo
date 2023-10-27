package com.solo.system.model.dict.data.req;

import com.solo.system.api.constant.global.GlobalStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 字典数据状态修改 req
 * @author 十一
 * @since 2023-10-27 16:08
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class DictDataUpdateStatusReq {

    /**
     * 字典数据id
     */
    @NotNull(message = "字典数据id不能为空")
    private Long dataId;

    /**
     * 状态[0禁用 1正常]
     */
    @NotNull(message = "状态[0禁用 1正常]不能为空")
    private GlobalStatus status;

}
