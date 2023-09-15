package com.solo.system.service;

import com.solo.common.orm.base.service.BasicService;
import com.solo.system.api.entity.SysDept;

/**
 * 部门Service
 * @author 十一
 * @since 2023/08/31 10:32
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface SysDeptService extends BasicService<SysDept> {

    /**
     * 新增部们
     * @param entity 部门实体
     * @return 是否成功
     */
    public boolean create(SysDept entity);

    /**
     * 删除部门
     * @param deptId 部门id
     * @return 是否成功
     */
    public boolean delete(Long deptId);

    /**
     * 更新部门
     * @param entity 部门实体
     * @return 是否成功
     */
    public boolean update(SysDept entity);

}
