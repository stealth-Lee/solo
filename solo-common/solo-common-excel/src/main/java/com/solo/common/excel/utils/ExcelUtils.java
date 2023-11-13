package com.solo.common.excel.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Excel 工具类
 *
 * @author 芋道源码
 */
public class ExcelUtils {

    public static final String CONTENT_TYPE = "application/vnd.ms-excel";

    public static <T> void write(HttpServletResponse response, String filename, Class<T> head, List<T> data) throws IOException {
        setExportHeader(response, filename);
        EasyExcel.write(response.getOutputStream(), head)
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()) // 基于 column 长度，自动适配。最大 255 宽度
                .sheet().doWrite(data);
    }

    public static <T> List<T> read(MultipartFile file, Class<T> head) throws IOException {
        return EasyExcel.read(file.getInputStream(), head, null)
                .autoCloseStream(false)  // 不要自动关闭，交给 Servlet 自己处理
                .doReadAllSync();
    }

    private static void setExportHeader(HttpServletResponse response, String filename) {
        response.setContentType(CONTENT_TYPE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + filename + ".xlsx");
    }

}
