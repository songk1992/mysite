package com.bitacademy.config.app;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * 		<!-- MyBatis SqlSessionFactoryBean --> 
		<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean"> 
			<property name="dataSource" ref="dataSource" /> 
			<property name="configLocation" value="classpath:mybatis/configuration.xml" /> 
		</bean>
		
		<!-- MyBatis SqlSessionTemplate --> 
		<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
			<constructor-arg index="0" ref="sqlSessionFactory" />
		</bean>
 */

@Configuration
public class MyBatisConfig {
	
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ApplicationContext applicationContext) throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:com/bitacadey/mysite/app/mybatis/configuration.xml"));
		
		return sqlSessionFactoryBean.getObject();
	}
	
	
	@Bean
	public SqlSession sqlSession(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
