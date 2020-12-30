package com.bitacademy.mysite.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitacademy.mysite.vo.BoardVo;
import com.bitacademy.web.mvc.Action;
import com.bitacademy.web.util.WebUtil;

public class ReplyformAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String no = request.getParameter("no");
		BoardVo vo = new BoardVo();
		vo.setNo(Long.valueOf(no));
		
		request.setAttribute("vo", vo);
		WebUtil.forward(request, response, "/WEB-INF/views/board/reply.jsp");
	}

}
