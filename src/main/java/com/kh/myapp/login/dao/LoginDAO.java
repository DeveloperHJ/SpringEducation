package com.kh.myapp.login.dao;

import com.kh.myapp.member.vo.MemberVO;

public interface LoginDAO {
	// 회원정보 가져오기
	MemberVO getMember(MemberVO memberVO);

}
