package com.bitacademy.mysite.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.mysite.vo.BoardVo;
import com.bitacademy.mysite.vo.PageNumberVo;
import com.bitacademy.mysite.vo.UserVo;

@Repository
public class BoardRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardVo> findAll(PageNumberVo pageNumberVo) {
		return sqlSession.selectList("board.findAll", pageNumberVo);
	}

	public int createNewArticle(BoardVo boardVo) {
		return sqlSession.insert("board.createNewArticle", boardVo);
	}

	public BoardVo findContentsFromNo(BoardVo boardVo) {
		return sqlSession.selectOne("board.findContentsFromNo", boardVo);
	}

	public int modifyArticle(BoardVo boardVo) {
		return sqlSession.update("board.modifyArticle",boardVo);
	}

	public int createNewReply(BoardVo boardVo) {
		return sqlSession.insert("board.createNewReply", boardVo);
	}

	public boolean deleteArticle(UserVo userVo, BoardVo boardVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardVo", boardVo);
		map.put("userVo", userVo);
		return sqlSession.delete("board.deleteArticle", map)==1;
	}

	public boolean addViewCount(BoardVo boardVo) {
		return sqlSession.update("board.addViewCount",boardVo)==1;
	}

	public boolean addGoodCount(BoardVo boardVo) {
		return sqlSession.update("board.addGoodCount",boardVo)==1;
	}

	public boolean addNotGoodCount(BoardVo boardVo) {
		return sqlSession.update("board.addNotGoodCount",boardVo)==1;
	}

	public List<BoardVo> findWithKeyword(String kwd) {
		return sqlSession.selectList("board.findWithKeyword", kwd);
	}
	
	
	
}







