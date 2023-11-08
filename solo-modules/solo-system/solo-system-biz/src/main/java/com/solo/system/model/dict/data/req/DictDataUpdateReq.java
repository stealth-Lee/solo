package com.solo.system.model.dict.data.req;

import com.solo.system.api.constant.global.GlobalStatus;
import lombok.Data;

/**
 * 字典数据修改对象
 * @author 十一
 * @since 2023/09/26 11:42
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class DictDataUpdateReq {

    /**
     * 字典数据id
     */
    private Long dataId;

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
     * 字典排序
     */
    private Integer dictSort;

    /**
     * 状态[0禁用 1正常]
     */
    private GlobalStatus status;

    /**
     * 备注
     */
    private String remark;

}
