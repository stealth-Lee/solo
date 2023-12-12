package com.solo.system.web;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.mybatisflex.core.query.QueryWrapper;
import com.solo.common.core.global.R;
import com.solo.common.orm.core.query.Wrappers;
import com.solo.system.api.entity.SysDept;
import com.solo.system.model.dept.SysDeptConvert;
import com.solo.system.model.dept.req.DeptCreateReq;
import com.solo.system.model.dept.req.DeptQueryReq;
import com.solo.system.model.dept.req.DeptUpdateReq;
import com.solo.system.model.dept.resp.DeptGetResp;
import com.solo.system.model.dept.resp.DeptListResp;
import com.solo.system.model.dept.resp.DeptListSimpleResp;
import com.solo.system.service.SysDeptService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @SaCheckPermission("system-dept-create")
    public R<Boolean> create(@Valid @RequestBody DeptCreateReq req) {
        SysDept sysDept = SysDeptConvert.INSTANCE.convert(req);
        return R.success(sysDeptService.create(sysDept));
    }

    /**
     * 删除部门
     * @param deptId 部门id
     * @return 响应信息
     */
    @DeleteMapping("/{deptId}")
    @SaCheckPermission("system-dept-delete")
    public R<Boolean> delete(@PathVariable Long deptId) {
        return R.success(sysDeptService.delete(deptId));
    }

    /**
     * 更新部门
     * @param req 部门更新对象
     * @return 响应信息
     */
    @PutMapping
    @SaCheckPermission("system-dept-update")
    public R<Boolean> update(@Valid @RequestBody DeptUpdateReq req) {
        SysDept sysDept = SysDeptConvert.INSTANCE.convert(req);
        return R.success(sysDeptService.update(sysDept));
    }

    /**
     * 获取部门
     * @param deptId 部门id
     * @return 响应信息
     */
    @GetMapping("/{deptId}")
    @SaCheckPermission("system-dept-select")
    public R<DeptGetResp> get(@PathVariable Long deptId) {
        return R.success(SysDeptConvert.INSTANCE.convertGet(sysDeptService.getById(deptId)));
    }

    /**
     * 查询部门列表精简信息
     * @return 响应信息
     */
    @GetMapping("/list-simple")
    @SaCheckPermission("system-dept-select")
    public R<List<DeptListSimpleResp>> listSimple() {
        return R.success(sysDeptService.listAs(DeptListSimpleResp.class));
    }

    /**
     * 查询部门树列表
     * @param req 查询对象
     * @return 响应信息
     */
    @GetMapping("/list")
    @SaCheckPermission("system-dept-select")
    public R<List<DeptListResp>> list(DeptQueryReq req) {
        QueryWrapper queryWrapper = Wrappers.buildWhere(req);
        return R.success(sysDeptService.listAs(queryWrapper, DeptListResp.class));
    }

}
