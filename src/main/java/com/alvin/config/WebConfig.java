package com.alvin.config;

import com.alvin.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * packageName com.alvin.config
 *
 * @author 你的名字
 * @version JDK 8
 * @className WebConfug (此处以class为例)
 * @date 2024/6/29 星期六
 * @description TODO
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	private LoginInterceptor loginInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/login","/user/register");
	}
}
