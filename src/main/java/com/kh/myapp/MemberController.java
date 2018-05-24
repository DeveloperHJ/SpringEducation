package com.kh.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	// 로그 찍어볼 수 있는 인스턴스 .info로 출력됨. 
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value="/join") // 주소값이 /hello
	public String memJoin() {
		
		return "/memberJoin";	// hello.jsp를 찾아감. 
	}
	
	@RequestMapping(value="/memjoinOK", method=RequestMethod.POST)
	public String memJoinOK() {
		
		return "/memberJoinOK";
	}
	
	@RequestMapping(value="/memLogin", method=RequestMethod.POST)
	public String memLogin() {
		
		return "/memLogin";
	}
	
}
