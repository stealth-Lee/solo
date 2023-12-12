package com.solo.system.web;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.mybatisflex.core.paginate.Page;
import com.solo.common.core.global.R;
import com.solo.common.orm.core.query.Wrappers;
import com.solo.system.api.constant.global.GlobalStatus;
import com.solo.system.api.entity.SysDictType;
import com.solo.system.model.dict.type.SysDictTypeConvert;
import com.solo.system.model.dict.type.req.DictTypeCreateReq;
import com.solo.system.model.dict.type.req.DictTypeQueryReq;
import com.solo.system.model.dict.type.req.DictTypeUpdateReq;
import com.solo.system.model.dict.type.req.DictTypeUpdateStatusReq;
import com.solo.system.model.dict.type.resp.DictTypeGetResp;
import com.solo.system.model.dict.type.resp.DictTypeListResp;
import com.solo.system.model.dict.type.resp.DictTypeListSimpleResp;
import com.solo.system.service.SysDictTypeService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.solo.system.api.entity.table.SysDictTypeTableDef.SysDictTypeTable;

/**
 * 字典类型控制器
 * @author 十一
 * @since 2023/09/22 17:29
 * 人生若只如初见，何事秋风悲画扇
 **/
@RestController
@RequestMapping("/system/dict-type")
public class SysDictTypeController {

    @Resource
    private SysDictTypeService sysDictTypeService;

    /**
     * 新增字典类型
     * @param req 字典类型新增对象
     * @return 响应信息
     */
    @PostMapping
    @SaCheckPermission("system-dict-create")
    public R<Boolean> create(@Valid @RequestBody DictTypeCreateReq req) {
        SysDictType entity = SysDictTypeConvert.INSTANCE.convert(req);
        return R.success(sysDictTypeService.create(entity));
    }

    /**
     * 删除字典类型
     * @param typeId 字典类型id
     * @return 响应信息
     */
    @DeleteMapping("/{typeId}")
    @SaCheckPermission("system-dict-delete")
    public R<Boolean> delete(@PathVariable Long typeId) {
        return R.success(sysDictTypeService.delete(typeId));
    }

    /**
     * 字典类型状态切换
     * @param req 字典类型状态修改对象
     * @return 响应信息
     */
    @PutMapping("/update-status")
    @SaCheckPermission("system-dict-update-status")
    public R<Boolean> updateStatus(@Valid @RequestBody DictTypeUpdateStatusReq req) {
        SysDictType entity = SysDictTypeConvert.INSTANCE.convert(req);
        return R.success(sysDictTypeService.updateById(entity));
    }

    /**
     * 更新字典类型
     * @param req 字典类型更新对象
     * @return 响应信息
     */
    @PutMapping
    @SaCheckPermission("system-dict-update")
    public R<Boolean> update(@Valid @RequestBody DictTypeUpdateReq req) {
        SysDictType entity = SysDictTypeConvert.INSTANCE.convert(req);
        return R.success(sysDictTypeService.update(entity));
    }

    /**
     * 获取字典类型
     * @param typeId 字典类型id
     * @return 响应信息
     */
    @GetMapping("/{typeId}")
    @SaCheckPermission("system-dict-select")
    public R<DictTypeGetResp> get(@PathVariable Long typeId) {
        return R.success(SysDictTypeConvert.INSTANCE.convertGet(sysDictTypeService.getById(typeId)));
    }

    /**
     * 查询部门列表精简信息
     * @return 响应信息
     */
    @GetMapping("/list-simple")
    @SaCheckPermission("system-dict-select")
    public R<List<DictTypeListSimpleResp>> listSimple() {
        List<DictTypeListSimpleResp> list = sysDictTypeService.queryChain()
                .where(SysDictTypeTable.Status.eq(GlobalStatus.NORMAL))
                .listAs(DictTypeListSimpleResp.class);
        return R.success(list);
    }

    /**
     * 分页查询字典类型列表
     * @param page 分页对象
     * @param req 字典类型查询对象
     * @return 响应信息
     */
    @GetMapping("/page")
    @SaCheckPermission("system-dict-select")
    public R<Page<DictTypeListResp>> page(Page<DictTypeListResp> page, DictTypeQueryReq req) {
        Page<DictTypeListResp> list = sysDictTypeService.pageAs(page, Wrappers.buildWhere(req), DictTypeListResp.class);
        return R.success(list);
    }

}
