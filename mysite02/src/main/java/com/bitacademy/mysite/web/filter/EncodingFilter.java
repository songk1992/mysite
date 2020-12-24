package com.bitacademy.mysite.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class EncodingFilter
 */
public class EncodingFilter implements Filter {
	private String encoding;

	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter("encoding");
		if(null==encoding) {
			encoding = "utf-8";
		}
		// TODO Auto-generated method stub
	}
	

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// request 처리
		request.setCharacterEncoding(encoding);
		
		
		chain.doFilter(request, response);
		
		// response 처리
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}


}
