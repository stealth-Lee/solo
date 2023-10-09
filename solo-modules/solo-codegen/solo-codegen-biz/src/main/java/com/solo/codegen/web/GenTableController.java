package com.solo.codegen.web;

import com.mybatisflex.core.paginate.Page;
import com.solo.codegen.model.table.req.TableQueryReq;
import com.solo.codegen.model.table.resp.TableListResp;
import com.solo.codegen.service.GenTableService;
import com.solo.common.core.global.R;
import com.solo.common.orm.core.query.Wrappers;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * 分页查询代码生成业务表列表
     * @param page 分页对象
     * @param req 业务表查询对象
     * @return 响应信息
     */
    @GetMapping("/page")
    public R<Page<TableListResp>> page(Page<TableListResp> page, TableQueryReq req) {
        Page<TableListResp> list = genTableService.pageAs(page, Wrappers.buildWhere(req), TableListResp.class);
        return R.success(list);
    }

}
