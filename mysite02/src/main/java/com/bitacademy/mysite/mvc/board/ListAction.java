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
		
		// null 값이 들어오면 페이지 값을 1로 설정합니다.
		Integer currentPage = nullCheckAndSetDefaultValue(request.getParameter("currentPage"), 1);
		
		// null 값이 들어오면 글 개수  값을  5로 설정합니다.
		Integer pageSize = nullCheckAndSetDefaultValue(request.getParameter("pageSize"), 5);
	
		
		PageNumberVo pageNumberVo = new PageNumberVo();
		pageNumberVo.setPageSize(pageSize);
		pageNumberVo.setCurrentPage(currentPage);
		
		List<BoardVo> list = new BoardRepository().findAll(pageNumberVo);
		request.setAttribute("list", list);
		WebUtil.forward(request, response, "/WEB-INF/views/board/list.jsp");
	}

	private Integer nullCheckAndSetDefaultValue(String input_str, Integer return_value) {
		
		String tempStr = input_str;
		
		if (tempStr != null && tempStr.length() != 0) {
		    // 값이 있는 경우 처리
			return_value = Integer.valueOf(tempStr);
		} else {
		    // 값이 없는 경우 처리
		}
		return return_value;
	}
}
