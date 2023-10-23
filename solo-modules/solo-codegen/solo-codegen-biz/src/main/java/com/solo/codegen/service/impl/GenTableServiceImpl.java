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
import com.solo.codegen.model.table.req.TableUpdateReq;
import com.solo.codegen.service.DatabaseTableService;
import com.solo.codegen.service.GenTableService;
import com.solo.codegen.service.inner.CodegenBuilder;
import com.solo.codegen.service.inner.CodegenEngine;
import com.solo.common.core.constant.Symbols;
import com.solo.common.core.utils.StringUtils;
import com.solo.common.orm.base.service.impl.BasicServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<TableInfo> selectListSimple(Long sourceId) {
        return databaseTableService.getTableList(sourceId);
    }

    @Override
    public Map<String, String> generationCodes(Long tableId) {
        GenTable table = mapper.selectOneById(tableId);
        List<GenColumn> columns = QueryChain.of(genColumnMapper).where(GenColumnTable.TableId.eq(tableId)).list();
        return codegenEngine.execute(table, columns);
    }

    /**
     * 构建表对象
     * @param tableInfo 表信息
     */
    private void buildTable(TableInfo tableInfo, GenTable genTable) {
        genTable.setTableName(tableInfo.getName());
        genTable.setTableComment(StringUtils.replaceLast(tableInfo.getComment(), "表", ""));
        genTable.setClassName(NamingCase.toPascalCase(tableInfo.getName()));
        List<String> split = StringUtils.split(genTable.getTableName(), Symbols.UNDERLINE);
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
        int index = 0;
        for (TableField field : fields) {
            TableField.MetaInfo metaInfo = field.getMetaInfo();
            int length = metaInfo.getLength();
            String type = metaInfo.getJdbcType().toString();
            String columnType = length > 0 ? type + "(" + length + ")" : type;

            GenColumn column = new GenColumn();
            column.setTableId(tableId);
            column.setColumnName(field.getName());
            column.setColumnType(columnType);
            column.setColumnSort(index++);
            column.setJavaType(StringUtils.isNotBlank(field.getPropertyType()) ? EnumUtil.getBy(JavaType::getValue, field.getPropertyType()) : JavaType.OBJECT);
            column.setJavaField(field.getPropertyName());
            column.setJavaComment(field.getComment());
            column.setIsPk(field.isKeyFlag());
            column.setIsCreate(!CodegenBuilder.CREATE_IGNORE_FIELDS.contains(field.getPropertyName()) && !field.isKeyFlag());
            column.setIsUpdate(!CodegenBuilder.UPDATE_IGNORE_FIELDS.contains(field.getPropertyName()));
            column.setIsRequired(!metaInfo.isNullable());
            column.setIsList(!CodegenBuilder.LIST_IGNORE_FIELDS.contains(field.getPropertyName()) && !field.isKeyFlag());
            column.setIsQuery(!CodegenBuilder.QUERY_IGNORE_FIELDS.contains(field.getPropertyName()) && !field.isKeyFlag());
            column.setQueryMode(QueryMode.EQ);
            initFormType(column);
            columns.add(column);
        }
        return columns;
    }

    private void initFormType(GenColumn column) {

        FormType formType = switch (column.getJavaType()) {
            case LOCAL_DATE_TIME -> FormType.DATE_TIME;
            case LOCAL_DATE -> FormType.DATE;
            case LOCAL_TIME -> FormType.TIME;
            case BOOLEAN -> FormType.SWITCH;
            default -> FormType.INPUT;
        };

        column.setFormType(formType);
    }

}
