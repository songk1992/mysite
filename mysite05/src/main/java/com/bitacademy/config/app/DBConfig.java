package com.bitacademy.config.app;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*	
 * XML 설정 비교
 * 	<!-- Connection Pool DataSource-->
 * 	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
 *	<property name="driverClassName" value="org.mariadb.jdbc.Driver" />
 *	<property name="url" value="jdbc:mysql://192.168.1.9:3306/webdb?characterEncoding=utf8" />
 *	<property name="username" value="webdb" />
 * 	<property name="password" value="webdb" />
 * 	</bean>
 * 아래와 같이 자바로 변경
*/

/*
 * @PropertySource("") 설명
 * @PropertySource("") 에 있는 것을 찾아서 Envrionment라는 객체에 넣어준다
 * 
 */

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:com/bitacademy/mysite/config/app/properties/jdbc.properties")
public class DBConfig {
	
	@Autowired
	private Environment env;

	@Bean
	public DataSource datasource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		dataSource.setInitialSize(env.getProperty("jdbc.initialSize", Integer.class));
		dataSource.setMaxActive(env.getProperty("jdbc.maxActive",Integer.class));
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	

}
