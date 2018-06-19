package com.kh.myapp.bbs.service;


import java.util.List;

import com.kh.myapp.bbs.dto.RbbsDTO;


public interface RbbsService {

	// ��۵�� 
	void write(RbbsDTO rBbsdto);

	/**
	 *  �� �ۿ� ���� ��� ��� ��� �޼��� 
	 *  @param int bNum : ������ bNum 
	 */
	List<RbbsDTO> list(int bNum);
	
	/**
	 *  ������ ���ڵ� ����ŭ�� ��� ��� ���
	 *  @param int rNum : ���� ��ȣ 
	 *  @param int startRecord
	 *  @param int endRecord
	 */
	List<RbbsDTO> list(int bNum, int startRecord, int endRecord);

	// ��� ���� ��������, ��ȸ�� ���� 
	RbbsDTO view(int rNum);

	// ��۳��� �����ϱ� 
	void update(int rNum, RbbsDTO rBbsdto);

	// ��� ���� �����ϱ� 
	void delete(int rNum);

	// ��ü ��� �� ���ϱ� 
	void replyTotalRec(int bNum);

	/** �˻��� ������ list ��� 
	 * 
	 * @param startRecord
	 * @param endRecord
	 * @param searchType : TC(����+����), T(����), C(����), W(�ۼ���), TCW(����+����+�ۼ���)
	 * @param keyword : �˻���
	 * @return ArrayList BbsDTO type 
	 */
	List<RbbsDTO> list(int startRecord, int endRecord, String searchType, String keyword);

	/**
	 * �˻� �� ��ü ���ڵ� �� ���ϱ� 
	 * @return int totalRec
	 */
	void searchTotalRec(String searchType, String keyword);

	/**
	 * ������ ����� ���� �������� 
	 */
	RbbsDTO oriInform(String bNum);
	
	/** 
	 * ���� �ޱ�
	 * @param RbbsDTO;
	 * @return cnt;
	 */
	void reReply(String oriRNum, RbbsDTO rbbsdto);
	
	/**
	 * rGroup�� ���� rStep ���� 
	 * @param int rGroup(��� �׷�), int rStep(��� �ܰ�)
	 */
	void updateStep(int rGroup, int rStep);

	void goodOrBad(int rNum, String goodOrBad);

}