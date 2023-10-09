package com.solo.codegen.service.impl;

import com.solo.codegen.api.entity.GenTable;
import com.solo.codegen.mapper.GenTableMapper;
import com.solo.codegen.service.GenTableService;
import com.solo.common.orm.base.service.impl.BasicServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 代码生成Service实现类
 * @author 十一
 * @since 2023/10/08 15:51
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
public class GenTableServiceImpl extends BasicServiceImpl<GenTableMapper, GenTable> implements GenTableService {

}
