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
/*@RequestMapping("/login")	// 클러스 내부에서 공통적으로 사용되는 Mapping
@SessionAttributes("user")*/
public class LoginController_old {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController_old.class);
	
	@Autowired
	@Qualifier("loginServiceImplJDBC")
	LoginService loginService;
	
	
	//로그인 화면 보여주기
	@RequestMapping("/loginIn")	// void: /login/loginIn.jsp
															// 요청경로와 받는 페이지는 같지 않아도 됨.
	public String logIn(Model model)
	{
		model.addAttribute("user", new MemberVO());	// VO객체 필드, 메서드와 view단에서의 
																								// form path가 같아야 바인딩이 된다. 
		return "login/login";
	}
	
/*	@RequestMapping("/memLoginOK")
	public String memLoginOK(@Valid @ModelAttribute("user") LoginVO login, BindingResult result, Model model) 
	{
		// 오류가 있을 경우 
		if(result.hasErrors()) {	
			return "login/login";
		} 

		// 회원정보 가져오기 
		MemberVO memberVO = loginService.getMember(user);
		if(memberVO != null) {
			// 회원정보 세션에 담기 
			model.addAttribute("user", memberVO);	
			return "redirect:/";
			
		} else {
			return "login/login";
		}
	}*/
	
	// 로그아웃 처리 부분 
	@RequestMapping("/logOut")
	public String logOut(@ModelAttribute("user") MemberVO user, SessionStatus sessionStatus)
	{
		sessionStatus.setComplete();
		return "redirect:/";
	}
}
