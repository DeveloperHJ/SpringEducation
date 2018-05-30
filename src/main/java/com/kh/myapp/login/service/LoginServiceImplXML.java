package com.kh.myapp.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kh.myapp.login.dao.LoginDAO;
import com.kh.myapp.member.vo.MemberVO;

@Service
public class LoginServiceImplXML implements LoginService {

	@Autowired
	@Qualifier("loginDAOImplXML")
	LoginDAO loginDAO;
	
	@Override
	public MemberVO getMember(MemberVO memberVO) {
		System.out.println("loginServiceImplXML!!!!");
		return loginDAO.getMember(memberVO);
	}

}
