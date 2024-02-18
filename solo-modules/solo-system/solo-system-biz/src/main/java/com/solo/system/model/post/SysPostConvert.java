package com.solo.system.model.post;

import com.solo.system.api.entity.SysPost;
import com.solo.system.model.post.req.PostCreateReq;
import com.solo.system.model.post.req.PostUpdateReq;
import com.solo.system.model.post.resp.PostGetResp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 岗位实体转换类
 * @author 十一
 * @since 2024-02-18 14:13
 * 人生若只如初见，何事秋风悲画扇
 **/
@Mapper
public interface SysPostConvert {

    SysPostConvert INSTANCE = Mappers.getMapper(SysPostConvert.class);

    SysPost convert(PostCreateReq bean);

    SysPost convert(PostUpdateReq bean);

    PostGetResp convertGet(SysPost bean);

}
