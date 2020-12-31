package com.bitacademy.mysite.mvc.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitacademy.mysite.repository.BoardRepository;
import com.bitacademy.mysite.vo.BoardVo;
import com.bitacademy.mysite.vo.PageNumberVo;
import com.bitacademy.web.mvc.Action;
import com.bitacademy.web.util.WebUtil;

public class SearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String kwd = request.getParameter("kwd");
		
		List<BoardVo> list = new BoardRepository().findWithKeyword(kwd);
		request.setAttribute("list", list);
		for (BoardVo item : list) {
			System.out.println(item.getTitle());
		}
		WebUtil.forward(request, response, "/WEB-INF/views/board/list.jsp");
	}

}
