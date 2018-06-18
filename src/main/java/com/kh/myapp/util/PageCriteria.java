package com.kh.myapp.util;

import static org.hamcrest.CoreMatchers.instanceOf;

public class PageCriteria {
	private int pageNumPerPage = 10; // �� �������� ������ ������ �� 
	
	private int startPage;			// �� ���������� ���������� 
	private int endPage;			 	// �� ���������� ���������� 
	
	private int totalRec;			  // ��ü ���ڵ� �� 
	private int finalEndPage; 	// ���������� 
	
	private boolean prev;			 // ���������� 
	private boolean next; 		 // ���������� 

	private RecordCriteria recordCriteria;	// �� �������� ������ ���ڵ� ��, ��û������ ���� 
	
	
	public PageCriteria(RecordCriteria recordCriteria) { 
		this.recordCriteria = recordCriteria;
	}
	
	/**
	 * ����¡ ������ִ� Class�� RecordCriteria Class�� getNumPerPage()�� ������. 
	 * endPage, startPage, finalEndPage, prev, next ��� ���� ����. 
	 * cf1) RecordCriteria Ÿ�� Ŭ�������� �����ϴ� ��: �� �������� ������ ���ڵ� ��
	 * cf2) pageNumPerPage �⺻���� 10 ex) 1~10
	 * @param recordCriteria
	 * @param totalRec : ��ü ���ڵ� ���� 
	 */
	public PageCriteria(RecordCriteria recordCriteria, int totalRec) {
		this(recordCriteria);
		this.totalRec = totalRec;
		this.init();
	}
	
	/**
	 * ����¡ ������ִ� Class�� RecordCriteria Class�� getNumPerPage()�� ������. 
	 * endPage, startPage, finalEndPage, prev, next ��� ���� ����. 
	 * cf1) RecordCriteria Ÿ�� Ŭ�������� �����ϴ� ��: �� �������� ������ ���ڵ� ��
	 * cf2) pageNumPerPage �⺻���� 10 ex) 1~10
	 * @param recordCriteria 
	 * @param totalRec : ��ü ���ڵ� ����
	 * @param pageNumPerPage : ǥ�õǴ� ������ ����
	 */
	public PageCriteria(RecordCriteria recordCriteria, int totalRec, int pageNumPerPage) {
		this(recordCriteria, totalRec);
		this.pageNumPerPage = pageNumPerPage;
		this.init();
	}
	
	// ��� ����
	private void init() {
		
		// 1) endPage ��� (ceil : �����ڸ� �ø� �޼���)
		// �ø�(���� ������ / ������ ����) * ������ ���� = ��µ� ������ ������ 
		this.endPage = (int) ((Math.ceil((double)this.recordCriteria.getReqPage()/pageNumPerPage)) * pageNumPerPage);
				
		// 2) startPage ��� 
		this.startPage = (this.endPage - this.pageNumPerPage) + 1; 
		
		
		// 3) finalEndPage ���
		// ��ü ���ڵ� �� / �������� ����� ���ڵ� �� 
		this.finalEndPage = (int) (Math.ceil(this.totalRec/(double)this.recordCriteria.getNumPerPage()));
		
		if(finalEndPage < endPage) { // ���� ���������� endPage�� Ŭ ��� finalEndPage�� ���� 
			endPage = finalEndPage;
		}
				
		// 4) prev ���� 
		this.prev = this.startPage == 1 ? false : true; 
		
		// 5) next ���� 
		this.next = (this.endPage * (double)this.recordCriteria.getNumPerPage() >= this.totalRec) ? false : true;
	}

	/**
	 * �˻��� ���� ��� �Ķ���� ����
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
	 * �˻��� �Ķ���� ����(URL�� �޼���� ������ֱ� ���� ������Ʈ�� �޼���)
	 * @return 
	 */
	public String makeSearchURL(int reqPage) 
	{
		StringBuffer str = new StringBuffer();
		
		str.append("reqPage="+reqPage);

		if(recordCriteria instanceof FindCriteria) 
		{	// Ű����� �������� �Ѿ�� ���� �ֱ� ������ trim�� ���� 
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
