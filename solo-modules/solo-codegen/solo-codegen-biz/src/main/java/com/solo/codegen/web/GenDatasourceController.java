package com.solo.codegen.web;

import com.mybatisflex.core.paginate.Page;
import com.solo.codegen.api.entity.GenDatasource;
import com.solo.codegen.model.datasource.GenDatasourceConvert;
import com.solo.codegen.model.datasource.req.DatasourceCreateReq;
import com.solo.codegen.model.datasource.req.DatasourceQueryReq;
import com.solo.codegen.model.datasource.req.DatasourceUpdateReq;
import com.solo.codegen.model.datasource.resp.DatasourceGetResp;
import com.solo.codegen.model.datasource.resp.DatasourceListResp;
import com.solo.codegen.service.GenDatasourceService;
import com.solo.common.core.global.R;
import com.solo.common.orm.core.query.Wrappers;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * 代码生成数据源控制器类
 * @author 十一
 * @since 2023/10/08 17:32
 * 人生若只如初见，何事秋风悲画扇
 **/
@RestController
@RequestMapping("/codegen/datasource")
public class GenDatasourceController {

    @Resource
    private GenDatasourceService genDatasourceService;

    /**
     * 新增数据源
     * @param req 数据源新增对象
     * @return 响应信息
     */
    @PostMapping
    public R<Boolean> create(@Valid @RequestBody DatasourceCreateReq req) {
        GenDatasource entity = GenDatasourceConvert.INSTANCE.convert(req);
        return R.success(genDatasourceService.create(entity));
    }

    /**
     * 删除数据源
     * @param sourceIds 数据源id集合
     * @return 响应信息
     */
    @DeleteMapping("/{sourceIds}")
    public R<Boolean> delete(@PathVariable Long[] sourceIds) {
        return R.success(genDatasourceService.removeByIds(Arrays.asList(sourceIds)));
    }

    /**
     * 更新数据源
     * @param req 数据源更新对象
     * @return 响应信息
     */
    @PutMapping
    public R<Boolean> update(@Valid @RequestBody DatasourceUpdateReq req) {
        GenDatasource entity = GenDatasourceConvert.INSTANCE.convert(req);
        return R.success(genDatasourceService.update(entity));
    }

    /**
     * 获取数据源
     * @param sourceId 数据源id
     * @return 响应信息
     */
    @GetMapping("/{sourceId}")
    public R<DatasourceGetResp> get(@PathVariable Long sourceId) {
        return R.success(GenDatasourceConvert.INSTANCE.convertGet(genDatasourceService.getById(sourceId)));
    }

    /**
     * 分页查询数据源列表
     * @param page 分页对象
     * @param req 数据源查询对象
     * @return 响应信息
     */
    @GetMapping("/page")
    public R<Page<DatasourceListResp>> page(Page<DatasourceListResp> page, DatasourceQueryReq req) {
        Page<DatasourceListResp> list = genDatasourceService.pageAs(page, Wrappers.buildWhere(req), DatasourceListResp.class);
        return R.success(list);
    }
    
}
