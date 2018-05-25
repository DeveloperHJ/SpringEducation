package com.kh.myapp.member.service;

import java.util.ArrayList;

import com.kh.myapp.member.vo.MemberVO;

/**
 * Oracle SQL Developer
 * User: SPRING, Table: MEMBER
 */
public interface MemberService 
{
	//회원등록
	public void memberInsert(MemberVO memberVO);
	
	//회원정보 가져오기
	public MemberVO getByMemberID(String id);

	//회원목록 가져오기
	public ArrayList<MemberVO> getMemberAll();

	//회원정보 수정
	public void memberUpdate(MemberVO memberVO);
	
	//회원정보 삭제
	public void memberDelete(String id);
}
