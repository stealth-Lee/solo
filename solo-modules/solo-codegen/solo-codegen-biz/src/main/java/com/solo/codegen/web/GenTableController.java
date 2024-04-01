package com.solo.codegen.web;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ZipUtil;
import com.mybatisflex.codegen.entity.Table;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.solo.codegen.model.code.resp.CodePreviewResp;
import com.solo.codegen.model.table.GenTableConvert;
import com.solo.codegen.model.table.req.TableCreateReq;
import com.solo.codegen.model.table.req.TableQueryReq;
import com.solo.codegen.model.table.req.TableUpdateReq;
import com.solo.codegen.model.table.resp.TableGetResp;
import com.solo.codegen.model.table.resp.TableListResp;
import com.solo.codegen.model.table.resp.TableListSimpleResp;
import com.solo.codegen.service.GenTableService;
import com.solo.common.core.global.R;
import com.solo.common.core.utils.ServletUtils;
import com.solo.common.orm.core.query.Wrappers;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.solo.codegen.api.entity.table.GenTableTableDef.GenTableTable;

/**
 * 代码生成控制器
 * @author 十一
 * @since 2023/10/08 15:40
 * 人生若只如初见，何事秋风悲画扇
 **/
@RestController
@RequestMapping("/codegen/table")
public class GenTableController {

    @Resource
    private GenTableService genTableService;

    /**
     * 新增业务表
     * @param req 数据源新增对象
     * @return 响应信息
     */
    @PostMapping
    @SaCheckPermission("codegen-table-create")
    public R<Boolean> create(@Valid @RequestBody TableCreateReq req) {
        return R.success(genTableService.create(req));
    }

    @DeleteMapping("/{tableIds}")
    @SaCheckPermission("codegen-table-delete")
    public R<Boolean> delete(@PathVariable Long[] tableIds) {
        genTableService.delete(tableIds);
        return R.success();
    }

    /**
     * 修改保存代码生成业务
     */
    @PutMapping
    @SaCheckPermission("codegen-table-update")
    public R<Boolean> update(@Valid @RequestBody TableUpdateReq req) {
        genTableService.update(req);
        return R.success();
    }

    /**
     * 获取业务表详情
     * @param tableId 业务表id
     * @return 响应信息
     */
    @GetMapping("/{tableId}")
    @SaCheckPermission("codegen-table-query")
    public R<TableGetResp> get(@PathVariable Long tableId) {
        return R.success(GenTableConvert.INSTANCE.convertGet(genTableService.getById(tableId)));
    }

    /**
     * 代码预览
     * @param tableId 业务表id
     * @return 响应信息
     */
    @GetMapping("/preview/{tableId}")
    @SaCheckPermission("codegen-table-preview")
    public R<List<CodePreviewResp>> preview(@PathVariable Long tableId) {
        Map<String, String> codes = genTableService.generationCodes(tableId);
        List<CodePreviewResp> collect = codes.entrySet().stream().map(entry -> {
            CodePreviewResp respVO = new CodePreviewResp();
            respVO.setPath(entry.getKey());
            respVO.setCode(entry.getValue());
            return respVO;
        }).collect(Collectors.toList());
        return R.success(collect);
    }

    /**
     * 获取业务表精简信息
     * @param sourceId 数据源id
     * @return 响应信息
     */
    @GetMapping("/list-simple/{sourceId}")
    @SaCheckPermission("codegen-table-query")
    public R<List<TableListSimpleResp>> listSimple(@PathVariable Long sourceId) {
        List<Table> tableInfos = genTableService.selectListSimple(sourceId);
        return R.success(GenTableConvert.INSTANCE.convertListSimple(tableInfos));
    }

    /**
     * 分页查询业务表列表
     * @param page 分页对象
     * @param req 业务表查询对象
     * @return 响应信息
     */
    @GetMapping("/page")
    @SaCheckPermission("codegen-table-query")
    public R<Page<TableListResp>> page(Page<TableListResp> page, TableQueryReq req) {
        QueryWrapper queryWrapper = Wrappers.builder(req).orderBy(GenTableTable.CreateTime.desc());
        Page<TableListResp> list = genTableService.pageAs(page, queryWrapper, TableListResp.class);
        return R.success(list);
    }

    /**
     * 代码生成
     * @param tableId 业务表id
     * @param response 响应对象
     * @throws IOException io异常
     */
    @GetMapping("/generate-code/{tableId}")
    @SaCheckPermission("codegen-table-generate-code")
    public void gen(@PathVariable Long tableId, HttpServletResponse response) throws IOException {
        // 生成代码
        Map<String, String> codes = genTableService.generationCodes(tableId);
        // 构建 zip 包
        String[] paths = codes.keySet().toArray(new String[0]);
        ByteArrayInputStream[] ins = codes.values().stream().map(IoUtil::toUtf8Stream).toArray(ByteArrayInputStream[]::new);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipUtil.zip(outputStream, paths, ins);
        // 输出
        ServletUtils.writeAttachment(response, "codegen.zip", outputStream.toByteArray());
    }

}
