package com.bitacademy.config.web;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;


/*
 * 
 * 	<!-- MessageSource -->
	<bean id="messageSource" class="org.springframework.context.support.BundleMessageSource">
	   <property name="basenames">
	      <list>
			<value>messages/messages_ko</value>
	      </list>
	   </property>
	</bean>
 */


@Configuration
public class MessageSourceConfig {
	
	@Bean
	public MessageSource resourceBundleMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("com/bitacademy/mysite/config/web/properties/messages_ko");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
}
