package com.bitacademy.mysite.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitacademy.mysite.repository.BoardRepository;
import com.bitacademy.mysite.vo.BoardVo;
import com.bitacademy.web.mvc.Action;
import com.bitacademy.web.util.WebUtil;

public class GoodAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String no = request.getParameter("no");
		BoardVo vo = new BoardVo();
		vo.setNo(Long.valueOf(no));
		
		BoardRepository boardRepository = new BoardRepository();
		boardRepository.addGoodCount(vo);

		WebUtil.redirect(request, response, request.getContextPath() + "/board?a=list");
	}

}
