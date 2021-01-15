package com.bitacademy.mysite.vo;

public class SiteVo {

	private Long siteNo;
	private String title1;
	private String title2;
	private String welcomeMessage;
	private String profileURL;
	private String description;
	public Long getSiteNo() {
		return siteNo;
	}
	public void setSiteNo(Long siteNo) {
		this.siteNo = siteNo;
	}
	public String getTitle1() {
		return title1;
	}
	public void setTitle1(String title1) {
		this.title1 = title1;
	}
	public String getTitle2() {
		return title2;
	}
	public void setTitle2(String title2) {
		this.title2 = title2;
	}
	public String getWelcomeMessage() {
		return welcomeMessage;
	}
	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}
	public String getProfileURL() {
		return profileURL;
	}
	public void setProfileURL(String profileURL) {
		this.profileURL = profileURL;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "SiteVo [siteNo=" + siteNo + ", title1=" + title1 + ", title2=" + title2 + ", welcomeMessage="
				+ welcomeMessage + ", profileURL=" + profileURL + ", description=" + description + "]";
	}

	
}