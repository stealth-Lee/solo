package com.solo.system.model.dept;

import com.solo.system.api.entity.SysDept;
import com.solo.system.model.dept.req.DeptInsertReq;
import com.solo.system.model.dept.req.DeptQueryReq;
import com.solo.system.model.dept.req.DeptUpdateReq;
import com.solo.system.model.dept.resp.DeptGetResp;
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

    SysDept convert(DeptInsertReq bean);

    SysDept convert(DeptUpdateReq bean);

    SysDept convert(DeptQueryReq bean);

    DeptGetResp convertGet(SysDept bean);

}
