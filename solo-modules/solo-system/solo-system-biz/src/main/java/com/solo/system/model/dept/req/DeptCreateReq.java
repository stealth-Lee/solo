package com.solo.system.model.dept.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 部门新增实体类
 * @author 十一
 * @since 2023/09/08 10:11
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class DeptCreateReq {

    /**
     * 父级部门id
     */
    private Long parentId;

    /**
     * 部门名称
     */
    @NotBlank(message = "部门名称不能为空")
    @Size(max = 32, message = "部门名称长度不能超过32个字符")
    private String deptName;

    /**
     * 部门编码
     */
    @NotBlank(message = "部门编码不能为空")
    @Size(max = 32, message = "部门编码长度不能超过32个字符")
    private String deptCode;

    /**
     * 部门排序
     */
    @NotNull(message = "部门排序不能为空")
    private Integer deptSort;

    /**
     * 备注
     */
    private String remark;

}
