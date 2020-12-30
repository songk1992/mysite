package com.bitacademy.mysite.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitacademy.mysite.repository.BoardRepository;
import com.bitacademy.mysite.vo.BoardVo;
import com.bitacademy.web.mvc.Action;
import com.bitacademy.web.util.WebUtil;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String no = request.getParameter("no");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");

		System.out.println(no);
		System.out.println(title);
		System.out.println(contents);
		
		BoardVo vo = new BoardVo();
		vo.setNo(Long.valueOf(no));
		vo.setTitle(title);
		vo.setContents(contents);
		
		new BoardRepository().modifyArticle(vo);
		WebUtil.redirect(request, response, request.getContextPath() + "/board?a=list");
	}

}
