package com.kh.myapp.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kh.myapp.login.dao.LoginDAO;
import com.kh.myapp.login.vo.LoginVO;
import com.kh.myapp.member.vo.MemberVO;

@Service
public class LoginServiceImplJDBC implements LoginService {
	
	@Autowired
	@Qualifier("loginDAOImplJDBC")
	LoginDAO loginDAO;

	@Override
	public MemberVO getMember(LoginVO loginVO) {
		return loginDAO.getMember(loginVO);
	}

}
