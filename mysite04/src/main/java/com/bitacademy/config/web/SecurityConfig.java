package com.bitacademy.config.web;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.bitacademy.security.AuthInterceptor;
import com.bitacademy.security.AuthUserHandlerMethodArgumentResolver;
import com.bitacademy.security.LoginInterceptor;
import com.bitacademy.security.LogoutInterceptor;


/*
 * 
 * 	<!-- Interceptors -->
	<mvc:interceptors>
		<!--
		<mvc:interceptor>
			<mvc:mapping path="/board/**" />
			<bean class="com.bitacademy.mysite.interceptor.MyInterceptor02"/>
		</mvc:interceptor>
		-->
		<mvc:interceptor>
			<mvc:mapping path="/user/auth" />
			<bean class="com.bitacademy.security.LoginInterceptor"/>
		</mvc:interceptor>
		<mvc:interceptor>
			<mvc:mapping path="/user/logout" />
			<bean class="com.bitacademy.security.LogoutInterceptor"/>
		</mvc:interceptor>
		<mvc:interceptor>
			<mvc:mapping path="/**" />
			<mvc:exclude-mapping path="/user/auth"/>
			<mvc:exclude-mapping path="/user/logout"/>
			<mvc:exclude-mapping path="/assets/**"/>
			<bean class="com.bitacademy.security.AuthInterceptor"/>
		</mvc:interceptor>
	</mvc:interceptors>
 * 
 * 
 */



@Configuration
@EnableWebMvc
public class SecurityConfig extends WebMvcConfigurerAdapter {
	
	// 1. Argument Resolvers
	@Bean
	public HandlerMethodArgumentResolver authUserHandlerMethodArgumentResolver()
	{
		return new AuthUserHandlerMethodArgumentResolver();
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(authUserHandlerMethodArgumentResolver());
	}
	
	// 2. Interceptors
	@Bean
	public HandlerInterceptor authInterceptor() {
		return new AuthInterceptor();
	}
	
	@Bean
	public HandlerInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}
	
	@Bean
	public HandlerInterceptor logoutInterceptor() {
		return new LogoutInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry
		.addInterceptor(loginInterceptor())
		.addPathPatterns("/user/login");
	
		registry
		.addInterceptor(logoutInterceptor())
		.addPathPatterns("/user/logout");
		
		registry
		.addInterceptor(authInterceptor())
		.addPathPatterns("/**")
		.excludePathPatterns("/user/auth")
		.excludePathPatterns("/user/logout")
		.excludePathPatterns("/assets/**");
	}
	
}

