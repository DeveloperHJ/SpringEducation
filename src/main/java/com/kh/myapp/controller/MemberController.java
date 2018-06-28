package com.kh.myapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.myapp.member.service.MemberService;
import com.kh.myapp.member.vo.MemberVO;

@Controller  
@RequestMapping(value="/member")
public class MemberController {
	
	// �α� �� �� �ִ� �ν��Ͻ� .info�� ��µ�. 
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
//	@Qualifier("memberServiceImpl")
	@Qualifier("memberServiceImplXML")
	MemberService memberService;
	
	// ����ȭ��
	@RequestMapping(value="/memberJoin") // �ּҰ�
	public void memJoin(Model model) throws Exception {
		logger.info("memberJoin GET...");
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
		memberService.memberInsert(memberVO);
		
		return "redirect:/";
	}
	
	//��� ���� ȭ��
	@RequestMapping(value="/memberModify/{id:.+}")	// get ��� ��� ���������� �����ϴ� ��� ���
	public String memberModify(@PathVariable String id, Model model) 
	{
		model.addAttribute("memberVO", memberService.getByMemberID(id));
		return "/member/memberModify";
	}
	
	//��� ���� ó�� 
	@RequestMapping(value="/memberModifyOK")
	public String memberModifyOK(@Valid MemberVO memberVO, BindingResult result) throws Exception
	{
		if(result.hasErrors()) {
			return "/member/memberModify/"+memberVO.getId();
		} else {
			memberService.memberUpdate(memberVO);
<<<<<<< HEAD
		}
		return "redirect:/";
	}	
=======
			return "redirect:/";
		}	
	}
>>>>>>> refs/remotes/origin/master
	
	//��� ���� ó�� 
	@RequestMapping(value="/memberDelete/{id:.+}")	// get ��� ��� ���������� �����ϴ� ��� ���
	public String memberDelete(@PathVariable String id, Model model) 
	{
		if(memberService.getByMemberID(id) != null) {
			memberService.memberDelete(id);
		} else {
			
		}
		return "redirect:/";
	}
	
	//�������Ʈ
	@RequestMapping(value="/memberList")
	public String memberList(Model model)
	{
		logger.info("memberList" + MemberController.this);
		List<MemberVO> alist = memberService.getMemberAll();
		model.addAttribute("memberVOS", alist);
		return "/member/memberList";
	}

	//��� ���̵�/��й�ȣ ã�� �������� �̵� 
	@RequestMapping(value="/memberFind")
	public void memberFind(Model model) {	}
	
	//���̵� ã��
	@RequestMapping(value = "/memberFindID")
	public String findIdOK(@RequestParam("name") String name, @RequestParam("birth") String birth, 
		 										@RequestParam("phone") String phone, Model model) 
	{
	 model.addAttribute("id", memberService.findID(name, birth, phone));
	 return "/member/memberFindOK";
	}
		 
	//��й�ȣ ã��
	@RequestMapping(value = "/memberFindPawd")
	public String findPasswdOK(@RequestParam("id") String id, @RequestParam("birth") String birth, 
		 										@RequestParam("phone") String phone, Model model) 
	{
	 model.addAttribute("passwd", memberService.findPswd(id, birth, phone));
	 return "/member/memberFindOK";
	}
	
}
