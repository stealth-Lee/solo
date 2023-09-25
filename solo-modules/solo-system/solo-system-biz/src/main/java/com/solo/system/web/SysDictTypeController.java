package com.solo.system.web;

import com.mybatisflex.core.paginate.Page;
import com.solo.common.core.global.R;
import com.solo.common.orm.core.query.Wrappers;
import com.solo.system.api.entity.SysDictType;
import com.solo.system.model.dict.type.SysDictTypeConvert;
import com.solo.system.model.dict.type.req.DictTypeCreateReq;
import com.solo.system.model.dict.type.req.DictTypeQueryReq;
import com.solo.system.model.dict.type.req.DictTypeUpdateReq;
import com.solo.system.model.dict.type.resp.DictTypeGetResp;
import com.solo.system.model.dict.type.resp.DictTypeListResp;
import com.solo.system.service.SysDictTypeService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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
    public R<Boolean> delete(@PathVariable Long typeId) {
        return R.success(sysDictTypeService.delete(typeId));
    }

    /**
     * 更新字典类型
     * @param req 字典类型更新对象
     * @return 响应信息
     */
    @PutMapping
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
    public R<DictTypeGetResp> get(@PathVariable Long typeId) {
        return R.success(SysDictTypeConvert.INSTANCE.convertGet(sysDictTypeService.getById(typeId)));
    }

    /**
     * 分页查询字典类型列表
     * @param page 分页对象
     * @param req 字典类型查询对象
     * @return 响应信息
     */
    @GetMapping("/page")
    public R<Page<DictTypeListResp>> page(Page<DictTypeListResp> page, DictTypeQueryReq req) {
        Page<DictTypeListResp> list = sysDictTypeService.pageAs(page, Wrappers.buildWhere(req), DictTypeListResp.class);
        return R.success(list);
    }

}
