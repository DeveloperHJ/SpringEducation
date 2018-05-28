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
	
	// �α� �� �� �ִ� �ν��Ͻ� .info�� ��µ�. 
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberService;
	
	// ����ȭ��
	@RequestMapping(value="/memberJoin") // �ּҰ�
	public void memJoin(Model model) {
		model.addAttribute("memberVO", new MemberVO());
	}
	
	/* @Valid : �����ϴ� ��. 
	 * ������ JSP, �ڹٽ�ũ��Ʈ�� ��ȿ�� üũ => ������ ��� back�ܿ��� ��ȿ��üũ ��������. 
	 * DI - hibernate.jar 3�� �߰�
	 * hibernate : �˴ٿ� ���
	 * �ܱ������� Mybatis���� hibernate�� �� ���� ��� 
	 * �ڹٰ�ü�� ������ ���̺�� 1:1�� ���ν�Ű�� ����(ORM)
	 * Mybatis: ���̺� ���� ����, �з� �����... ���� ����� �ٸ�. �츮���󿡼� ���� ���. */
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
	
	//��� ���� ȭ��
	@RequestMapping(value="/memberModify/{id:.+}")	// get ��� ��� ���������� �����ϴ� ��� ���
	public String memberModify(@PathVariable String id, Model model) 
	{
		model.addAttribute("memberVO", memberService.getByMemberID(id));
		return "/member/memberList";
	}
	
	//��� ���� ó�� 
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
	
	//��� ���� ó�� 
	@RequestMapping(value="/memberDelete/{id:.+}")	// get ��� ��� ���������� �����ϴ� ��� ���
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
