package com.solo.system.model.dict.type.req;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字典类型修改对象类
 * @author 十一
 * @since 2023/09/22 16:48
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class DictTypeUpdateReq extends DictTypeCreateReq {

        /**
        * 字典类型id
        */
        @NotNull(message = "{dictType.required.typeId}")
        private Long typeId;

}
