package com.solo.system.service.impl;

import com.mybatisflex.core.query.QueryChain;
import com.solo.common.core.utils.NumberUtils;
import com.solo.common.core.utils.ObjectUtils;
import com.solo.common.orm.base.service.impl.BasicServiceImpl;
import com.solo.system.api.entity.SysDictType;
import com.solo.system.mapper.SysDictTypeMapper;
import com.solo.system.service.SysDictTypeService;
import org.springframework.stereotype.Service;

import static com.solo.common.core.utils.ServiceExceptionUtil.exception;
import static com.solo.system.api.entity.table.SysDictTypeTableDef.SysDictTypeTable;

/**
 * 字典类型Service实现类
 * @author 十一
 * @since 2023/09/22 16:25
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
public class SysDictTypeServiceImpl extends BasicServiceImpl<SysDictTypeMapper, SysDictType> implements SysDictTypeService {

    @Override
    public boolean create(SysDictType entity) {
        long count = QueryChain.of(mapper).where(SysDictTypeTable.DictCode.eq(entity.getDictCode())).count();
        if (NumberUtils.isPositiveInteger(count)) {
            throw exception("字典编码已存在");
        }
        return super.save(entity);
    }

    @Override
    public boolean delete(Long typeId) {
//        long count = QueryChain.of(mapper).where(SysDeptTable.ParentId.eq(deptId)).count();
//        if (NumberUtils.isPositiveInteger(count)) {
//            throw exception("该部门下存在子部门，无法删除");
//        }
        return super.removeById(typeId);
    }

    @Override
    public boolean update(SysDictType entity) {
        SysDictType result = QueryChain.of(mapper).select(SysDictTypeTable.TypeId)
                .where(SysDictTypeTable.DictCode.eq(entity.getDictCode())).one();
        if (ObjectUtils.isNotEmpty(result) && !result.getTypeId().equals(entity.getTypeId())) {
            throw exception("字典编码已存在");
        }
        return super.updateById(entity);
    }

}
