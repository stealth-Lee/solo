package com.solo.system.service;

import com.solo.common.core.base.service.BasicService;
import com.solo.system.api.entity.SysUserPost;

import java.util.List;

/**
 * 用户岗位 Service
 * @author 十一
 * @since 2024-02-20 14:42
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface SysUserPostService extends BasicService<SysUserPost> {

    boolean save(Long userId, List<Long> postIds);

}
