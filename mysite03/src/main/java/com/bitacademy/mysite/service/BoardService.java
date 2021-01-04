package com.bitacademy.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.mysite.repository.BoardRepository;
import com.bitacademy.mysite.vo.BoardVo;
import com.bitacademy.mysite.vo.PageNumberVo;
import com.bitacademy.mysite.vo.UserVo;

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
	
	public boolean addViewCount(Long no) {
		BoardVo boardVo = new BoardVo();
		boardVo.setNo(no);
		return boardRepository.addViewCount(boardVo);
	}

	public boolean writeArticle(BoardVo boardVo) {
		return boardRepository.createNewArticle(boardVo);
	}

	public boolean modifyArticle(BoardVo boardVo) {
		return boardRepository.modifyArticle(boardVo);
	}

	public boolean replyArticle(BoardVo boardVo) {
		return boardRepository.createNewReply(boardVo);
		
	}

	public boolean deleteArticle(UserVo userVo, BoardVo boardVo) {
		return boardRepository.deleteArticle(userVo, boardVo);
		
	}

	
	
	public boolean likeArticle(Long no) {
		BoardVo boardVo = new BoardVo();
		boardVo.setNo(no);
		return boardRepository.addGoodCount(boardVo);
	}

	public boolean dislikeArticle(Long no) {
		BoardVo boardVo = new BoardVo();
		boardVo.setNo(no);
		return boardRepository.addNotGoodCount(boardVo);
	}

	public List<BoardVo> searchArticle(String kwd) {
		return boardRepository.findWithKeyword(kwd);
	}


}
