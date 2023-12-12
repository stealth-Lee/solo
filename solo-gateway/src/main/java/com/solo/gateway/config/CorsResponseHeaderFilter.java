//package com.solo.gateway.config;
//
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.cloud.gateway.filter.NettyWriteResponseFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpHeaders;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.ArrayList;
//
///**
// * 解决gateway重复添加跨域请求头的问题
// * @author 十一
// * @since 2023/09/01 15:08
// * 人生若只如初见，何事秋风悲画扇
// **/
//public class CorsResponseHeaderFilter implements GlobalFilter, Ordered {
//
//    @Override
//    public int getOrder() {
//        // 指定此过滤器位于NettyWriteResponseFilter之后
//        // 即待处理完响应体后接着处理响应头
//        return NettyWriteResponseFilter.WRITE_RESPONSE_FILTER_ORDER + 5;
//    }
//
//    @Override
//    @SuppressWarnings("serial")
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        return chain.filter(exchange).then(Mono.defer(() -> {
//            exchange.getResponse().getHeaders().entrySet().stream()
//                    .filter(kv -> (kv.getValue() != null && kv.getValue().size() > 1))
//                    .filter(kv -> (kv.getKey().equals(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN)
//                            || kv.getKey().equals(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS)))
//                    .forEach(kv ->
//                    {
//                        kv.setValue(new ArrayList<String>() {{
//                            add(kv.getValue().get(0));
//                        }});
//                    });
//
//            return chain.filter(exchange);
//        }));
//    }
//
//}
