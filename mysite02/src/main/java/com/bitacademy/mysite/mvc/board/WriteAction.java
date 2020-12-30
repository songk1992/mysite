package com.bitacademy.mysite.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitacademy.mysite.repository.BoardRepository;
import com.bitacademy.mysite.vo.BoardVo;
import com.bitacademy.web.mvc.Action;
import com.bitacademy.web.util.WebUtil;

public class WriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userNo = request.getParameter("userNo");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");

		BoardVo vo = new BoardVo();
		vo.setUserNo(Long.valueOf(userNo));
		vo.setTitle(title);
		vo.setContents(contents);
		
		new BoardRepository().createNewArticle(vo);
		
		WebUtil.redirect(request, response, request.getContextPath() + "/board?a=list");
	}

}
