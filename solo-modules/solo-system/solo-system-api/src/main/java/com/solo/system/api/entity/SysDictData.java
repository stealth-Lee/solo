package com.solo.system.api.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.solo.common.core.base.entity.BasicEntity;
import com.solo.system.api.constant.dict.TagType;
import com.solo.system.api.constant.global.GlobalStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字典数据实体类
 * @author 十一
 * @since 2023/09/26 11:25
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Table(value = "sys_dict_data")
public class SysDictData extends BasicEntity {

    /**
     * 字典数据id
     */
    @Id(keyType = KeyType.Auto)
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
     * 标签样式
     */
    private String tagClass;

    /**
     * 字典排序
     */
    private Integer dictSort;

    /**
     * 状态[0禁用 1正常]
     */
    private GlobalStatus status;

}
