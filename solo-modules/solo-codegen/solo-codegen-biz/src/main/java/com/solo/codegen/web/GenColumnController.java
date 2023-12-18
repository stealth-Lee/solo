package com.solo.codegen.web;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.solo.codegen.model.column.resp.ColumnListResp;
import com.solo.codegen.service.GenColumnService;
import com.solo.common.core.global.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.solo.codegen.api.entity.table.GenColumnTableDef.GenColumnTable;

/**
 * 代码生成列控制器类
 * @author 十一
 * @since 2023/10/11 15:31
 * 人生若只如初见，何事秋风悲画扇
 **/
@RestController
@RequestMapping("/codegen/column")
public class GenColumnController {

    @Resource
    private GenColumnService genColumnService;

    /**
     * 查询列的列表精简信息
     * @return 响应信息
     */
    @GetMapping("/{tableId}")
    @SaCheckPermission("codegen-table-query")
    public R<List<ColumnListResp>> listSimple(@PathVariable String tableId) {
        return R.success(genColumnService.queryChain().where(GenColumnTable.TableId.eq(tableId)).listAs(ColumnListResp.class));
    }

}
