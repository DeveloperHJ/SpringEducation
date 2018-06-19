package com.kh.myapp.bbs.dao;

import java.util.List;

import com.kh.myapp.bbs.dto.RbbsDTO;
import com.kh.myapp.util.FindCriteria;
import com.kh.myapp.util.RecordCriteria;

public interface RbbsDAO {

	// ��۵�� 
	void write(RbbsDTO rBbsdto) throws Exception;

	/**
	 *  �� �ۿ� ���� ��� ��� ��� �޼��� 
	 *  @param int bNum : ������ bNum 
	 */
	List<RbbsDTO> list(int bNum) throws Exception;
	
	/**
	 *  ������ ���ڵ� ����ŭ�� ��� ��� ���
	 *  @param int rNum : ���� ��ȣ 
	 *  @param int startRecord
	 *  @param int endRecord
	 */
	List<RbbsDTO> list(int bNum, RecordCriteria recordCriteria) throws Exception;

	// ��۳��� �����ϱ� 
	void update(RbbsDTO rBbsdto) throws Exception;

	// ��� ���� �����ϱ� 
	void delete(int rNum) throws Exception;

	// ��ü ��� �� ���ϱ� 
	Integer replyTotalRec(int bNum) throws Exception;

	//������ ����� ���� �������� 
	RbbsDTO oriInform(int bNum) throws Exception;
	
	//���� �ޱ�
	void reReply(RbbsDTO rbbsdto) throws Exception;
	
	/**
	 * rGroup�� ���� rStep ���� 
	 * @param int rGroup(��� �׷�), int rStep(��� �ܰ�)
	 */
	void updateStep(int rGroup, int rStep) throws Exception;

	void goodOrBad(int rNum, String goodOrBad) throws Exception;

}