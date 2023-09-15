package com.solo.system.model.dept.req;

import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * 部门新增实体类
 * @author 十一
 * @since 2023/09/08 10:11
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@Table(value = "sys_user")
public class SysDeptInsertReq {

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

    /**
     * 备注
     */
    private String remark;

}
