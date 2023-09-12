package com.solo.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * 跨域配置
 * @author 十一
 * @since 2023/09/01 15:08
 * 人生若只如初见，何事秋风悲画扇
 **/
@Configuration
public class CorsConfig {

    /**
     * * 表示对所有的地址都可以访问
     */
    private static final String All = "*";

    /**
     * 该字段的单位是秒。也就是说在这个时间段内，不需要再发送预检验请求，可以缓存该结果
     */
    private static final String MAX_AGE = "18000L";

    // 跨域配置
    @Bean
    public CorsResponseHeaderFilter corsResponseHeaderFilter() {
        //解决geteway重复添加跨域请求头的问题：https://blog.csdn.net/xht555/article/details/89484091
        return new CorsResponseHeaderFilter();
    }

    @Bean
    public WebFilter corsFilter() {
        return (ServerWebExchange exchange, WebFilterChain chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            if (CorsUtils.isCorsRequest(request)) {
                ServerHttpResponse response = exchange.getResponse();
                HttpHeaders headers = response.getHeaders();
                // 你需要跨域的地址
                headers.set("Access-Control-Allow-Origin", All);
                // 指定能够访问资源的HTTP方法
                headers.set("Access-Control-Allow-Methods", All);
                // 指定允许客户端在跨域请求中携带的自定义请求
                headers.set("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN,token,username,client");
                // 在发送CORS预检请求后的多长时间内，该预检请求的结果可以被缓存并用于后续的请求。
                headers.set("Access-Control-Max-Age", MAX_AGE);
                // 用于指示浏览器是否可以将凭据（例如，Cookie、HTTP身份验证或TLS客户端证书）发送到请求的目标服务器
                headers.set("Access-Control-Allow-Credentials", "fasle");
                if (request.getMethod() == HttpMethod.OPTIONS) {
                    response.setStatusCode(HttpStatus.OK);
                    return Mono.empty();
                }
            }
            return chain.filter(exchange);
        };
    }

}
