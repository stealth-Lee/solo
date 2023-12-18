package com.solo.common.core.utils;

import cn.hutool.core.io.IoUtil;
import cn.hutool.extra.servlet.JakartaServletUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Objects;

/**
 * Servlet 工具类
 * @author Gentleman.Lee
 * @since 2023/12/14 17:10
 * 人生若只如初见，何事秋风悲画扇
 **/
public class ServletUtils extends JakartaServletUtil {

    public static final String USER_AGENT = "User-Agent";


    /**
     * 返回附件
     * @param response 响应
     * @param filename 文件名
     * @param content 附件内容
     */
    public static void writeAttachment(HttpServletResponse response, String filename, byte[] content) throws IOException {
        // 设置 header 和 contentType
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        // 输出附件
        IoUtil.write(response.getOutputStream(), false, content);
    }

    /**
     * 获取请求属性
     * @return {@link ServletRequestAttributes}
     */
    public static ServletRequestAttributes getRequestAttributes() {
        try {
            RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
            return (ServletRequestAttributes) attributes;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取request
     */
    public static HttpServletRequest getRequest() {
        return Objects.requireNonNull(getRequestAttributes()).getRequest();
    }

    /**
     * 获取response
     */
    public static HttpServletResponse getResponse() {
        return Objects.requireNonNull(getRequestAttributes()).getResponse();
    }


    /**
     * 获取用户代理
     * @param request 请求
     * @return {@link String}
     */
    public static String getUserAgent(HttpServletRequest request) {
        return ServletUtils.getHeaderIgnoreCase(request, USER_AGENT);
    }

}
