package com.solo.system.web;

import com.mybatisflex.core.paginate.Page;
import com.solo.common.core.global.R;
import com.solo.common.orm.core.query.Wrappers;
import com.solo.system.api.entity.SysDictData;
import com.solo.system.model.dict.data.SysDictDataConvert;
import com.solo.system.model.dict.data.req.DictDataCreateReq;
import com.solo.system.model.dict.data.req.DictDataQueryReq;
import com.solo.system.model.dict.data.req.DictDataUpdateReq;
import com.solo.system.model.dict.data.resp.DictDataGetResp;
import com.solo.system.model.dict.data.resp.DictDataListResp;
import com.solo.system.service.SysDictDataService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.solo.system.api.entity.table.SysDictDataTableDef.SysDictDataTable;

/**
 * 字典数据控制器
 * @author 十一
 * @since 2023/09/26 11:29
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
    public R<Boolean> create(@Valid @RequestBody DictDataCreateReq req) {
        SysDictData entity = SysDictDataConvert.INSTANCE.convert(req);
        return R.success(sysDictDataService.save(entity));
    }

    /**
     * 删除字典数据
     * @param dataId 字典数据id
     * @return 响应信息
     */
    @DeleteMapping("/{dataId}")
    public R<Boolean> delete(@PathVariable Long dataId) {
        return R.success(sysDictDataService.removeById(dataId));
    }

    /**
     * 更新字典数据
     * @param req 字典数据更新对象
     * @return 响应信息
     */
    @PutMapping
    public R<Boolean> update(@Valid @RequestBody DictDataUpdateReq req) {
        SysDictData entity = SysDictDataConvert.INSTANCE.convert(req);
        return R.success(sysDictDataService.updateById(entity));
    }

    /**
     * 获取字典数据
     * @param dataId 字典数据id
     * @return 响应信息
     */
    @GetMapping("/{dataId}")
    public R<DictDataGetResp> get(@PathVariable Long dataId) {
        return R.success(SysDictDataConvert.INSTANCE.convertGet(sysDictDataService.getById(dataId)));
    }

    /**
     * 根据编码获取字典数据列表
     * @param dictCode 字典类型编码
     * @return 响应信息
     */
    @GetMapping("/code/{dictCode}")
    public R<List<SysDictData>> selectByDictCode(@PathVariable String dictCode) {
        List<SysDictData> list = sysDictDataService.queryChain().where(SysDictDataTable.DictCode.eq(dictCode)).list();
        return R.success(list);
    }

    /**
     * 分页查询字典数据列表
     * @param page 分页对象
     * @param req 字典数据查询对象
     * @return 响应信息
     */
    @GetMapping("/page")
    public R<Page<DictDataListResp>> page(Page<DictDataListResp> page, DictDataQueryReq req) {
        Page<DictDataListResp> list = sysDictDataService.pageAs(page, Wrappers.buildWhere(req), DictDataListResp.class);
        return R.success(list);
    }

}
