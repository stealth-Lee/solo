package com.solo.system.service.impl;

import com.solo.common.core.base.service.impl.BasicServiceImpl;
import com.solo.system.api.entity.SysUserPost;
import com.solo.system.mapper.SysUserPostMapper;
import com.solo.system.service.SysUserPostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 用户岗位 Service实现类
 * @author 十一
 * @since 2024-02-20 14:42
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
public class SysUserPostServiceImpl extends BasicServiceImpl<SysUserPostMapper, SysUserPost> implements SysUserPostService {

    @Override
    public boolean save(Long userId, List<Long> postIds) {
        Optional.ofNullable(postIds).ifPresent(ids -> {
            ids.forEach(postId -> {
                SysUserPost userPost = new SysUserPost();
                userPost.setUserId(userId);
                userPost.setPostId(postId);
                mapper.insert(userPost);
            });
        });
        return false;
    }

}
