package com.bitacademy.mysite.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.mysite.vo.SiteVo;

@Repository
public class SiteRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public SiteVo findLatestMainPageContents(SiteVo siteVo) {
		return sqlSession.selectOne("site.findLatestMainPageContents", siteVo);
	}

}
