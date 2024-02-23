package com.solo.system.dubbo;

import com.mybatisflex.core.query.QueryWrapper;
import com.solo.system.api.SysDictApi;
import com.solo.system.api.consts.global.GlobalStatus;
import com.solo.system.api.entity.SysDictData;
import com.solo.system.mapper.SysDictDataMapper;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static com.solo.system.api.entity.table.SysDictDataTableDef.SysDictDataTable;
import static com.solo.system.api.entity.table.SysDictTypeTableDef.SysDictTypeTable;

/**
 * 字典实现类
 * @author 十一
 * @since 2023/12/08 14:17
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
@DubboService
public class SysDictApiImpl implements SysDictApi {

    @Resource
    private SysDictDataMapper sysDictDataMapper;

    /**
     * 根据编码获取字典数据列表
     * @param code 字典类型编码
     * @return 响应信息
     */
    public List<SysDictData> selectByCode(@PathVariable String code) {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select(SysDictDataTable.DefaultColumns,
                        SysDictTypeTable.Type)
                .from(SysDictTypeTable)
                .leftJoin(SysDictDataTable)
                .on(SysDictTypeTable.Code.eq(SysDictDataTable.Code))
                .where(SysDictTypeTable.Code.eq(code)).and(SysDictTypeTable.Status.eq(GlobalStatus.NORMAL));
        return sysDictDataMapper.selectListByQuery(queryWrapper);
    }

}
