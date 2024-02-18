package com.solo.system.model.post.resp;

import lombok.Data;

/**
 * 岗位详情对象 resp
 * @author 十一
 * @since 2024-02-18 14:13
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class PostGetResp {

    /**
     * id
     */
    private Long postId;

    /**
     * 岗位名称
     */
    private String name;

    /**
     * 岗位编码
     */
    private String code;

    /**
     * 岗位排序
     */
    private Integer sort;

    /**
     * 备注
     */
    private String remark;

}
