package com.bitacademy.mysite.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitacademy.mysite.repository.BoardRepository;
import com.bitacademy.mysite.vo.BoardVo;
import com.bitacademy.mysite.vo.UserVo;
import com.bitacademy.web.mvc.Action;
import com.bitacademy.web.util.WebUtil;

public class DeleteAction implements Action {

		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub

			
			String no = request.getParameter("no");
			String password = request.getParameter("password");
			
			UserVo userVo = new UserVo();
			BoardVo boardVo = new BoardVo();
			
			userVo.setPassword(password);
			boardVo.setNo(Long.valueOf(no));
			
			
			new BoardRepository().deleteArticle(userVo, boardVo);
			
			WebUtil.redirect(request, response, request.getContextPath() + "/board?a=list");
		}

	}