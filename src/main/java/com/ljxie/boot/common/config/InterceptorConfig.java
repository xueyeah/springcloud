package com.ljxie.boot.common.config;

import com.ljxie.boot.web.filter.AuthorizationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author fantong
 * Springmvc 拦截器注册
 *
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//注册拦截器
		registry.addInterceptor(new AuthorizationInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
	
}
