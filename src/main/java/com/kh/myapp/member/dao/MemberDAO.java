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
	//ȸ�����
	public void insert(MemberVO memberVO);
	
	//ȸ������ ��������
	public MemberVO getMember(String id);

	//ȸ����� ��������
	public List<MemberVO> getMemberList();

	//ȸ������ ����
	public void update(MemberVO memberVO);
	
	//ȸ������ ����
	public void delete(String id);
	
	//���̵� ã��
	public String findID(@Param("name")String name, @Param("birth2")String birth, @Param("phone2")String phone);
	
	//��й�ȣ ã�� 
	public String findPswd(@Param("id")String id, @Param("birth")String birth, @Param("phone")String phone);
}
