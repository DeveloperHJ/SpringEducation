package com.kh.myapp.util;

public class FindCriteria extends RecordCriteria {
	private String searchType; // 검색 타입 
	private String keyword; 	 // 검색어 

	
	public FindCriteria() { } // default 생성자 
	
	/**
	 * 한 페이지에 보여질 레코드 수를 설정하여 요청페이지에서 나타날 레코드의 시작과 끝 넘버를 가져올 수 있음. 
	 * (get method 활용)
	 * @param reqPage : request Page, 요청페이지 
	 * @param numPerPage : 한 페이지에 보여줄 레코드 수 
	 */
	public FindCriteria(int reqPage, int numPerPage) {
		super(reqPage, numPerPage);
	}
	
	/**
	 * 한 페이지에 보여질 레코드 수를 설정하여 요청페이지에서 나타날 레코드의 시작과 끝 넘버를 가져올 수 있음. 
	 * (get method 활용) 
	 * @param reqPage : request Page, 요청페이지 
	 * @param numPerPage : 한 페이지에 보여줄 레코드 수 
	 * @param searchType : TC(제목+내용), T(제목), C(내용), W(작성자), TCW(제목+내용+작성자)
	 * @param keyword : 검색어
	 */
	public FindCriteria(int reqPage, int numPerPage, String searchType, String keyword) {
		super(reqPage, numPerPage);
		this.searchType = searchType;
		this.keyword = keyword;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "FindCriteria [searchType=" + searchType + ", keyword=" + keyword + "]";
	}
}
