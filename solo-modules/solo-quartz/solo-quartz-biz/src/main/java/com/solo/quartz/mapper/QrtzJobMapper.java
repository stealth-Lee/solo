package com.solo.quartz.mapper;

import com.solo.quartz.api.entity.QrtzJob;
import com.solo.common.core.base.mapper.BasicMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务 Mapper
 * @author 十一
 * @since 2024-04-25 14:56
 * 人生若只如初见，何事秋风悲画扇
 **/
@Mapper
public interface QrtzJobMapper extends BasicMapper<QrtzJob> {

}
