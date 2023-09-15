package com.solo.system.service.impl;

import com.mybatisflex.core.query.QueryChain;
import com.solo.common.core.utils.NumberUtils;
import com.solo.common.core.utils.ObjectUtils;
import com.solo.common.orm.base.service.impl.BasicServiceImpl;
import com.solo.system.api.entity.SysDept;
import com.solo.system.mapper.SysDeptMapper;
import com.solo.system.service.SysDeptService;
import org.springframework.stereotype.Service;

import static com.solo.common.core.utils.ServiceExceptionUtil.exception;
import static com.solo.system.api.entity.table.SysDeptTableDef.SysDeptTable;

/**
 * 部门Service实现类
 * @author 十一
 * @since 2023/08/31 10:36
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
public class SysDeptServiceImpl extends BasicServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

    @Override
    public boolean create(SysDept entity) {
        long count = QueryChain.of(mapper).where(SysDeptTable.DeptCode.eq(entity.getDeptCode())).count();
        if (NumberUtils.isPositiveInteger(count)) {
            throw exception("部门编码已存在");
        }
        return super.save(entity);
    }

    @Override
    public boolean delete(Long deptId) {
        long count = QueryChain.of(mapper).where(SysDeptTable.ParentId.eq(deptId)).count();
        if (NumberUtils.isPositiveInteger(count)) {
            throw exception("该部门下存在子部门，无法删除");
        }
        return super.removeById(deptId);
    }

    @Override
    public boolean update(SysDept entity) {
        SysDept result = QueryChain.of(mapper).select(SysDeptTable.DeptId)
                .where(SysDeptTable.DeptCode.eq(entity.getDeptCode())).one();
        if (ObjectUtils.isNotEmpty(result) && !result.getDeptId().equals(entity.getDeptId())) {
            throw exception("部门编码已存在");
        }
        return super.updateById(entity);
    }

}
