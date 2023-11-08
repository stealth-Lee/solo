package com.solo.system.model.dept.resp;

import lombok.Data;

/**
 * 部门精简列表返回实体类
 * @author 十一
 * @since 2023/09/19 15:20
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class DeptListSimpleResp {

    /**
     * 部门id
     */
    private Long deptId;

    /**
     * 父级部门id
     */
    private Long parentId;

    /**
     * 部门名称
     */
    private String name;

}
