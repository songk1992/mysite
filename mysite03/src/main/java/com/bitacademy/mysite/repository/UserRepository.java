package com.bitacademy.mysite.repository;


import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.mysite.exception.UserRepositoryException;
import com.bitacademy.mysite.vo.UserVo;

@Repository
public class UserRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public UserVo findByNo(Long userNo) {
		return sqlSession.selectOne("user.findByNo", userNo);
	}
	
	public UserVo findByEmailAndPassword(UserVo vo) {
		return sqlSession.selectOne("user.findByEmailAndPassword", vo);
	}
	
	public UserVo findByEmailAndPassword2(UserVo vo) {
		Map<String, Object> map = new HashMap<>();
		map.put("e", vo.getEmail());
		map.put("p", vo.getPassword());
		return sqlSession.selectOne("user.findByEmailAndPassword2", map);
	}
	
	public int insert(UserVo userVo) throws UserRepositoryException{
		return sqlSession.insert("user.insert", userVo);		
	}
	
	public int update(UserVo vo) {
		
			
//			if(null == vo.getPassword() || "".equals(vo.getPassword())) {
//				String sql =" update user set name=?, gender=? where no=?";
//				pstmt = conn.prepareStatement(sql);
//			
//				pstmt.setString(1, vo.getName());
//				pstmt.setString(2, vo.getGender());
//				pstmt.setLong(3, vo.getNo());
//			} else {
//				String sql =" update user set name=?, password=? , gender=? where no=?";
//				pstmt = conn.prepareStatement(sql);
//			
//				pstmt.setString(1, vo.getName());
//				pstmt.setString(2, vo.getPassword());
//				pstmt.setString(3, vo.getGender());
//				pstmt.setLong(4, vo.getNo());
//			}
		return sqlSession.update("user.update", vo);		
	}


}