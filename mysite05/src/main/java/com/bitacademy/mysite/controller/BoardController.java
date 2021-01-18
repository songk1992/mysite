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
import com.bitacademy.mysite.vo.UserVo;
import com.bitacademy.security.Auth;

//@Auth TODO:
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
	
	@Auth
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "board/write";
	}
	
	@Auth
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(BoardVo boardVo) {
		boardService.writeArticle(boardVo);
		return "redirect:/board";
	}

	@RequestMapping(value="/view/{no}")
	public String view(@PathVariable("no") Long no, Model model) {
		boardService.addViewCount(no);
		BoardVo boardVo = boardService.viewArticle(no);
		model.addAttribute("boardVo", boardVo);
		return "board/view";
	}
	
	@Auth
	@RequestMapping(value="/modify/{no}", method=RequestMethod.GET)
	public String modify(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no", no);
		return "board/modify";
	}

	@Auth
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(BoardVo boardVo) {
		boardService.modifyArticle(boardVo);
		return "redirect:/board";
	}
	
	@Auth
	@RequestMapping(value="/reply/{no}", method=RequestMethod.GET)
	public String reply(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no", no);
		return "board/reply";
	}
	
	@Auth
	@RequestMapping(value="/reply", method=RequestMethod.POST)
	public String reply(BoardVo boardVo) {
		boardService.replyArticle(boardVo);
		return "redirect:/board";
	}
	
	@Auth
	@RequestMapping(value="/delete/{no}", method=RequestMethod.GET)
	public String delete(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no", no);
		return "board/delete";
	}
	
	@Auth
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(UserVo userVo, BoardVo boardVo) {
		boardService.deleteArticle(userVo, boardVo);
		return "redirect:/board";
	}

	@Auth
	@RequestMapping("/good/{no}")
	public String good(@PathVariable("no") Long no) {
		boardService.likeArticle(no);
		return "redirect:/board";
	}
	
	@Auth
	@RequestMapping("/bad/{no}")
	public String bad(@PathVariable("no") Long no) {
		boardService.dislikeArticle(no);
		return "redirect:/board";
	}
	
	
	
	@RequestMapping("/search")
	public String search(String kwd, Model model) {
		List<BoardVo> list = boardService.searchArticle(kwd);
		model.addAttribute("list", list);
		return "board/list";
	}
}
