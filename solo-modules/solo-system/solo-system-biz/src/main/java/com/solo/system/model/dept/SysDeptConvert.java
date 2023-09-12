package com.solo.system.model.dept;

import com.solo.system.api.entity.SysDept;
import com.solo.system.model.dept.req.SysDeptInsertReq;
import com.solo.system.model.dept.req.SysDeptQueryReq;
import com.solo.system.model.dept.req.SysDeptUpdateReq;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 部门实体转换类
 * @author 十一
 * @since 2023/09/08 10:10
 * 人生若只如初见，何事秋风悲画扇
 **/
@Mapper
public interface SysDeptConvert {

    SysDeptConvert INSTANCE = Mappers.getMapper(SysDeptConvert.class);

    SysDept convert(SysDeptInsertReq bean);

    SysDept convert(SysDeptUpdateReq bean);

    SysDept convert(SysDeptQueryReq bean);

}
