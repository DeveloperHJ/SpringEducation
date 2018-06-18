package com.kh.myapp.util;

import static org.hamcrest.CoreMatchers.instanceOf;

public class PageCriteria {
	private int pageNumPerPage = 10; // 한 페이지에 보여줄 페이지 수 
	
	private int startPage;			// 한 페이지에서 시작페이지 
	private int endPage;			 	// 한 페이지에서 종료페이지 
	
	private int totalRec;			  // 전체 레코드 수 
	private int finalEndPage; 	// 최종페이지 
	
	private boolean prev;			 // 이전페이지 
	private boolean next; 		 // 다음페이지 

	private RecordCriteria recordCriteria;	// 한 페이지에 보여줄 레코드 수, 요청페이지 참조 
	
	
	public PageCriteria(RecordCriteria recordCriteria) { 
		this.recordCriteria = recordCriteria;
	}
	
	/**
	 * 페이징 출력해주는 Class로 RecordCriteria Class의 getNumPerPage()를 참조함. 
	 * endPage, startPage, finalEndPage, prev, next 계산 로직 포함. 
	 * cf1) RecordCriteria 타입 클래스에서 참조하는 것: 한 페이지에 보여줄 레코드 수
	 * cf2) pageNumPerPage 기본값은 10 ex) 1~10
	 * @param recordCriteria
	 * @param totalRec : 전체 레코드 개수 
	 */
	public PageCriteria(RecordCriteria recordCriteria, int totalRec) {
		this(recordCriteria);
		this.totalRec = totalRec;
		this.init();
	}
	
	/**
	 * 페이징 출력해주는 Class로 RecordCriteria Class의 getNumPerPage()를 참조함. 
	 * endPage, startPage, finalEndPage, prev, next 계산 로직 포함. 
	 * cf1) RecordCriteria 타입 클래스에서 참조하는 것: 한 페이지에 보여줄 레코드 수
	 * cf2) pageNumPerPage 기본값은 10 ex) 1~10
	 * @param recordCriteria 
	 * @param totalRec : 전체 레코드 개수
	 * @param pageNumPerPage : 표시되는 페이지 개수
	 */
	public PageCriteria(RecordCriteria recordCriteria, int totalRec, int pageNumPerPage) {
		this(recordCriteria, totalRec);
		this.pageNumPerPage = pageNumPerPage;
		this.init();
	}
	
	// 계산 로직
	private void init() {
		
		// 1) endPage 계산 (ceil : 정수자리 올림 메서드)
		// 올림(현재 페이지 / 페이지 개수) * 페이지 개수 = 출력될 마지막 페이지 
		this.endPage = (int) ((Math.ceil((double)this.recordCriteria.getReqPage()/pageNumPerPage)) * pageNumPerPage);
				
		// 2) startPage 계산 
		this.startPage = (this.endPage - this.pageNumPerPage) + 1; 
		
		
		// 3) finalEndPage 계산
		// 전체 레코드 수 / 페이지당 출력할 레코드 수 
		this.finalEndPage = (int) (Math.ceil(this.totalRec/(double)this.recordCriteria.getNumPerPage()));
		
		if(finalEndPage < endPage) { // 최종 페이지보다 endPage가 클 경우 finalEndPage로 설정 
			endPage = finalEndPage;
		}
				
		// 4) prev 여부 
		this.prev = this.startPage == 1 ? false : true; 
		
		// 5) next 여부 
		this.next = (this.endPage * (double)this.recordCriteria.getNumPerPage() >= this.totalRec) ? false : true;
	}

	/**
	 * 검색이 없을 경우 파라미터 설정
	 * @return
	 */
	public String makeURL() {
		
		StringBuffer str = new StringBuffer();
		
		if(recordCriteria.getReqPage() != 0) {
			str.append("reqPage="+recordCriteria.getReqPage());
		}
		
		return str.toString();
	}
	
	/**
	 * 검색용 파라미터 설정(URL을 메서드로 대신해주기 위한 쿼리스트링 메서드)
	 * @return 
	 */
	public String makeSearchURL(int reqPage) 
	{
		StringBuffer str = new StringBuffer();
		
		str.append("reqPage="+reqPage);

		if(recordCriteria instanceof FindCriteria) 
		{	// 키워드는 공백으로 넘어올 수도 있기 때문에 trim도 적용 
			if(((FindCriteria)recordCriteria).getSearchType() != null ||
				 !((FindCriteria)recordCriteria).getSearchType().trim().equals("")) 
			{	
				str.append("&searchType="+((FindCriteria)recordCriteria).getSearchType()+"&");
			}
			
			if(((FindCriteria)recordCriteria).getKeyword() != null || 
				 !((FindCriteria)recordCriteria).getKeyword().trim().equals(""))
			{
				str.append("keyword="+((FindCriteria)recordCriteria).getKeyword());
			}	
		}
		
		return str.toString();
	}
	
	public int getPageNumPerPage() {
		return pageNumPerPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotalRec() {
		return totalRec;
	}

	public void setTotalRec(int totalRec) {
		this.totalRec = totalRec;
	}

	public int getFinalEndPage() {
		return finalEndPage;
	}

	public void setFinalEndPage(int finalEndPage) {
		this.finalEndPage = finalEndPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public RecordCriteria getRecordCriteria() {
		return recordCriteria;
	}

	public void setRecordCriteria(RecordCriteria recordCriteria) {
		this.recordCriteria = recordCriteria;
	}

	@Override
	public String toString() {
		return "PageCriteria [PAGENUMPERPAGE=" + pageNumPerPage + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", totalRec=" + totalRec + ", finalEndPage=" + finalEndPage + ", prev=" + prev + ", next=" + next
				+ ", recordCriteria=" + recordCriteria + "]";
	}

}
