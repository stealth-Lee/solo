package com.solo.system.service;

import com.solo.common.orm.base.service.BasicService;
import com.solo.system.api.entity.SysDictType;

/**
 * 字典类型Service接口
 * @author 十一
 * @since 2023/09/22 16:07
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface SysDictTypeService extends BasicService<SysDictType> {

    boolean create(SysDictType sysDept);

    boolean delete(Long typeId);

    boolean update(SysDictType entity);

}
