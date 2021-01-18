package com.bitacademy.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/*
 * 
 * 	<!-- validator, conversionService, messageConverter를 자동으로 등록 -->
	<mvc:annotation-driven>
		<mvc:argument-resolvers>
			<bean class="com.bitacademy.security.AuthUserHandlerMethodArgumentResolver" />
		</mvc:argument-resolvers>
	</mvc:annotation-driven>
 * 
 * 	<!-- ViewResolver 설정 -->
	<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalViewResolver">
	   <property name="viewClass" value="org.springframework.web.servlet.view.JstlView" />
	   <property name="prefix" value="/WEB-INF/views/" />
	   <property name="suffix" value=".jsp" />
	   <property name="order" value="1" />
	</bean>
 */


@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {
	
	// View Resolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	// Default Servlet Handler
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	// Message Converters
}
