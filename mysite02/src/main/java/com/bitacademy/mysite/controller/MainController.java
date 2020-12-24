package com.bitacademy.mysite.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitacademy.mysite.mvc.main.MainActionFactory;
import com.bitacademy.web.mvc.Action;
import com.bitacademy.web.mvc.ActionFactory;

public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void init() throws ServletException {
		String configPath = this.getServletConfig().getInitParameter("config");
		System.out.println("init() called" + configPath);
		super.init();
	}
	

	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("init() called");
		super.service(arg0, arg1);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String actionName = request.getParameter("a");		

		ActionFactory actionFactory = new MainActionFactory();
		Action action = actionFactory.getAction(actionName);
		action.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}