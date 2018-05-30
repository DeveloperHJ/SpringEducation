package com.kh.myapp.login.service;

import com.kh.myapp.member.vo.MemberVO;

public interface LoginService {
	// 회원정보 가져오기
	MemberVO getMember(MemberVO memberVO);
}
