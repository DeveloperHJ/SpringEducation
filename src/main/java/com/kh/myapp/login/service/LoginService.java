package com.kh.myapp.login.service;

import com.kh.myapp.login.vo.LoginVO;
import com.kh.myapp.member.vo.MemberVO;

public interface LoginService {
	// ȸ������ ��������
	MemberVO getMember(LoginVO loginVO);
}
