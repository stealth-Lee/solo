package com.solo.common.excel.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImportService {

    // 简单导入
    void importExcel(MultipartFile file) throws IOException;

}
