package com.solo.system.model.dict.data.req;

import com.solo.system.api.constant.dict.TagType;
import com.solo.system.api.constant.global.GlobalStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotEmpty(message = "{dictData.required.code}")
    @Size(message = "{dictData.size.code}", max = 32)
    private String code;

    /**
     * 字典键值
     */
    @NotEmpty(message = "{dictData.required.value}")
    @Size(message = "{dictData.size.value}", max = 32)
    private String value;

    /**
     * 字典标签
     */
    @NotEmpty(message = "{dictData.required.label}")
    @Size(message = "{dictData.size.label}", max = 32)
    private String label;

    /**
     * 标签类型
     */
    @NotEmpty(message = "{dictData.required.tagType}")
    private TagType tagType;

    /**
     * 标签样式
     */
    @Size(message = "{dictData.size.tagClass}", max = 64)
    private String tagClass;

    /**
     * 字典排序
     */
    private Integer dictSort;

    /**
     * 状态
     */
    @NotNull(message = "{dictData.required.status}")
    private GlobalStatus status;

    /**
     * 备注
     */
    @Size(message = "{dictData.size.remark}", max = 512)
    private String remark;

}
