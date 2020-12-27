package com.bitacademy.mysite.mvc.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitacademy.mysite.repository.GuestbookRepository;
import com.bitacademy.mysite.repository.UserRepository;
import com.bitacademy.mysite.vo.GuestbookVo;
import com.bitacademy.mysite.vo.UserVo;
import com.bitacademy.web.mvc.Action;
import com.bitacademy.web.util.WebUtil;

public class UpdateformAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 세션에서 authUser 가져오기
		// 2. authUser에서 no 가져오기
		// 3. no를 가지고 Repository 통해 UserVo 가져오기
		// 4. jsp로 UserVo 전달하면서 FORWARDING 하기
		
		String no = request.getParameter("no");
		String name = request.getParameter("name");

		UserVo userVo = new UserVo();
		userVo.setName(name);
		userVo.setNo(Long.valueOf(no));

		userVo =new UserRepository().findEmailAndGender(userVo);
		
		if(userVo == null) {
			
		}

		request.setAttribute("userVo", userVo);
		request.getRequestDispatcher("/WEB-INF/views/user/updateform.jsp").forward(request, response);
	}
	
	
	


}