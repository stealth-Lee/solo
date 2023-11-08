package com.solo.system.api.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.solo.common.orm.base.entity.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门实体类
 * @author 十一
 * @since 2023/08/31 09:58
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Table(value = "sys_dept")
public class SysDept extends BasicEntity {

    /**
     * 部门id
     */
    @Id(keyType = KeyType.Auto)
    private Long deptId;

    /**
     * 父级部门id
     */
    private Long parentId;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 部门编码
     */
    private String code;

    /**
     * 部门排序
     */
    private Integer sort;

}
