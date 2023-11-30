package com.solo.codegen.service.impl;

import com.mybatisflex.codegen.entity.Table;
import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.core.update.UpdateChain;
import com.solo.codegen.api.entity.GenColumn;
import com.solo.codegen.api.entity.GenTable;
import com.solo.codegen.mapper.GenColumnMapper;
import com.solo.codegen.mapper.GenTableMapper;
import com.solo.codegen.model.table.GenTableConvert;
import com.solo.codegen.model.table.req.TableCreateReq;
import com.solo.codegen.model.table.req.TableUpdateReq;
import com.solo.codegen.service.DatabaseTableService;
import com.solo.codegen.service.GenTableService;
import com.solo.codegen.service.inner.CodegenBuilder;
import com.solo.codegen.service.inner.CodegenEngine;
import com.solo.common.orm.base.service.impl.BasicServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.solo.codegen.api.entity.table.GenColumnTableDef.GenColumnTable;

/**
 * 代码生成Service实现类
 * @author 十一
 * @since 2023/10/08 15:51
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
public class IGenTableServiceImpl extends BasicServiceImpl<GenTableMapper, GenTable> implements GenTableService {

    @Resource
    private DatabaseTableService databaseTableService;
    @Resource
    private GenColumnMapper genColumnMapper;
    @Resource
    private CodegenEngine codegenEngine;
    @Resource
    private CodegenBuilder codegenBuilder;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean create(TableCreateReq req) {
        GenTable genTable = GenTableConvert.INSTANCE.convert(req);
        Table table = databaseTableService.getTable(req.getSourceId(), req.getName());
        codegenBuilder.buildTable(table, genTable);
        mapper.insert(genTable, true);
        List<GenColumn> columns = codegenBuilder.buildColumn(genTable.getTableId(), table.getColumns());
        columns.forEach(column -> genColumnMapper.insert(column, true));
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Long[] tableIds) {
        mapper.deleteBatchByIds(Arrays.asList(tableIds));
        for (Long tableId : tableIds) {
            UpdateChain.of(genColumnMapper).where(GenColumnTable.TableId.eq(tableId)).remove();
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(TableUpdateReq req) {
        GenTable table = req.getTable();
        int update = mapper.update(table);
        if (update > 0) {
            List<GenColumn> columns = req.getColumns();
            columns.forEach(column -> genColumnMapper.update(column));
        }
        return true;
    }

    @Override
    public List<Table> selectListSimple(Long sourceId) {
        return databaseTableService.getTableList(sourceId);
    }

    @Override
    public Map<String, String> generationCodes(Long tableId) {
        GenTable table = mapper.selectOneById(tableId);
        List<GenColumn> columns = QueryChain.of(genColumnMapper).where(GenColumnTable.TableId.eq(tableId)).list();
        return codegenEngine.execute(table, columns);
    }

}
