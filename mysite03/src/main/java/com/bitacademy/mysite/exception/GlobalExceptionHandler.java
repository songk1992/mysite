package com.bitacademy.mysite.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) throws Exception {
		// 1. Logging
		System.out.println(e.getStackTrace());
		
		// 2. 사과 (안내 페이지 포워딩, 정상종료)
		return "error/exception";
		
		// 3. 
	}
}
