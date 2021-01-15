package com.bitacademy.mysite.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.bitacademy.config.app.DBConfig;
import com.bitacademy.config.app.MyBatisConfig;


/*
 * 		<!-- auto proxy -->
		<aop:aspectj-autoproxy />
	

		<!-- Connection Pool DataSource-->
		<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
			<property name="driverClassName" value="org.mariadb.jdbc.Driver" />
			<property name="url" value="jdbc:mysql://192.168.200.191:3306/webdb?characterEncoding=utf8" />
			<property name="username" value="webdb" />
			<property name="password" value="webdb" />
		</bean>
 * 
 * 
 * 	<context:component-scan base-package="com.bitacademy.mysite.service, com.bitacademy.mysite.repository, com.bitacademy.mysite.aspect">
		<context:include-filter type="annotation"
			expression="org.springframework.stereotype.Repository" />
		<context:include-filter type="annotation"
			expression="org.springframework.stereotype.Service" />
		<context:include-filter type="annotation"
			expression="org.springframework.stereotype.Component" />
	</context:component-scan>
 * 
 */


@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.bitacademy.mysite.service", "com.bitacademy.mysite.repository", "com.bitacademy.mysite.aspect"})
@Import({DBConfig.class, MyBatisConfig.class})
public class AppConfig {

}
