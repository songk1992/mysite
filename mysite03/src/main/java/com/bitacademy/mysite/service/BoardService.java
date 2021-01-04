package com.bitacademy.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.mysite.repository.BoardRepository;
import com.bitacademy.mysite.vo.BoardVo;
import com.bitacademy.mysite.vo.PageNumberVo;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	public List<BoardVo> getArticleList(){
		PageNumberVo pageNumberVo = new PageNumberVo();
		pageNumberVo.setCurrentPage(1);
		pageNumberVo.setPageSize(5);
		return boardRepository.findAll(pageNumberVo);
	}
	
	public List<BoardVo> getArticleList(PageNumberVo pageNumberVo){
		return boardRepository.findAll(pageNumberVo);
	}
	
	
	public BoardVo viewArticle(Long no) {
		BoardVo boardVo = new BoardVo();
		boardVo.setNo(no);
		boardVo = boardRepository.findContentsFromNo(boardVo);
		return boardVo;
		
	}
}
