package com.solo.codegen.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Assert;
import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.entity.Table;
import com.solo.codegen.api.entity.GenDatasource;
import com.solo.codegen.mapper.GenDatasourceMapper;
import com.solo.codegen.service.DatabaseTableService;
import com.solo.common.core.utils.StringUtils;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/**
 * 数据库表 Service 实现类
 * @author 十一
 * @since 2023/10/10 15:02
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
public class DatabaseTableServiceImpl implements DatabaseTableService {

    @Resource
    private GenDatasourceMapper genDatasourceMapper;

    @Override
    public List<Table> getTableList(Long sourceId) {
        return getTableList(sourceId, null);
    }

    @Override
    public Table getTable(Long sourceId, String name) {
        return CollUtil.getFirst(getTableList(sourceId, name));
    }

    private List<Table> getTableList(Long sourceId, String name) {
        GenDatasource config = genDatasourceMapper.selectOneById(sourceId);
        Assert.notNull(config, "数据源[{}] 不存在！", sourceId);
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(config.getUrl());
        dataSource.setUsername(config.getUsername());
        dataSource.setPassword(config.getPassword());
        GlobalConfig globalConfig = new GlobalConfig();
        if (StringUtils.isNotEmpty(name)) {
            globalConfig.getStrategyConfig().setGenerateTable(name);
        }
        Generator generator = new Generator(dataSource, globalConfig);
        List<Table> tables = generator.getTables();
        tables.sort(Comparator.comparing(Table::getName));
        return tables;
    }

}
