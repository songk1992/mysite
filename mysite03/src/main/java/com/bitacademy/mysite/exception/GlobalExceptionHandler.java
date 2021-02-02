package com.bitacademy.mysite.exception;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.mysite.dto.JsonResult;
import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Log LOGGER = LogFactory.getLog(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public void handleException(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Exception e) throws Exception {

		// 1. Logging
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		LOGGER.error(errors.toString());

		// 2. 요청 구분
		// 만약 JSON 요청인 경우 Request Header의 Accept application/json
		// 만약, HTML 요청인 경우 Request Header의 Accept text/html
		// 만약, jpg 요청인 경우
		String accept = request.getHeader("accept");
		if (accept.matches(".*application/json.*")) {
			/* JSON 응답 */
			response.setStatus(HttpServletResponse.SC_OK);

			JsonResult jsonResult = JsonResult.fail(errors.toString());

			String jsonString = new ObjectMapper().writeValueAsString(jsonResult);
			
			OutputStream os = response.getOutputStream();
			os.write(jsonString.getBytes("UTF-8"));
			os.close();


		} else {

			// 3. 사과 (안내 페이지 포워딩, 정상종료)
			request.setAttribute("errors", errors.toString());
			request.getRequestDispatcher("/WEB-INF/views/error/exception.jsp").forward(request, response);
		}

	}
}
