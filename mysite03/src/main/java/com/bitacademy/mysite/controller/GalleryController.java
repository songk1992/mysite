package com.bitacademy.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bitacademy.mysite.service.GalleryService;
import com.bitacademy.mysite.vo.GalleryVo;

@Controller
@RequestMapping("/gallery")
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;
	
	@RequestMapping("")
	public String index() {
		return "gallery/index";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(
		@RequestParam(value="input-comments") String comment,
		@RequestParam(value="input-file") MultipartFile multipartFile){
			
		GalleryVo vo = new GalleryVo();
		vo.setMultipartFile(multipartFile);
		vo.setComments(comment);
		
			System.out.println("dsadasda");
			System.out.println("\n\n\n\n\n"+vo.getComments());
			galleryService.addImage(vo);
				
			return "gallery/index";
		}
	
	
}
