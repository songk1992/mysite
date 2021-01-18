package com.bitacademy.mysite.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Log LOGGER  = LogFactory.getLog(GlobalExceptionHandler.class);
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) throws Exception {

			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			LOGGER.error(errors.toString());
		
		
		
		// 1. Logging
		// e.printStackTrace();
		// log.error("...");
		//new HttpConnection("http://192.168.200.191/log?str=dwdwda");
		
		
		// 2. 사과 (안내 페이지 포워딩, 정상종료)
		ModelAndView mav = new ModelAndView();
		mav.addObject("errors", errors);
		mav.setViewName("error/exception");
		return mav;
		
		// 3. 
	}
}
