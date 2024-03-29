package com.solo.system.model.dict.data.resp;

import com.solo.system.api.consts.dict.DictType;
import com.solo.system.api.consts.dict.TagType;
import lombok.Data;

/**
 * 部门精简列表返回实体类
 * @author 十一
 * @since 2023/09/19 15:20
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class DictDataListSimpleResp {

    /**
     * 字典编码
     */
    private String code;

    /**
     * 字典键值
     */
    private String value;

    /**
     * 字典标签
     */
    private String label;

    /**
     * 字典类型[1:string 2:number 3:boolean]
     */
    private DictType type;

    /**
     * 标签类型
     */
    private TagType tagType;

    /**
     * 标签样式
     */
    private String tagClass;

}
