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

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserVo vo = new UserVo();
		vo.setEmail(email);
		vo.setPassword(password);
		
		UserVo userVo = new UserRepository().findByEmailAndPassword(vo);
		if(userVo == null) {
			request.setAttribute("email", email);
			WebUtil.forward(request, response, "/WEB-INF/views/user/loginform.jsp");
			return;
		}
		
		/* 로그인 처리 */
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.removeAttribute("authUser");
			session.invalidate();
		}
		session = request.getSession(true);
		session.setAttribute("authUser", userVo);
		
		request.setAttribute("userVo", userVo);
		request.getRequestDispatcher("/WEB-INF/views/main/index.jsp").forward(request, response);
	}

}