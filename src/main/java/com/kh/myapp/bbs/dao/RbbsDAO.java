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
	List<RbbsDTO> list(Integer bNum) throws Exception;
	
	/**
	 *  ������ ���ڵ� ����ŭ�� ��� ��� ���
	 *  @param int rNum : ���� ��ȣ 
	 *  @param int startRecord
	 *  @param int endRecord
	 */
	List<RbbsDTO> list(Integer bNum, RecordCriteria recordCriteria) throws Exception;

	// ��۳��� �����ϱ� 
	void update(RbbsDTO rBbsdto) throws Exception;

	// ��� ���� �����ϱ� 
	void delete(Integer rNum) throws Exception;

	// ��ü ��� �� ���ϱ� 
	Integer replyTotalRec(Integer bNum) throws Exception;

	//������ ����� ���� �������� 
	RbbsDTO oriInform(Integer bNum) throws Exception;
	
	//���� �ޱ�
	void reReply(RbbsDTO rbbsdto) throws Exception;
	
	/**
	 * rGroup�� ���� rStep ���� 
	 * @param int rGroup(��� �׷�), int rStep(��� �ܰ�)
	 */
	void updateStep(Integer rGroup, Integer rStep) throws Exception;

	void goodOrBad(Integer rNum, String goodOrBad) throws Exception;

}