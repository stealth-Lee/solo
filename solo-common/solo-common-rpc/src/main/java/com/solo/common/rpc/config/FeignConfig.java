package com.solo.common.rpc.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
public class FeignConfig implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        // 获取之前的header 并放入新的header中
//        if (attributes != null) {
//            String authorization = attributes.getRequest().getHeader(Constant.X_AUTHORIZATION);
//            if (null != authorization) {
//                requestTemplate.header(Constant.X_AUTHORIZATION, authorization);
//            }
//            String dbName = attributes.getRequest().getHeader(Constant.dbName);
//            if (null != dbName) {
//                requestTemplate.header(Constant.dbName, dbName);
//            }
//            String userDb = attributes.getRequest().getHeader(Constant.userDb);
//            if (null != userDb) {
//                requestTemplate.header(Constant.userDb, userDb);
//            }
//        }
    }
}
