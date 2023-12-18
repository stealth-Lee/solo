/*
 * Copyright (c) 2020 pig4cloud Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.solo.common.core.config;

import cn.hutool.core.date.DatePattern;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication.Type.SERVLET;

/**
 * WebMvc全局配置类
 * @author Gentleman.Lee
 * @since 2023/12/18 10:27
 * 人生若只如初见，何事秋风悲画扇
 **/
@AutoConfiguration
@ConditionalOnWebApplication(type = SERVLET)
public class WebMvcConfig implements WebMvcConfigurer {

	/**
	 * 添加GET请求中日期时间格式化程序
	 * HH:mm:ss -> LocalTime
	 * yyyy-MM-dd -> LocalDate
	 * yyyy-MM-dd HH:mm:ss -> LocalDateTime
	 * @param registry 注册表
	 */
	@Override
	public void addFormatters(@NotNull FormatterRegistry registry) {
		DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
		registrar.setTimeFormatter(DatePattern.NORM_TIME_FORMATTER);
		registrar.setDateFormatter(DatePattern.NORM_DATE_FORMATTER);
		registrar.setDateTimeFormatter(DatePattern.NORM_DATETIME_FORMATTER);
		registrar.registerFormatters(registry);
	}

}
