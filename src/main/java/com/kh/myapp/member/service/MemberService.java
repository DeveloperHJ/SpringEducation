package com.kh.myapp.member.service;

import java.util.List;

import com.kh.myapp.member.vo.MemberVO;

/**
 * Oracle SQL Developer
 * User: SPRING, Table: MEMBER
 */
public interface MemberService 
{
	//ȸ�����
	public void memberInsert(MemberVO memberVO);
	
	//ȸ������ ��������
	public MemberVO getByMemberID(String id);

	//ȸ����� ��������
	public List<MemberVO> getMemberAll();

	//ȸ������ ����
	public void memberUpdate(MemberVO memberVO);
	
	//ȸ������ ����
	public void memberDelete(String id);
}
