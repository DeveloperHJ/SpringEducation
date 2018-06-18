package com.kh.myapp.util;

public class FindCriteria extends RecordCriteria {
	private String searchType; // �˻� Ÿ�� 
	private String keyword; 	 // �˻��� 

	
	public FindCriteria() { } // default ������ 
	
	/**
	 * �� �������� ������ ���ڵ� ���� �����Ͽ� ��û���������� ��Ÿ�� ���ڵ��� ���۰� �� �ѹ��� ������ �� ����. 
	 * (get method Ȱ��)
	 * @param reqPage : request Page, ��û������ 
	 * @param numPerPage : �� �������� ������ ���ڵ� �� 
	 */
	public FindCriteria(int reqPage, int numPerPage) {
		super(reqPage, numPerPage);
	}
	
	/**
	 * �� �������� ������ ���ڵ� ���� �����Ͽ� ��û���������� ��Ÿ�� ���ڵ��� ���۰� �� �ѹ��� ������ �� ����. 
	 * (get method Ȱ��) 
	 * @param reqPage : request Page, ��û������ 
	 * @param numPerPage : �� �������� ������ ���ڵ� �� 
	 * @param searchType : TC(����+����), T(����), C(����), W(�ۼ���), TCW(����+����+�ۼ���)
	 * @param keyword : �˻���
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
