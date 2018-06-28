package com.kh.myapp.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.myapp.login.service.LoginService;
import com.kh.myapp.login.vo.LoginVO;
import com.kh.myapp.member.vo.MemberVO;

//@Controller
/*@RequestMapping("/login")	// Ŭ���� ���ο��� ���������� ���Ǵ� Mapping
@SessionAttributes("user")*/
public class LoginController_old {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController_old.class);
	
	@Autowired
	@Qualifier("loginServiceImplJDBC")
	LoginService loginService;
	
	
	//�α��� ȭ�� �����ֱ�
	@RequestMapping("/loginIn")	// void: /login/loginIn.jsp
															// ��û��ο� �޴� �������� ���� �ʾƵ� ��.
	public String logIn(Model model)
	{
		model.addAttribute("user", new MemberVO());	// VO��ü �ʵ�, �޼���� view�ܿ����� 
																								// form path�� ���ƾ� ���ε��� �ȴ�. 
		return "login/login";
	}
	
/*	@RequestMapping("/memLoginOK")
	public String memLoginOK(@Valid @ModelAttribute("user") LoginVO login, BindingResult result, Model model) 
	{
		// ������ ���� ��� 
		if(result.hasErrors()) {	
			return "login/login";
		} 

		// ȸ������ �������� 
		MemberVO memberVO = loginService.getMember(user);
		if(memberVO != null) {
			// ȸ������ ���ǿ� ��� 
			model.addAttribute("user", memberVO);	
			return "redirect:/";
			
		} else {
			return "login/login";
		}
	}*/
	
	// �α׾ƿ� ó�� �κ� 
	@RequestMapping("/logOut")
	public String logOut(@ModelAttribute("user") MemberVO user, SessionStatus sessionStatus)
	{
		sessionStatus.setComplete();
		return "redirect:/";
	}
}
