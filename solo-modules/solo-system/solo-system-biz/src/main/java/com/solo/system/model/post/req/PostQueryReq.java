package com.solo.system.model.post.req;

import com.solo.common.orm.core.query.anno.Query;
import com.solo.common.orm.core.query.anno.Wrappers;
import lombok.Data;


/**
 * 岗位查询对象 req
 * @author 十一
 * @since 2024-02-18 14:13
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@Wrappers
public class PostQueryReq {

    /**
     * 岗位名称
     */
    @Query
    private String name;

    /**
     * 岗位编码
     */
    @Query
    private String code;

    /**
     * 岗位排序
     */
    @Query
    private Integer sort;

}
