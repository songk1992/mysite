package com.bitacademy.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.mysite.service.BoardService;
import com.bitacademy.mysite.vo.BoardVo;


@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("")
	public String index(Model model) {
		List<BoardVo> list = boardService.getArticleList();
		model.addAttribute("list", list);
		return "board/list";
	};
	
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "board/write";
	}

	@RequestMapping(value="/view/{no}")
	public String view(@PathVariable("no") Long no, Model model) {
		BoardVo boardVo = boardService.viewArticle(no);
		model.addAttribute("boardVo", boardVo);
		return "board/view";
	}
	
	@RequestMapping("/modify")
	public String modify() {
		return null;
	}

	

	
	@RequestMapping("/delete")
	public String delete() {
		return null;
	}
	
	@RequestMapping("/reply")
	public String reply() {
		return null;
	}
	
	@RequestMapping("/good")
	public String good() {
		return null;
	}
	
	@RequestMapping("/bad")
	public String bad() {
		return null;
	}
	
	@RequestMapping("/search")
	public String search() {
		return null;
	}
}
