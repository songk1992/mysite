MYSITE03 에서 XML을 사용해 진행한 부분을 자바 로 변경


``` text

[src]
  |--- [main]
         |---- [java]
	 |        |--- /com
	 |               |--- /bitacademy
	 |                         |--- /web
	 |                         |      |--- /util	
	 |                         |--- /security
	 |                         |--- /config
	 |                         |        |--- /app
	 |                         |        |      |--- DBConfig.java
	 |                         |        |      |--- MyBatisConfig.java
	 |                         |        |--- /web
	 |                         |               |--- MvcConfig.java
	 |                         |               |--- SecurityConfig.java
	 |                         |               |--- MessageSourceConfig.java
	 |                         |               |--- FileUploadConfig.java
	 |                         |--- /mysite
	 |                                 |--- /controller
	 |                                 |--- /service
	 |                                 |--- /repository
	 |                                 |--- /vo
	 |                                 |--- /exception
	 |                                 |--- /aop
	 |                                 |--- /config
	 |                                          |--- AppConfig.java
	 |                                          |--- WebConfig.java
	 |---- [resources]
		  |--- logback.xml
	 	  |--- /com
	 	  		|--- /bitacademy
	 	  				|--- /mysite
	 	  						|--- /config
			 	  						|--- /app
							  			|      |--- /properties
							  			|	   |		|--- jdbc.properties
							  			|      |--- /mybatis
										|              |--- configuration.xml
										|              |--- /mappers
										|                       |--- user.xml
										|                       |--- board.xml
										|--- /web
											   |--- /properties
														|--- fileupload.properties			
														|--- message_ko.properties
		                           

com.bitacademy.config.app
com.bitacademy.config.web
com.bitacademy.mysite.config

com.bitacademy.mysite.config.app.propeties
com.bitacademy.mysite.config.app.mybatis
com.bitacademy.mysite.config.app.mybatis.mappers
com.bitacademy.mysite.config.web.properties

```
