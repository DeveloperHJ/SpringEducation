package com.kh.myapp.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.myapp.member.service.MemberService;
import com.kh.myapp.member.vo.MemberVO;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	// 로그 찍어볼 수 있는 인스턴스 .info로 출력됨. 
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/memberJoin") // 주소값
	public void memJoin(Model model) {
		
	}
	
	//@Valid : 검증하는 것. 예전에 JSP, 자바스크립트로 유효성 체크했는데 얘로 back단에서 유효성체크 가능해짐. (hibernate.jar 3개 추가했음)
	//셧다운방식인 hibernate.. 
	//외국에서는 hibernate를 마이바티즈보다 더 많이 쓴다. 자바객체를 가지고 테이블하고 1:1로 매핑시키려고. = ORM 
	//마이바티즈방식은 테이블 먼저 설계하고 분류를 만들고... 개발방식이 다름. 우리나라에서는 마이바티즈 많이 사용.
	@RequestMapping(value="/memjoinOK", method=RequestMethod.POST)
	public String memJoinOK(@Valid MemberVO memberVO, BindingResult result) {
		
		return "memberJoinOK";
	}
	
	@RequestMapping(value="/memberList", method=RequestMethod.POST)
	public String memLogin() {
		
		return "memberList";
	}
	
}
