package com.solo.system.service;

import com.solo.common.orm.base.service.BasicService;
import com.solo.system.api.entity.SysConfig;
import com.solo.system.model.config.req.ConfigQueryReq;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 系统配置 Service
 * @author 十一
 * @since 2023-10-18 16:33
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface SysConfigService extends BasicService<SysConfig> {

    void importExcel(MultipartFile file) throws IOException;

    void exportExcel(HttpServletResponse response, ConfigQueryReq req) throws IOException;
}
