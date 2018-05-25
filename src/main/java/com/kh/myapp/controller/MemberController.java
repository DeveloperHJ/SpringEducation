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
	
	// �α� �� �� �ִ� �ν��Ͻ� .info�� ��µ�. 
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/memberJoin") // �ּҰ�
	public void memJoin(Model model) {
		
	}
	
	//@Valid : �����ϴ� ��. ������ JSP, �ڹٽ�ũ��Ʈ�� ��ȿ�� üũ�ߴµ� ��� back�ܿ��� ��ȿ��üũ ��������. (hibernate.jar 3�� �߰�����)
	//�˴ٿ����� hibernate.. 
	//�ܱ������� hibernate�� ���̹�Ƽ��� �� ���� ����. �ڹٰ�ü�� ������ ���̺��ϰ� 1:1�� ���ν�Ű����. = ORM 
	//���̹�Ƽ������ ���̺� ���� �����ϰ� �з��� �����... ���߹���� �ٸ�. �츮���󿡼��� ���̹�Ƽ�� ���� ���.
	@RequestMapping(value="/memjoinOK", method=RequestMethod.POST)
	public String memJoinOK(@Valid MemberVO memberVO, BindingResult result) {
		
		return "memberJoinOK";
	}
	
	@RequestMapping(value="/memberList", method=RequestMethod.POST)
	public String memLogin() {
		
		return "memberList";
	}
	
}
