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
    public R<Boolean> create(@RequestBody SysDeptInsertReq req) {
        SysDept sysDept = SysDeptConvert.INSTANCE.convert(req);
        return R.success(sysDeptService.create(sysDept));
    }

    /**
     * 删除部门
     * @param deptId 部门id
     * @return 响应信息
     */
    @DeleteMapping("/{deptId}")
    public R<Boolean> delete(@PathVariable Long deptId) {
        return R.success(sysDeptService.delete(deptId));
    }

    /**
     * 更新部门
     * @param req 部门更新对象
     * @return 响应信息
     */
    @PutMapping
    public R<Boolean> update(@RequestBody SysDeptUpdateReq req) {
        SysDept sysDept = SysDeptConvert.INSTANCE.convert(req);
        return R.success(sysDeptService.update(sysDept));
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
        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.select(SysDeptQueryReq::getDeptName, SysDeptQueryReq::setDeptCode)
//                .from("SysDeptQueryReq::new,SysDeptQueryReq::new")
//                .where(SysDeptQueryReq::getDeptName).like(req.getDeptName())
//                .and(SysDeptInsertReq::getDeptCode).eq(req.getDeptCode());
        List<SysDept> list = sysDeptService.list(queryWrapper);
        return R.success(list);
    }

}
