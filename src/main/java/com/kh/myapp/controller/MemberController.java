package com.kh.myapp.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	// 가입화면
	@RequestMapping(value="/memberJoin") // 주소값
	public void memJoin(Model model) {
		model.addAttribute("memberVO", new MemberVO());
	}
	
	/* @Valid : 검증하는 것. 
	 * 예전에 JSP, 자바스크립트로 유효성 체크 => 지금은 얘로 back단에서 유효성체크 가능해짐. 
	 * DI - hibernate.jar 3개 추가
	 * hibernate : 셧다운 방식
	 * 외국에서는 Mybatis보다 hibernate를 더 많이 사용 
	 * 자바객체를 가지고 테이블과 1:1로 매핑시키기 위해(ORM)
	 * Mybatis: 테이블 먼저 설계, 분류 만들고... 개발 방식이 다름. 우리나라에서 많이 사용. */
	@RequestMapping(value="/memberJoinOK", method=RequestMethod.POST)
	public String memJoinOK(@Valid MemberVO memberVO, BindingResult result) 
	{
		if(result.hasErrors()) {
			return "/member/memberJoin";
		} else {
			memberService.memberInsert(memberVO);
		}	
		return "/member/memberList";
	}
	
	//멤버 수정 화면
	@RequestMapping(value="/memberModify/{id:.+}")	// get 방식 대신 스프링에서 지원하는 방식 사용
	public String memberModify(@PathVariable String id, Model model) 
	{
		model.addAttribute("memberVO", memberService.getByMemberID(id));
		return "/member/memberList";
	}
	
	//멤버 수정 처리 
	@RequestMapping(value="/memberModifyOK")
	public String memberModifyOK(@Valid MemberVO memberVO, BindingResult result) 
	{
		if(result.hasErrors()) {
			return "/member/memberModify";
		} else {
			memberService.memberUpdate(memberVO);
			return "/member/memberList";
		}	
	}
	
	//멤버 삭제 처리 
	@RequestMapping(value="/memberDelete/{id:.+}")	// get 방식 대신 스프링에서 지원하는 방식 사용
	public String memberDelete(@PathVariable String id, Model model) 
	{
		if(memberService.getByMemberID(id) != null) {
			memberService.memberDelete(id);
		} else {
			
		}
		return "/member/memberList";
	}
	
	@RequestMapping(value="/memberList")
	public String memberList(Model model)
	{
		ArrayList<MemberVO> alist = memberService.getMemberAll();
		model.addAttribute("memberVOS", alist);
		return "/member/memberList";
	}
	
	@RequestMapping(value="/memberLogin", method=RequestMethod.POST)
	public String memLogin() 
	{
		return "/member/memberList";
	}
	
}
