package com.bitacademy.mysite.mvc.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitacademy.mysite.repository.UserRepository;
import com.bitacademy.mysite.vo.UserVo;
import com.bitacademy.web.mvc.Action;
import com.bitacademy.web.util.WebUtil;

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");

		UserVo vo = new UserVo();
		
		vo.setNo(Long.valueOf(no));
		vo.setName(name);
		vo.setEmail(email);
		vo.setPassword(password);
		vo.setGender(gender);
		
		UserVo userVo = new UserRepository().updateByEmailAndPassword(vo);
		
		
		if(userVo == null) {
			System.out.println("userVo 오류 발생");
			request.setAttribute("no", no);
			WebUtil.forward(request, response, "/WEB-INF/views/user/loginform.jsp");
			return;
		}
		
		/* 로그인 처리 */
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", userVo);
		
		WebUtil.redirect(request, response, request.getContextPath());
	}

}
