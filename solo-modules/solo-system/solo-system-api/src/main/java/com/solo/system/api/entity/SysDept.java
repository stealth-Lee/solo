package com.solo.system.api.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.solo.common.orm.base.entity.BasicEntity;
import lombok.Data;

/**
 * 部门实体类
 * @author 十一
 * @since 2023/08/31 09:58
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
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
    private String deptName;

    /**
     * 部门编码
     */
    private String deptCode;

    /**
     * 部门排序
     */
    private Integer deptSort;

}
