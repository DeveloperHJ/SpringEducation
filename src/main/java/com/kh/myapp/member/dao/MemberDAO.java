package com.kh.myapp.member.dao;

import java.util.ArrayList;

import com.kh.myapp.member.vo.MemberVO;

/**
 * Oracle SQL Developer
 * User: SPRING, Table: MEMBER
 */
public interface MemberDAO 
{
	//ȸ�����
	public void insert(MemberVO memberVO);
	
	//ȸ������ ��������
	public MemberVO getMember(String id);

	//ȸ����� ��������
	public ArrayList<MemberVO> getMemberList();

	//ȸ������ ����
	public void update(MemberVO memberVO);
	
	//ȸ������ ����
	public void delete(String id);
}
