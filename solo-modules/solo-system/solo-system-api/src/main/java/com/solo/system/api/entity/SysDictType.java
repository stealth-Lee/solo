package com.solo.system.api.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.solo.common.orm.base.entity.BasicEntity;
import com.solo.system.api.constant.dict.DictType;
import com.solo.system.api.constant.global.GlobalStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字典类型实体类
 * @author 十一
 * @since 2023/09/22 15:58
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Table(value = "sys_dict_type")
public class SysDictType extends BasicEntity {

    /**
     * 字典类型id
     */
    @Id(keyType = KeyType.Auto)
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
     * 字典类型[1:string 2:number 3:boolean]
     */
    private DictType dictType;

    /**
     * 字典类型状态[0停用 1正常]
     */
    private GlobalStatus status;

}
