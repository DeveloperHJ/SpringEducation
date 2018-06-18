package com.kh.myapp.util;

/**
 * �� �������� ������ ���ڵ� ���� �����Ͽ� ��û���������� ��Ÿ�� ���ڵ��� ���۰� �� �ѹ��� ������ �� ����. (get method Ȱ��)
 * ��û������ �� �� �������� ������ ���ڵ� �� setting�� �ʿ���. 
 * reqPage : request Page, ��û������ 
 * numPerPage : �� �������� ������ ���ڵ� �� 
 */
public class RecordCriteria {
	private int reqPage; // ��û������
	private int numPerPage; // �� �������� ������ ���ڵ� ��

	public RecordCriteria() {	}
	
	/**
	 * �� �������� ������ ���ڵ� ���� �����Ͽ� ��û���������� ��Ÿ�� ���ڵ��� ���۰� �� �ѹ��� ������ �� ����. (get method Ȱ��)
	 * @param reqPage : request Page, ��û������ 
	 * @param numPerPage : �� �������� ������ ���ڵ� �� 
	 */
	public RecordCriteria(int reqPage, int numPerPage) {
		this.reqPage = reqPage;
		this.numPerPage = numPerPage;
	}

	public int getReqPage() {
		return reqPage;
	}

	public void setReqPage(int reqPage) {
		if (reqPage <= 0) {
			this.reqPage = 1;
			return;
		}
		this.reqPage = reqPage;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		// �� �������� ���� �� ��ϼ��� �ּ� 1~100
		if (numPerPage <= 0 || numPerPage > 100) {
			this.numPerPage = 10;
			return;
		}
		this.numPerPage = numPerPage;
	}

	// ���۷��ڵ� ��� = ((��û������-1) * �� �������� ���� �� ���ڵ� ��) +1
	public int getStartRecord() {
		return ((this.reqPage - 1) * this.numPerPage) + 1;

	}

	// ���� ���ڵ� ��� = ���۷��ڵ� + �� �������� ���� �� ���ڵ� ��
	// ��û������ * ���������� ���� �� ���ڵ� ��
	public int getEndRecord() {
		// return this.getStartRecord() + this.numPerPage - 1;
		return this.reqPage * this.numPerPage;
	}

	@Override
	public String toString() {
		return "RecordCriteria [reqPage=" + reqPage + ", numPerPage=" + numPerPage + "]";
	}
	
}