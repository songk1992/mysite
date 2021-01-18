package com.bitacademy.mysite.vo;

public class PageNumberVo {

	/*
	 * 참조
	 * https://gangnam-americano.tistory.com/18
	 */
	
	/** 한 페이지당 게시글 수 **/
    private int pageSize = 10;
    
    /** 한 블럭(range)당 페이지 수 **/
    private int rangeSize = 10;
    
    /** 현재 페이지 **/
    private int currentPage = 1;
    
    /** 현재 블럭(range) **/
    private int currentRange = 1;
    
    /** 총 게시글 수 **/
    private int listCount;
    
    /** 총 페이지 수 **/
    private int pageCount;
    
    /** 총 블럭(range) 수 **/
    private int rangeCount;
    
    /** 시작 페이지 **/
    private int firstPage = 1;
    
    /** 끝 페이지 **/
    private int lastPage = 1;
    
    /** 시작 index **/
    private int startIndex = 0;
    
    /** 이전 페이지 **/
    private int prevPage;
    
    /** 다음 페이지 **/
    private int nextPage;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRangeSize() {
		return rangeSize;
	}

	public void setRangeSize(int rangeSize) {
		this.rangeSize = rangeSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCurrentRange() {
		return currentRange;
	}

	public void setCurrentRange(int currentRange) {
		this.currentRange = currentRange;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRangeCount() {
		return rangeCount;
	}

	public void setRangeCount(int rangeCount) {
		this.rangeCount = rangeCount;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	@Override
	public String toString() {
		return "PageNumberVo [pageSize=" + pageSize + ", rangeSize=" + rangeSize + ", currentPage=" + currentPage
				+ ", currentRange=" + currentRange + ", listCount=" + listCount + ", pageCount=" + pageCount
				+ ", rangeCount=" + rangeCount + ", firstPage=" + firstPage + ", lastPage=" + lastPage + ", startIndex="
				+ startIndex + ", prevPage=" + prevPage + ", nextPage=" + nextPage + "]";
	}

    
    
}
	
