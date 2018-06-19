package com.kh.myapp.bbs.service;


import java.util.List;

import com.kh.myapp.bbs.dto.RbbsDTO;


public interface RbbsService {

	// 댓글등록 
	void write(RbbsDTO rBbsdto);

	/**
	 *  원 글에 대한 댓글 목록 출력 메서드 
	 *  @param int bNum : 원글의 bNum 
	 */
	List<RbbsDTO> list(int bNum);
	
	/**
	 *  정해진 레코드 수만큼의 댓글 목록 출력
	 *  @param int rNum : 원글 번호 
	 *  @param int startRecord
	 *  @param int endRecord
	 */
	List<RbbsDTO> list(int bNum, int startRecord, int endRecord);

	// 댓글 내용 가져오기, 조회수 증가 
	RbbsDTO view(int rNum);

	// 댓글내용 수정하기 
	void update(int rNum, RbbsDTO rBbsdto);

	// 댓글 내용 삭제하기 
	void delete(int rNum);

	// 전체 댓글 수 구하기 
	void replyTotalRec(int bNum);

	/** 검색한 내용의 list 출력 
	 * 
	 * @param startRecord
	 * @param endRecord
	 * @param searchType : TC(제목+내용), T(제목), C(내용), W(작성자), TCW(제목+내용+작성자)
	 * @param keyword : 검색어
	 * @return ArrayList BbsDTO type 
	 */
	List<RbbsDTO> list(int startRecord, int endRecord, String searchType, String keyword);

	/**
	 * 검색 후 전체 레코드 수 구하기 
	 * @return int totalRec
	 */
	void searchTotalRec(String searchType, String keyword);

	/**
	 * 리댓의 원댓글 정보 가져오기 
	 */
	RbbsDTO oriInform(String bNum);
	
	/** 
	 * 리댓 달기
	 * @param RbbsDTO;
	 * @return cnt;
	 */
	void reReply(String oriRNum, RbbsDTO rbbsdto);
	
	/**
	 * rGroup에 대한 rStep 증가 
	 * @param int rGroup(댓글 그룹), int rStep(댓글 단계)
	 */
	void updateStep(int rGroup, int rStep);

	void goodOrBad(int rNum, String goodOrBad);

}