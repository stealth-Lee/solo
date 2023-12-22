package com.solo.system.model.dict.data.req;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字典数据修改对象
 * @author 十一
 * @since 2023/09/26 11:42
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class DictDataUpdateReq extends DictDataCreateReq {

    /**
     * 字典数据id
     */
    @NotNull(message = "{dictData.required.dataId}")
    private Long dataId;

}
