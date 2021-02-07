package com.bitacademy.mysite.vo;

import org.springframework.web.multipart.MultipartFile;

public class GalleryVo {
	private Long no;

	private String comments;
	private String imageUrl;
	private MultipartFile multipartFile;
	
	//기본기능 완성후 추가 TODO:
	private String password;
	private String regDate;
	
	
	public GalleryVo() {
		
	}
	
	
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "GalleryVo [no=" + no + ", comments=" + comments + ", imageUrl=" + imageUrl + ", multipartFile="
				+ multipartFile + ", password=" + password + ", regDate=" + regDate + "]";
	}


	
}
