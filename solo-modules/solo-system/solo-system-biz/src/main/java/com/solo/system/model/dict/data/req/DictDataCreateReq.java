package com.solo.system.model.dict.data.req;

import com.solo.system.api.constant.dict.TagType;
import com.solo.system.api.constant.global.GlobalStatus;
import lombok.Data;

/**
 * 字典数据新增对象
 * @author 十一
 * @since 2023/09/26 11:33
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class DictDataCreateReq {

    /**
     * 字典编码
     */
    private String dictCode;

    /**
     * 字典键值
     */
    private String dictValue;

    /**
     * 字典标签
     */
    private String dictLabel;

    /**
     * 标签类型
     */
    private TagType tagType;

    /**
     * 标签样式
     */
    private String tagClass;

    /**
     * 字典排序
     */
    private Integer dictSort;

    /**
     * 状态
     */
    private GlobalStatus status;

    /**
     * 备注
     */
    private String remark;

}
