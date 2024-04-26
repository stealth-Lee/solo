package com.solo.quartz.model.job;

import com.solo.quartz.api.entity.QrtzJob;
import com.solo.quartz.model.job.req.JobCreateReq;
import com.solo.quartz.model.job.req.JobUpdateReq;
import com.solo.quartz.model.job.resp.JobGetResp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 定时任务实体转换类
 * @author 十一
 * @since 2024-04-25 14:56
 * 人生若只如初见，何事秋风悲画扇
 **/
@Mapper
public interface QrtzJobConvert {

    QrtzJobConvert INSTANCE = Mappers.getMapper(QrtzJobConvert.class);

    QrtzJob convert(JobCreateReq bean);

    QrtzJob convert(JobUpdateReq bean);

    JobGetResp convertGet(QrtzJob bean);

}
