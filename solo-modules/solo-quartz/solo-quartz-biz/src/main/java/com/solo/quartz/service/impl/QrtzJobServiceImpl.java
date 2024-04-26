package com.solo.quartz.service.impl;

import com.solo.quartz.api.entity.QrtzJob;
import com.solo.quartz.mapper.QrtzJobMapper;
import com.solo.quartz.service.QrtzJobService;
import com.solo.common.core.base.service.impl.BasicServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 定时任务 Service实现类
 * @author 十一
 * @since 2024-04-25 14:56
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
public class QrtzJobServiceImpl extends BasicServiceImpl<QrtzJobMapper, QrtzJob> implements QrtzJobService {

}
