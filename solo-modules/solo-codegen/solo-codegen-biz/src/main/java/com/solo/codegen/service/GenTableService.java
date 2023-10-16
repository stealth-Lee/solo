package com.solo.codegen.service;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.solo.codegen.api.entity.GenTable;
import com.solo.codegen.model.table.req.TableCreateReq;
import com.solo.common.orm.base.service.BasicService;

import java.util.List;
import java.util.Map;

/**
 * 代码生成Service接口
 * @author 十一
 * @since 2023/10/08 15:43
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface GenTableService extends BasicService<GenTable> {

    boolean create(TableCreateReq req);

    List<TableInfo> selectListSimple(Long sourceId);

    Map<String, String> generationCodes(Long tableId);
}
