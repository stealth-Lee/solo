package com.solo.codegen.service.impl;

import cn.hutool.core.text.NamingCase;
import cn.hutool.core.util.EnumUtil;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.mybatisflex.core.query.QueryChain;
import com.solo.codegen.api.constant.column.FormType;
import com.solo.codegen.api.constant.column.JavaType;
import com.solo.codegen.api.constant.column.QueryMode;
import com.solo.codegen.api.entity.GenColumn;
import com.solo.codegen.api.entity.GenTable;
import com.solo.codegen.mapper.GenColumnMapper;
import com.solo.codegen.mapper.GenTableMapper;
import com.solo.codegen.model.table.GenTableConvert;
import com.solo.codegen.model.table.req.TableCreateReq;
import com.solo.codegen.service.DatabaseTableService;
import com.solo.codegen.service.GenTableService;
import com.solo.codegen.service.inner.CodegenEngine;
import com.solo.common.core.utils.StringUtils;
import com.solo.common.orm.base.service.impl.BasicServiceImpl;
import com.solo.system.api.constant.global.YesNo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class GenTableServiceImpl extends BasicServiceImpl<GenTableMapper, GenTable> implements GenTableService {

    @Resource
    private DatabaseTableService databaseTableService;
    @Resource
    private GenColumnMapper genColumnMapper;
    @Resource
    private CodegenEngine codegenEngine;


    @Override
    public boolean create(TableCreateReq req) {
        GenTable genTable = GenTableConvert.INSTANCE.convert(req);
        TableInfo table = databaseTableService.getTable(req.getSourceId(), req.getTableName());
        buildTable(table, genTable);
        mapper.insert(genTable, true);
        List<GenColumn> columns = buildColumn(genTable.getTableId(), table.getFields());
        int i = genColumnMapper.insertBatch(columns);
        return false;
    }

    @Override
    public List<TableInfo> selectListSimple(Long sourceId) {
        List<TableInfo> tableList = databaseTableService.getTableList(sourceId);
        return tableList;
    }

    @Override
    public Map<String, String> generationCodes(Long tableId) {
        GenTable table = mapper.selectOneById(tableId);
//        genColumnMapper.selectList
        List<GenColumn> columns = QueryChain.of(genColumnMapper).where(GenColumnTable.TableId.eq(tableId)).list();
        List<GenColumn> dictColumns = QueryChain.of(genColumnMapper).
                where(GenColumnTable.TableId.eq(tableId)).and(GenColumnTable.DictCode.isNotNull()).list();

        return codegenEngine.execute(table, columns, dictColumns);
    }

    /**
     * 构建表对象
     * @param tableInfo 表信息
     */
    private void buildTable(TableInfo tableInfo, GenTable genTable) {
        genTable.setTableName(tableInfo.getName());
        genTable.setTableComment(tableInfo.getComment());
        genTable.setClassName(NamingCase.toPascalCase(tableInfo.getName()));
        List<String> split = StringUtils.split(genTable.getTableName(), "_");
        genTable.setPackageName("com.solo." + split.get(0));
        genTable.setModuleName(split.get(0));
        genTable.setBusinessName(split.get(1));
    }

    /**
     * 构建列对象
     * @param tableId 表id
     * @param fields 字段信息
     * @return 列对象
     */
    private List<GenColumn> buildColumn(Long tableId, List<TableField> fields) {
        List<GenColumn> columns = new ArrayList<>();
        for (TableField field : fields) {
            GenColumn column = new GenColumn();
            column.setTableId(tableId);
            column.setColumnName(field.getName());
            column.setColumnType(field.getMetaInfo().getJdbcType().toString());
//            column.setColumnSort();
            column.setJavaType(EnumUtil.getBy(JavaType::getValue, field.getPropertyType()));
            column.setJavaField(field.getPropertyName());
            column.setJavaComment(field.getComment());
            column.setIsPk(EnumUtil.getBy(YesNo::getValue, field.isKeyFlag()));
            column.setIsInsert(YesNo.YES);
            column.setIsUpdate(YesNo.YES);
            column.setIsRequired(YesNo.YES);
            column.setIsList(YesNo.YES);
            column.setIsQuery(YesNo.YES);
            column.setQueryMode(QueryMode.EQ);
            column.setFormType(FormType.INPUT);
            columns.add(column);
        }
        return columns;
    }

}
