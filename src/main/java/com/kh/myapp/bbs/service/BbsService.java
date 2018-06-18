package com.kh.myapp.bbs.service;

import java.util.List;

import com.kh.myapp.bbs.dto.BbsDTO;
import com.kh.myapp.util.FindCriteria;
import com.kh.myapp.util.PageCriteria;
import com.kh.myapp.util.RecordCriteria;

public interface BbsService {

	// �۵�� 
	void write(BbsDTO bbsdto) throws Exception;

	/**
	 * ������ ���� ���� �� ��� ��������
	 * @param pageCriteria
	 * @return List<BbsDTO>
	 * @throws Exception
	 */
	List<BbsDTO> list(RecordCriteria recordCriteria) throws Exception;

	// �� ���� ��������, ��ȸ�� ���� 
	BbsDTO view(int bNum) throws Exception;

	// ��ȸ�� ���� 
	void updateHit(int bNum) throws Exception;
 
	// �۳��� �����ϱ� 
	void update(BbsDTO bbsdto) throws Exception;

	// �� ���� �����ϱ� 
	void delete(int bNum) throws Exception;

	// ��� �� ���� 
	BbsDTO replyView(int bNum) throws Exception;

	// ��� ��� 
	void reply(BbsDTO bbsdto) throws Exception;

	// ��ü �Խù� �� ���ϱ� 
	int totalRec() throws Exception;

	
	/** 
	 * �˻��� ������ �Խù� list ��� 
	 * @param FindCriteria findCriteria
	 * @return ArrayList BbsDTO type 
	 */
	List<BbsDTO> list(FindCriteria findCriteria) throws Exception;

	
	/**
	 * �˻� ��� �Ѱ�
	 * @param FindCriteria findCriteria
	 * @return int totalRec
	 */
	int searchTotalRec(FindCriteria findCriteria) throws Exception;

}