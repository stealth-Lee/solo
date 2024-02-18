package com.solo.system.model.post.req;

import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 岗位新增对象 req
 * @author 十一
 * @since 2024-02-18 14:13
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class PostCreateReq {

    /**
     * 岗位名称
     */
    @Size(message = "{post.size.name}", max = 64)
    private String name;

    /**
     * 岗位编码
     */
    @Size(message = "{post.size.code}", max = 64)
    private String code;

    /**
     * 岗位排序
     */
    private Integer sort;

    /**
     * 备注
     */
    @Size(message = "{post.size.remark}", max = 512)
    private String remark;

}
