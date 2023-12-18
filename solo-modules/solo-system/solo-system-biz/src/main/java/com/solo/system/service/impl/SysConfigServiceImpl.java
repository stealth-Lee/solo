package com.solo.system.service.impl;

import com.solo.common.excel.listener.ExcelReadListener;
import com.solo.common.excel.utils.ExcelUtils;
import com.solo.common.core.base.service.impl.BasicServiceImpl;
import com.solo.system.api.entity.SysConfig;
import com.solo.system.mapper.SysConfigMapper;
import com.solo.system.model.config.req.ConfigQueryReq;
import com.solo.system.service.SysConfigService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 系统配置表 Service实现类
 * @author 十一
 * @since 2023-10-18 16:33
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
public class SysConfigServiceImpl extends BasicServiceImpl<SysConfigMapper, SysConfig> implements SysConfigService {

    private ExcelReadListener<SysConfig> salariesListener = new ExcelReadListener<>();

    @Override
    public void importExcel(MultipartFile file) throws IOException {
        ExcelUtils.read(file, SysConfig.class);
    }

    @Override
    public void exportExcel(HttpServletResponse response, ConfigQueryReq req) throws IOException {
        List<SysConfig> salaries = mapper.selectAll();
        ExcelUtils.write(response, "SysConfig", SysConfig.class, salaries);
    }

}
