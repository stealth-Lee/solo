package com.solo.system.model.dict.type.resp;

import lombok.Data;

/**
 * 字典类型精简列表响应对象
 * @author 十一
 * @since 2023/10/25 09:44
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class DictTypeListSimpleResp {

    /**
     * 字典类型名称
     */
    private String dictName;

    /**
     * 字典类型编码
     */
    private String dictCode;

}
