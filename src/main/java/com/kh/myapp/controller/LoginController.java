package com.kh.myapp.controller;

import javax.servlet.http.HttpSession;
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

@Controller
@RequestMapping("/login")	// 클러스 내부에서 공통적으로 사용되는 Mapping
@SessionAttributes("login")	// Session에 대한 속성 이름을 login으로 가져감.
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	
	@Autowired
	//@Qualifier("loginServiceImplJDBC")
	@Qualifier("loginServiceImplXML")
	LoginService loginService;
	
	
	//로그인 화면 보여주기
	@RequestMapping("/loginIn")	// void: /login/loginIn.jsp
															// 요청경로와 받는 페이지는 같지 않아도 됨.
	public String logIn(Model model, HttpSession session)
	{
		if(session.getAttribute("login") != null) {
			return "redirect:/";
		}
		
		/**
		 * Session에 LoginVO 객체를 생성하여 등록 
		 * VO객체의 필드와 메서드가 View단에서의 form path가 같아야 바인딩 된다. 
		 */
		model.addAttribute("login", new LoginVO());
		return "login/login";
	}
	
	//로그인 처리 부분
	@RequestMapping("/memLoginOK")
	public String memLoginOK(@Valid @ModelAttribute("login") LoginVO login, BindingResult result, Model model) 
	{
		// 오류가 있을 경우 
		if(result.hasErrors()) {	
			return "login/login";
		} 

		// 회원정보 가져오기 
		MemberVO memberVO = loginService.getMember(login);
		if(memberVO != null) {
			// 회원정보 세션에 담기 
			model.addAttribute("login", memberVO);	
			return "redirect:/";
			
		} else {
			return "login/login";
		}
	}

	//로그아웃 처리 부분 
	@RequestMapping("/logOut")
	public String logOut(LoginVO login, SessionStatus sessionStatus)
	{
		/** 
		 * Session 에 등록된 SimpleForm 은 SessionStatus.setComplete()을 실행하기 전까지는 
		 * Session에서 내부의 데이터를 유지하게 된다. SessionStatus.setComplete()을 실행하면 
		 * Controller에서 선언해둔 SessionAttribute에 등록된 form이 초기화된다. */
		sessionStatus.setComplete();
		return "redirect:/";
	}
}
