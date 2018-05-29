package com.kh.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.myapp.member.vo.MemberVO;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping("/loginIn")	// return값 지정하지 않으면 /login/loginIn.jsp를 찾음. 
	public String logIn(Model model)
	{
		model.addAttribute("user", new MemberVO());
		return "/login/login";
	}
}
