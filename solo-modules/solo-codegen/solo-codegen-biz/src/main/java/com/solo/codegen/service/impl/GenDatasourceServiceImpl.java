package com.solo.codegen.service.impl;

import com.mybatisflex.core.query.QueryChain;
import com.solo.codegen.api.entity.GenDatasource;
import com.solo.codegen.mapper.GenDatasourceMapper;
import com.solo.codegen.service.GenDatasourceService;
import com.solo.common.core.utils.NumberUtils;
import com.solo.common.core.utils.ObjectUtils;
import com.solo.common.core.base.service.impl.BasicServiceImpl;
import com.solo.common.orm.utils.DbUtils;
import org.springframework.stereotype.Service;

import static com.solo.codegen.api.entity.table.GenDatasourceTableDef.GenDatasourceTable;
import static com.solo.common.core.utils.ServiceExceptionUtil.exception;

/**
 * 代码生成数据源Service实现类
 * @author 十一
 * @since 2023/10/08 17:34
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
public class GenDatasourceServiceImpl extends BasicServiceImpl<GenDatasourceMapper, GenDatasource> implements GenDatasourceService {

    @Override
    public boolean create(GenDatasource entity) {
        long count = QueryChain.of(mapper).where(GenDatasourceTable.Name.eq(entity.getName())).count();
        if (NumberUtils.isPositiveInteger(count)) {
            throw exception("别名已存在");
        }
        return super.save(entity);
    }

    @Override
    public boolean update(GenDatasource entity) {
        GenDatasource result = QueryChain.of(mapper).select(GenDatasourceTable.SourceId)
                .where(GenDatasourceTable.Name.eq(entity.getName())).one();
        if (ObjectUtils.isNotEmpty(result) && !result.getSourceId().equals(entity.getSourceId())) {
            throw exception("别名已存在");
        }
        return super.updateById(entity);
    }

    @Override
    public boolean test(Long sourceId) {
        GenDatasource entity = mapper.selectOneById(sourceId);
        validateConnection(entity);
        return true;
    }

    /**
     * 验证数据源连接是否有效
     * @param entity 数据源对象
     */
    private void validateConnection(GenDatasource entity) {
        boolean success = DbUtils.isConnection(entity.getUrl(), entity.getUsername(), entity.getPassword());
        if (!success) {
            throw exception("连接失败，请检查配置信息");
        }
    }

}
