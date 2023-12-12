package solo.common.security.config;

import cn.dev33.satoken.SaManager;
import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.same.SaSameUtil;
import com.alibaba.fastjson2.JSON;
import com.solo.common.core.global.R;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 权限安全配置
 * @author 十一
 * @since 2023/11/29 09:00
 * 人生若只如初见，何事秋风悲画扇
 **/
@Component
@AutoConfiguration
public class SecurityConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 注册 Sa-Token 拦截器，打开注解式鉴权功能
		registry.addInterceptor(new SaInterceptor()).addPathPatterns("/**");
	}

	/**
	 * 校验是否从网关转发
	 */
	@Bean
	public SaServletFilter getSaServletFilter() {
		return new SaServletFilter()
				.addInclude("/**")
				.addExclude("/actuator/**")
				.setAuth(obj -> {
					if (SaManager.getConfig().getCheckSameToken()) {
						SaSameUtil.checkCurrentRequestToken();
					}
				})
				.setError(e -> {
					SaHolder.getResponse().setHeader("Content-Type", "application/json;charset=UTF-8");
                    return JSON.toJSONString(R.failed("禁止直接访问子服务，必须通过网关访问"));
                });
	}

}
