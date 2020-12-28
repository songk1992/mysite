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

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO : 중복 되는 코드 클래스로 뺴기
		
		// null 값이 들어오면 페이지 값을 1로 설정합니다.
		Integer pageNumber;
		String tempvalueofpagenumber = request.getParameter("pagenumber");
		if (tempvalueofpagenumber != null && tempvalueofpagenumber.length() != 0) {
		    // 값이 있는 경우 처리
			pageNumber = Integer.valueOf(tempvalueofpagenumber);
		} else {
		    // 값이 없는 경우 처리
			pageNumber = 1;
		}
		
		// null 값이 들어오면 글 개수  값을  5로 설정합니다.
		Integer pageamountOfarticles;
		String tempvalueofpageamountofarticles = request.getParameter("pageamountOfarticles");
		if (tempvalueofpageamountofarticles != null && tempvalueofpageamountofarticles.length() != 0) {
		    // 값이 있는 경우 처리
			pageamountOfarticles = Integer.valueOf(tempvalueofpageamountofarticles);
		} else {
		    // 값이 없는 경우 처리
			pageamountOfarticles = 5;
		}
		
		PageNumberVo pageNumberVo = new PageNumberVo();
		pageNumberVo.setPageAmountOfArticles(pageamountOfarticles);
		pageNumberVo.setPageNumber(pageNumber);
		
		List<BoardVo> list = new BoardRepository().findAll(pageNumberVo);
		request.setAttribute("list", list);
		WebUtil.forward(request, response, "/WEB-INF/views/board/list.jsp");
	}
}
