package com.solo.codegen.model.table;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.solo.codegen.api.entity.GenTable;
import com.solo.codegen.model.table.req.TableCreateReq;
import com.solo.codegen.model.table.resp.TableGetResp;
import com.solo.codegen.model.table.resp.TableListSimpleResp;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 代码生成数据源转换类
 * @author 十一
 * @since 2023/10/09 11:10
 * 人生若只如初见，何事秋风悲画扇
 **/
@Mapper
public interface GenTableConvert {

    GenTableConvert INSTANCE = Mappers.getMapper(GenTableConvert.class);

    GenTable convert(TableCreateReq req);

    TableGetResp convertGet(GenTable entity);

    @Mappings({
            @Mapping(source = "name", target = "tableName"),
            @Mapping(source = "comment", target = "tableComment"),
    })
    TableListSimpleResp convertListSimple(TableInfo entity);

    List<TableListSimpleResp> convertListSimple(List<TableInfo> list);
}
