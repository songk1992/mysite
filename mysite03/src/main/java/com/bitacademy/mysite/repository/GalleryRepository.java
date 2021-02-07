package com.bitacademy.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.mysite.vo.GalleryVo;

@Repository
public class GalleryRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public int addImage(GalleryVo galleryVo) {
		return sqlSession.insert("gallery.addimage", galleryVo);
	}

	public List<GalleryVo> findAll(Long startNo) {
		return sqlSession.selectList("gallery.findAllByNo", startNo);
	}

}
