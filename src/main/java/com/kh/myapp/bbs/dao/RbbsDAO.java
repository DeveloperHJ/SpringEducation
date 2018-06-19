package com.kh.myapp.bbs.dao;

import java.util.List;

import com.kh.myapp.bbs.dto.RbbsDTO;
import com.kh.myapp.util.FindCriteria;
import com.kh.myapp.util.RecordCriteria;

public interface RbbsDAO {

	// 댓글등록 
	void write(RbbsDTO rBbsdto) throws Exception;

	/**
	 *  원 글에 대한 댓글 목록 출력 메서드 
	 *  @param int bNum : 원글의 bNum 
	 */
	List<RbbsDTO> list(int bNum) throws Exception;
	
	/**
	 *  정해진 레코드 수만큼의 댓글 목록 출력
	 *  @param int rNum : 원글 번호 
	 *  @param int startRecord
	 *  @param int endRecord
	 */
	List<RbbsDTO> list(int bNum, RecordCriteria recordCriteria) throws Exception;

	// 댓글내용 수정하기 
	void update(RbbsDTO rBbsdto) throws Exception;

	// 댓글 내용 삭제하기 
	void delete(int rNum) throws Exception;

	// 전체 댓글 수 구하기 
	Integer replyTotalRec(int bNum) throws Exception;

	//리댓의 원댓글 정보 가져오기 
	RbbsDTO oriInform(int bNum) throws Exception;
	
	//리댓 달기
	void reReply(RbbsDTO rbbsdto) throws Exception;
	
	/**
	 * rGroup에 대한 rStep 증가 
	 * @param int rGroup(댓글 그룹), int rStep(댓글 단계)
	 */
	void updateStep(int rGroup, int rStep) throws Exception;

	void goodOrBad(int rNum, String goodOrBad) throws Exception;

}