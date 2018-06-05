package com.kh.myapp.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kh.myapp.member.vo.MemberVO;

/**
 * Oracle SQL Developer
 * User: SPRING, Table: MEMBER
 */
public interface MemberDAO 
{
	//회원등록
	public void insert(MemberVO memberVO);
	
	//회원정보 가져오기
	public MemberVO getMember(String id);

	//회원목록 가져오기
	public List<MemberVO> getMemberList();

	//회원정보 수정
	public void update(MemberVO memberVO);
	
	//회원정보 삭제
	public void delete(String id);
	
	//아이디 찾기
	public String findID(@Param("name")String name, @Param("birth2")String birth, @Param("phone2")String phone);
	
	//비밀번호 찾기 
	public String findPswd(@Param("id")String id, @Param("birth")String birth, @Param("phone")String phone);
}
