package com.solo.gateway.filter;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.reactor.context.SaReactorSyncHolder;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson2.JSON;
import com.solo.common.core.consts.GlobalCode;
import com.solo.common.core.global.R;
import com.solo.gateway.properties.IgnoreWhiteProperties;
import com.solo.satoken.utils.LoginHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;

/**
 * [Sa-Token 权限认证] 过滤器
 * @author 十一
 * @since 2023/11/24 11:00
 * 人生若只如初见，何事秋风悲画扇
 **/
@Slf4j
@Configuration
public class AuthFilter {

    /**
     * 注册 Sa-Token全局过滤器
     *
     * @return {@link SaReactorFilter}
     */
    @Bean
    public SaReactorFilter getSaReactorFilter(IgnoreWhiteProperties ignoreWhite) {
        return new SaReactorFilter()
                // 拦截地址
                .addInclude("/**")
                .addExclude("/favicon.ico", "/actuator/**")
                // 鉴权方法：每次访问进入
                .setAuth(obj -> {
                    // 登录校验 -- 拦截所有路由
                    SaRouter.match("/**")
                            .notMatch(ignoreWhite.getWhites())
                            .check(r -> {
                                // 检查是否登录 是否有token
                                StpUtil.checkLogin();

                                // 检查 header 与 param 里的 clientid 与 token 里的是否一致
                                ServerHttpRequest request = SaReactorSyncHolder.getContext().getRequest();
                                String headerCid = request.getHeaders().getFirst(LoginHelper.CLIENT_KEY);
                                String paramCid = request.getQueryParams().getFirst(LoginHelper.CLIENT_KEY);
//                                String clientId = StpUtil.getExtra(LoginHelper.CLIENT_KEY).toString();
//                                if (!StringUtils.equalsAny(clientId, headerCid, paramCid)) {
//                                    // token 无效
//                                    throw NotLoginException.newInstance(StpUtil.getLoginType(),
//                                            "-100", "客户端ID与Token不匹配",
//                                            StpUtil.getTokenValue());
//                                }

                                // 有效率影响 用于临时测试
                                // if (log.isDebugEnabled()) {
                                //     log.debug("剩余有效时间: {}", StpUtil.getTokenTimeout());
                                //     log.debug("临时有效时间: {}", StpUtil.getTokenActivityTimeout());
                                // }
                            });
                }).setError(e -> {
                    log.error("[NotLoginException] -> [认证失败: {}]", e.getMessage());
                    SaHolder.getResponse().setHeader("Content-Type", "application/json;charset=UTF-8");
                    return JSON.toJSONString(R.global(GlobalCode.UNAUTHORIZED, "认证失败，无法访问系统资源"));
                });
    }
}
