package com.solo.system.model.dict.type.resp;

import com.solo.system.api.constant.dict.DictType;
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
    private String name;

    /**
     * 字典类型编码
     */
    private String code;

    /**
     * 字典类型[1:string 2:number 3:boolean]
     */
    private DictType type;

    /**
     * 字典类型状态
     */
    private GlobalStatus status;

    /**
     * 备注
     */
    private String remark;

}
