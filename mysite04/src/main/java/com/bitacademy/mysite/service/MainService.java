package com.bitacademy.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.mysite.repository.SiteRepository;
import com.bitacademy.mysite.vo.SiteVo;

@Service
public class MainService {

	@Autowired
	private SiteRepository siteRepository;
	
	public SiteVo viewSetting() {
		SiteVo adminPageVo = null;
		return siteRepository.findLatestMainPageContents(adminPageVo);
	}

}
