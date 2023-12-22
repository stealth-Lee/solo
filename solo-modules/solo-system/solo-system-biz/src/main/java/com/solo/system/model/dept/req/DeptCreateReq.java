package com.solo.system.model.dept.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
    @NotNull(message = "{dept.required.parentId}")
    private Long parentId;

    /**
     * 部门名称
     */
    @NotEmpty(message = "{dept.required.name}")
    @Size(message = "{dept.size.name}", max = 32)
    private String name;

    /**
     * 部门编码
     */
    @NotBlank(message = "{dept.required.code}")
    @Size(message = "{dept.size.code}", max = 32)
    private String code;

    /**
     * 部门排序
     */
    private Integer sort;

    /**
     * 备注
     */
    @Size(message = "{dept.size.remark}", max = 512)
    private String remark;

}
