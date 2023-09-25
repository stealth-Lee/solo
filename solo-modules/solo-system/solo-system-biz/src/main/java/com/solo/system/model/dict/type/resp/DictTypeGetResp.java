package com.solo.system.model.dict.type.resp;

import com.solo.system.api.constant.global.GlobalStatus;
import lombok.Data;

@Data
public class DictTypeGetResp {

    /**
     * 字典类型id
     */
    private Long typeId;

    /**
     * 字典类型名称
     */
    private String dictName;

    /**
     * 字典类型编码
     */
    private String dictCode;

    /**
     * 字典类型状态
     */
    private GlobalStatus status;

    /**
     * 备注
     */
    private String remark;

}
