package com.solo.system.model.dept.req;

import jakarta.validation.constraints.NotNull;
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
public class DeptUpdateReq extends DeptCreateReq {

    /**
     * 部门id
     */
    @NotNull(message = "部门id不能为空")
    private Long deptId;

}
