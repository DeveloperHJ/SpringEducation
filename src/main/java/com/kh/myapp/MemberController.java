package com.kh.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	// �α� �� �� �ִ� �ν��Ͻ� .info�� ��µ�. 
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value="/join") // �ּҰ��� /hello
	public String memJoin() {
		
		return "/memberJoin";	// hello.jsp�� ã�ư�. 
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
