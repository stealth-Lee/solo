package com.solo.system.web;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.mybatisflex.core.paginate.Page;
import com.solo.common.core.global.R;
import com.solo.common.logger.annotation.Logger;
import com.solo.common.logger.enums.LoggerType;
import com.solo.common.orm.core.query.Wrappers;
import com.solo.system.api.entity.SysPost;
import com.solo.system.model.post.SysPostConvert;
import com.solo.system.model.post.req.PostCreateReq;
import com.solo.system.model.post.req.PostQueryReq;
import com.solo.system.model.post.req.PostUpdateReq;
import com.solo.system.model.post.resp.PostGetResp;
import com.solo.system.model.post.resp.PostListResp;
import com.solo.system.model.post.resp.PostSimpleResp;
import com.solo.system.service.SysPostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 岗位控制器
 * @author 十一
 * @since 2024-02-18 14:13
 * 人生若只如初见，何事秋风悲画扇
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/system/post")
public class SysPostController {

    private final SysPostService sysPostService;

    /**
     * 新增岗位
     * @param req 岗位新增对象
     * @return 响应信息
     */
    @PostMapping
    @SaCheckPermission("system-post-create")
    @Logger(value = "新增岗位", type = LoggerType.CREATE)
    public R<Boolean> create(@Valid @RequestBody PostCreateReq req) {
        SysPost entity = SysPostConvert.INSTANCE.convert(req);
        return R.success(sysPostService.save(entity));
    }

    /**
     * 删除岗位
     * @param postIds 岗位集合
     * @return 响应信息
     */
    @DeleteMapping("/{postIds}")
    @SaCheckPermission("system-post-delete")
    @Logger(value = "删除岗位", type = LoggerType.DELETE)
    public R<Boolean> delete(@PathVariable Long[] postIds) {
        return R.success(sysPostService.removeByIds(Arrays.asList(postIds)));
    }

    /**
     * 更新岗位
     * @param req 岗位更新对象
     * @return 响应信息
     */
    @PutMapping
    @SaCheckPermission("system-post-update")
    @Logger(value = "更新岗位", type = LoggerType.UPDATE)
    public R<Boolean> update(@Valid @RequestBody PostUpdateReq req) {
        SysPost entity = SysPostConvert.INSTANCE.convert(req);
        return R.success(sysPostService.updateById(entity));
    }

    /**
     * 获取岗位
     * @param postId 岗位
     * @return 响应信息
     */
    @GetMapping("/{postId}")
    @SaCheckPermission("system-post-query")
    public R<PostGetResp> get(@PathVariable Long postId) {
        return R.success(SysPostConvert.INSTANCE.convertGet(sysPostService.getById(postId)));
    }

    /**
     * 获取精简岗位信息
     * @return 精简岗位信息
     */
    @GetMapping("/list-simple")
    @SaCheckPermission("system-post-query")
    public R<List<PostSimpleResp>> listSimple() {
        return R.success(sysPostService.listAs(PostSimpleResp.class));
    }

    /**
     * 分页查询岗位列表
     * @param page 分页对象
     * @param req 岗位查询对象
     * @return 响应信息
     */
    @GetMapping("/page")
    @SaCheckPermission("system-post-query")
    public R<Page<PostListResp>> page(Page<PostListResp> page, PostQueryReq req) {
        Page<PostListResp> list = sysPostService.pageAs(page, Wrappers.builder(req), PostListResp.class);
        return R.success(list);
    }

}
