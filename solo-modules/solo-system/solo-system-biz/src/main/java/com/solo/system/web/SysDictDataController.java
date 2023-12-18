package com.solo.system.web;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.solo.common.core.global.R;
import com.solo.common.orm.core.query.Wrappers;
import com.solo.system.api.constant.global.GlobalStatus;
import com.solo.system.api.entity.SysDictData;
import com.solo.system.model.dict.data.SysDictDataConvert;
import com.solo.system.model.dict.data.req.DictDataCreateReq;
import com.solo.system.model.dict.data.req.DictDataQueryReq;
import com.solo.system.model.dict.data.req.DictDataUpdateReq;
import com.solo.system.model.dict.data.req.DictDataUpdateStatusReq;
import com.solo.system.model.dict.data.resp.DictDataGetResp;
import com.solo.system.model.dict.data.resp.DictDataListResp;
import com.solo.system.model.dict.data.resp.DictDataListSimpleResp;
import com.solo.system.service.SysDictDataService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static com.solo.system.api.entity.table.SysDictDataTableDef.SysDictDataTable;
import static com.solo.system.api.entity.table.SysDictTypeTableDef.SysDictTypeTable;

/**
 * 字典数据控制器
 * @author 十一
 * @since 2023-10-27 16:08
 * 人生若只如初见，何事秋风悲画扇
 **/
@RestController
@RequestMapping("/system/dict-data")
public class SysDictDataController {

    @Resource
    private SysDictDataService sysDictDataService;

    /**
     * 新增字典数据
     * @param req 字典数据新增对象
     * @return 响应信息
     */
    @PostMapping
    @SaCheckPermission("system-dict-create")
    public R<Boolean> create(@Valid @RequestBody DictDataCreateReq req) {
        SysDictData entity = SysDictDataConvert.INSTANCE.convert(req);
        return R.success(sysDictDataService.save(entity));
    }

    /**
     * 删除字典数据
     * @param dataIds 字典数据集合
     * @return 响应信息
     */
    @DeleteMapping("/{dataIds}")
    @SaCheckPermission("system-dict-delete")
    public R<Boolean> delete(@PathVariable Long[] dataIds) {
        return R.success(sysDictDataService.removeByIds(Arrays.asList(dataIds)));
    }

    /**
     * 字典数据状态切换
     * @param req 字典数据状态修改对象
     * @return 响应信息
     */
    @PutMapping("/update-status")
    @SaCheckPermission("system-dict-update-status")
    public R<Boolean> updateStatus(@Valid @RequestBody DictDataUpdateStatusReq req) {
        SysDictData entity = SysDictDataConvert.INSTANCE.convert(req);
        return R.success(sysDictDataService.updateById(entity));
    }

    /**
     * 更新字典数据
     * @param req 字典数据更新对象
     * @return 响应信息
     */
    @PutMapping
    @SaCheckPermission("system-dict-update")
    public R<Boolean> update(@Valid @RequestBody DictDataUpdateReq req) {
        SysDictData entity = SysDictDataConvert.INSTANCE.convert(req);
        return R.success(sysDictDataService.updateById(entity));
    }

    /**
     * 根据编码获取字典数据列表
     * @param code 字典类型编码
     * @return 响应信息
     */
    @GetMapping("/code/{code}")
    public R<List<DictDataListSimpleResp>> selectByCode(@PathVariable("code") String code) {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select(SysDictDataTable.AllColumns,
                        SysDictTypeTable.Type)
                .from(SysDictTypeTable)
                .leftJoin(SysDictDataTable)
                .on(SysDictTypeTable.Code.eq(SysDictDataTable.Code))
                .where(SysDictTypeTable.Code.eq(code)).and(SysDictTypeTable.Status.eq(GlobalStatus.NORMAL));
        List<DictDataListSimpleResp> list = sysDictDataService.listAs(queryWrapper, DictDataListSimpleResp.class);
        return R.success(list);
    }

    /**
     * 获取字典数据
     * @param dataId 字典数据
     * @return 响应信息
     */
    @GetMapping("/{dataId}")
    @SaCheckPermission("system-dict-query")
    public R<DictDataGetResp> get(@PathVariable("dataId") Long dataId) {
        return R.success(SysDictDataConvert.INSTANCE.convertGet(sysDictDataService.getById(dataId)));
    }

    /**
     * 分页查询字典数据列表
     * @param page 分页对象
     * @param req 字典数据查询对象
     * @return 响应信息
     */
    @GetMapping("/page")
    @SaCheckPermission("system-dict-query")
    public R<Page<DictDataListResp>> page(Page<DictDataListResp> page, DictDataQueryReq req) {
        Page<DictDataListResp> list = sysDictDataService.pageAs(page, Wrappers.buildWhere(req), DictDataListResp.class);
        return R.success(list);
    }

}
