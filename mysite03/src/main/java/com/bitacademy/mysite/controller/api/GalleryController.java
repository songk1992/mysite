package com.bitacademy.mysite.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bitacademy.mysite.dto.JsonResult;
import com.bitacademy.mysite.service.GalleryService;
import com.bitacademy.mysite.vo.GalleryVo;


@RestController("galleryApiController")
@RequestMapping("/api/gallery")
public class GalleryController {

	@Autowired
	private GalleryService galleryService;
	
	@RequestMapping("/list/{no}")
	public JsonResult list(@PathVariable("no") Long startNo) {
		List<GalleryVo> list = galleryService.getImageList(startNo);
		return JsonResult.success(list);
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
