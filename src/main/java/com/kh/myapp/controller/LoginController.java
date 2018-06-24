package com.kh.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.myapp.login.service.LoginService;
import com.kh.myapp.login.vo.LoginVO;
import com.kh.myapp.login.vo.SecurityLoginVO;
import com.kh.myapp.member.vo.MemberVO;

@Controller
@RequestMapping("/login")	// Ŭ���� ���ο��� ���������� ���Ǵ� Mapping
@SessionAttributes("login")	// Session�� ���� �Ӽ� �̸��� login���� ������.
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	
	@Autowired
	@Qualifier("loginServiceImplXML")
	LoginService loginService;
	
	//�α��� ȭ�� �����ֱ�
	@RequestMapping("/login")	// void: /login/loginIn.jsp
															// ��û��ο� �޴� �������� ���� �ʾƵ� ��.
	public String securityLogIn(Model model)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info("���� : " + auth.getPrincipal().toString());
		
		// �͸��� ������ �ƴ� ��� home���� �̵� (=�α��� ���� ���)
		if(!auth.getPrincipal().equals("anonymousUser")) {
			logger.info("�����" + auth.getPrincipal());
			return "redirect:/";
		}
		
		return "login/login";
	}
	
	
	//�α��� ȭ�� �����ֱ�(Security ��� ��)
	@RequestMapping("/loginIn")	// void: /login/loginIn.jsp
															// ��û��ο� �޴� �������� ���� �ʾƵ� ��.
	public String logIn(Model model, HttpSession session)
	{
		if(session.getAttribute("login") != null) {
			return "redirect:/";
		}
		model.addAttribute("login", new LoginVO());	// Session�� LoginVO ��ü�� �����Ͽ� ��� 
																								// VO��ü�� �ʵ�� �޼��尡 View�ܿ����� form path�� ���ƾ� ���ε� �ȴ�. 
		return "login/login";
	}
	
	//�α��� ó�� �κ�
	@RequestMapping("/memLoginOK")
	public String memLoginOK(@Valid @ModelAttribute("login") LoginVO login, BindingResult result, Model model) 
	{
		// ������ ���� ��� 
		if(result.hasErrors()) {	
			return "login/login";
		} 

		// ȸ������ �������� 
		MemberVO memberVO = loginService.getMember(login);
		if(memberVO != null) {
			// ȸ������ ���ǿ� ��� 
			model.addAttribute("login", memberVO);	
			return "redirect:/";
			
		} else {
			return "login/login";
		}
	}

	//�α׾ƿ� ó�� �κ� 
	@RequestMapping(value = "/logOut", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request, HttpServletResponse response)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		/*
		sessionStatus.setComplete();	// Security ��� �� logout
																	// Session �� ��ϵ� SimpleForm �� SessionStatus.setComplete()�� �����ϱ� �������� 
																	// Session���� ������ �����͸� �����ϰ� �ȴ�. SessionStatus.setComplete()�� �����ϸ� 
																	// Controller���� �����ص� SessionAttribute�� ��ϵ� form�� �ʱ�ȭ�ȴ�. 
		*/
		return "redirect:/";
	}
}
