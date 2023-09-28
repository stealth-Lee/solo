package com.solo.system.service.impl;

import com.mybatisflex.core.query.QueryChain;
import com.solo.common.core.utils.NumberUtils;
import com.solo.common.orm.base.service.impl.BasicServiceImpl;
import com.solo.system.api.entity.SysDictData;
import com.solo.system.mapper.SysDictDataMapper;
import com.solo.system.service.SysDictDataService;
import org.springframework.stereotype.Service;

import static com.solo.common.core.utils.ServiceExceptionUtil.exception;
import static com.solo.system.api.entity.table.SysDictDataTableDef.SysDictDataTable;

/**
 * 字典数据Service实现类
 * @author 十一
 * @since 2023/09/26 11:28
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
public class SysDictDataServiceImpl extends BasicServiceImpl<SysDictDataMapper, SysDictData> implements SysDictDataService {

}
