package com.solo.system.model.dict.type.req;

import com.solo.system.api.constant.dict.DictType;
import com.solo.system.api.constant.global.GlobalStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 字典类型新增对象类
 * @author 十一
 * @since 2023/09/22 16:26
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class DictTypeCreateReq {

    /**
     * 字典类型名称
     */
    @NotEmpty(message = "{dictType.required.name}")
    @Size(message = "{dictType.size.name}", max = 32)
    private String name;

    /**
     * 字典类型编码
     */
    @NotEmpty(message = "{dictType.required.code}")
    @Size(message = "{dictType.size.code}", max = 32)
    private String code;

    /**
     * 字典类型[1:string 2:number 3:boolean]
     */
    @NotNull(message = "{dictType.required.type}")
    private DictType type;

    /**
     * 字典类型状态
     */
    @NotNull(message = "{dictType.required.status}")
    private GlobalStatus status;

    /**
     * 备注
     */
    @Size(message = "{dictType.size.remark}", max = 512)
    private String remark;

}
