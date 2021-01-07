package com.bitacademy.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitacademy.mysite.service.MainService;
import com.bitacademy.mysite.vo.SiteVo;


@Controller
public class MainController {
	@Autowired
	private MainService mainService;
	
	
	@RequestMapping("")
	public String index(Model model) {
		SiteVo siteVo = mainService.viewSetting();
		model.addAttribute("siteVo", siteVo);
		return "main/index";
	}
}