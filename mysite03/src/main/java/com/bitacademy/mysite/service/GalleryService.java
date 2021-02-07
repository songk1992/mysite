package com.bitacademy.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bitacademy.mysite.repository.GalleryRepository;
import com.bitacademy.mysite.vo.GalleryVo;

@Service
public class GalleryService {

	@Autowired
	private FileUploadService fileUploadService;
	
	@Autowired 
	private GalleryRepository galleryRepository;
	

	// 트랜잭션처리 TODO:
	public int addImage(GalleryVo galleryVo) {
	
		galleryVo.setImageUrl(fileUploadService.restore(galleryVo.getMultipartFile()));		
		
		return galleryRepository.addImage(galleryVo);
	}


	public List<GalleryVo> getImageList(Long startNo) {
		return galleryRepository.findAll(startNo);
	}

}
