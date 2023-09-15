package com.solo.system.model.dept.req;

import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * 部门查询实体类
 * @author 十一
 * @since 2023/09/08 11:33
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@Table(value = "sys_dept")
public class SysDeptQueryReq {

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 部门编码
     */
    private String deptCode;

}
