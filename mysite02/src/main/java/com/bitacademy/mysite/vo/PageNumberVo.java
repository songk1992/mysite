package com.bitacademy.mysite.vo;

public class PageNumberVo {

	private int pageNumber;
	
	private int pageAmountOfArticles;

	
	
	public int getPageAmountOfArticles() {
		return pageAmountOfArticles;
	}

	public void setPageAmountOfArticles(int pageAmountOfArticles) {
		this.pageAmountOfArticles = pageAmountOfArticles;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	@Override
	public String toString() {
		return "PageNumberVo [pageNumber=" + pageNumber + ", pageAmountOfArticles=" + pageAmountOfArticles + "]";
	}

	
	
	
}
