package com.solo.system.model.dept.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门更新实体类
 * @author 十一
 * @since 2023/09/08 16:13
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptUpdateReq extends DeptInsertReq {

    /**
     * 部门id
     */
    private Long deptId;

}
