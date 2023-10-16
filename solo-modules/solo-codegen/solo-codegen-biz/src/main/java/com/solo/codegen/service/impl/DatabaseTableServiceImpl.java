package com.solo.codegen.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.solo.codegen.api.entity.GenDatasource;
import com.solo.codegen.mapper.GenDatasourceMapper;
import com.solo.codegen.service.DatabaseTableService;
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
    public List<TableInfo> getTableList(Long sourceId) {
        return getTableList(sourceId, null);
    }

    @Override
    public TableInfo getTable(Long sourceId, String tableName) {
        return CollUtil.getFirst(getTableList(sourceId, tableName));
    }

    private List<TableInfo> getTableList(Long sourceId, String tableName) {
        GenDatasource config = genDatasourceMapper.selectOneById(sourceId);
        Assert.notNull(config, "数据源[{}] 不存在！", sourceId);
        // 使用 MyBatis Plus Generator 解析表结构
        DataSourceConfig dataSourceConfig = new DataSourceConfig.Builder(config.getUrl(), config.getUsername(),
                config.getPassword()).build();
        StrategyConfig.Builder strategyConfig = new StrategyConfig.Builder();
        if (StrUtil.isNotEmpty(tableName)) {
            strategyConfig.addInclude(tableName);
        }
        GlobalConfig globalConfig = new GlobalConfig.Builder().dateType(DateType.TIME_PACK).build(); // 只使用 LocalDateTime 类型，不使用 LocalDate
        ConfigBuilder builder = new ConfigBuilder(null, dataSourceConfig, strategyConfig.build(),
                null, globalConfig, null);
        // 按照名字排序
        List<TableInfo> tables = builder.getTableInfoList();
        tables.sort(Comparator.comparing(TableInfo::getName));
        return tables;
    }

}
