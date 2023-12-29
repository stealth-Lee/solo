package com.solo.system.model.dict.data.resp;

import com.solo.system.api.consts.dict.TagType;
import com.solo.system.api.consts.global.GlobalStatus;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 字典数据列表对象
 * @author 十一
 * @since 2023/09/26 11:51
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class DictDataListResp {

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
     * 标签类型
     */
    private TagType tagType;

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

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
