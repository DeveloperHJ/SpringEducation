package com.kh.myapp.bbs.service;

import java.util.List;

import com.kh.myapp.bbs.dto.BbsDTO;
import com.kh.myapp.util.FindCriteria;
import com.kh.myapp.util.PageCriteria;
import com.kh.myapp.util.RecordCriteria;

public interface BbsService {

	// 글등록 
	void write(BbsDTO bbsdto) throws Exception;

	/**
	 * 페이지 수에 따른 글 목록 가져오기
	 * @param pageCriteria
	 * @return List<BbsDTO>
	 * @throws Exception
	 */
	List<BbsDTO> list(RecordCriteria recordCriteria) throws Exception;

	// 글 내용 가져오기, 조회수 증가 
	BbsDTO view(int bNum) throws Exception;

	// 조회수 증가 
	void updateHit(int bNum) throws Exception;
 
	// 글내용 수정하기 
	void update(BbsDTO bbsdto) throws Exception;

	// 글 내용 삭제하기 
	void delete(int bNum) throws Exception;

	// 답글 폼 보기 
	BbsDTO replyView(int bNum) throws Exception;

	// 답글 등록 
	void reply(BbsDTO bbsdto) throws Exception;

	// 전체 게시물 수 구하기 
	int totalRec() throws Exception;

	
	/** 
	 * 검색한 내용의 게시물 list 출력 
	 * @param FindCriteria findCriteria
	 * @return ArrayList BbsDTO type 
	 */
	List<BbsDTO> list(FindCriteria findCriteria) throws Exception;

	
	/**
	 * 검색 결과 총계
	 * @param FindCriteria findCriteria
	 * @return int totalRec
	 */
	int searchTotalRec(FindCriteria findCriteria) throws Exception;

}