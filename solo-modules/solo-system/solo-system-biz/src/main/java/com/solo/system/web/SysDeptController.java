package com.solo.system.web;

import com.mybatisflex.core.query.QueryWrapper;
import com.solo.common.core.global.R;
import com.solo.system.api.entity.SysDept;
import com.solo.system.model.dept.SysDeptConvert;
import com.solo.system.model.dept.req.SysDeptInsertReq;
import com.solo.system.model.dept.req.SysDeptQueryReq;
import com.solo.system.model.dept.req.SysDeptUpdateReq;
import com.solo.system.service.SysDeptService;
import jakarta.annotation.Resource;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.solo.common.core.utils.ServiceExceptionUtil.exception;

/**
 * 部门控制器
 * @author 十一
 * @since 2023/09/01 10:24
 * 人生若只如初见，何事秋风悲画扇
 **/
@RestController
@RequestMapping("/system/dept")
public class SysDeptController {

    @Resource
    private SysDeptService sysDeptService;

    /**
     * 新增部门
     * @param req 部门新增对象
     * @return 响应信息
     */
    @PostMapping
    public R<Boolean> insert(@RequestBody SysDeptInsertReq req) {
        SysDept sysDept = SysDeptConvert.INSTANCE.convert(req);
        return R.success(sysDeptService.save(sysDept));
    }

    /**
     * 删除部门
     * @param deptId 部门id
     * @return 响应信息
     */
    @DeleteMapping("/{deptId}")
    public R<Boolean> delete(@PathVariable Long deptId) {
        QueryWrapper query = QueryWrapper.create();
        query.where(SysDept::getParentId).eq(deptId);
        List<SysDept> result = sysDeptService.list(query);
        if (!ObjectUtils.isEmpty(result)) {
            throw exception("该部门下存在子部门，无法删除");
        }
        return R.success(sysDeptService.removeById(deptId));
    }

    /**
     * 更新部门
     * @param req 部门更新对象
     * @return 响应信息
     */
    @PutMapping
    public R<Boolean> update(@RequestBody SysDeptUpdateReq req) {
        SysDept sysDept = SysDeptConvert.INSTANCE.convert(req);
        return R.success(sysDeptService.updateById(sysDept));
    }

    /**
     * 获取部门
     * @param deptId 部门id
     * @return 响应信息
     */
    @GetMapping("/{deptId}")
    public R<SysDept> get(@PathVariable Long deptId) {
        return R.success(sysDeptService.getById(deptId));
    }

    /**
     * 查询部门树列表
     * @param req 查询对象
     * @return 响应信息
     */
    @GetMapping("/tree")
    public R<List<SysDept>> tree(SysDeptQueryReq req) {
        SysDept sysDept = SysDeptConvert.INSTANCE.convert(req);
        List<SysDept> list = sysDeptService.list(QueryWrapper.create(sysDept));
        return R.success(list);
    }



}
