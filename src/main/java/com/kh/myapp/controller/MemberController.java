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
	
	// 로그 찍어볼 수 있는 인스턴스 .info로 출력됨. 
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
//	@Qualifier("memberServiceImpl")
	@Qualifier("memberServiceImplXML")
	MemberService memberService;
	
	// 가입화면
	@RequestMapping(value="/memberJoin") // 주소값
	public void memJoin(Model model) throws Exception {
		logger.info("memberJoin GET...");
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
		memberService.memberInsert(memberVO);
		
		return "redirect:/";
	}
	
	//멤버 수정 화면
	@RequestMapping(value="/memberModify/{id:.+}")	// get 방식 대신 스프링에서 지원하는 방식 사용
	public String memberModify(@PathVariable String id, Model model) 
	{
		model.addAttribute("memberVO", memberService.getByMemberID(id));
		return "/member/memberModify";
	}
	
	//멤버 수정 처리 
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
	
	//멤버 삭제 처리 
	@RequestMapping(value="/memberDelete/{id:.+}")	// get 방식 대신 스프링에서 지원하는 방식 사용
	public String memberDelete(@PathVariable String id, Model model) 
	{
		if(memberService.getByMemberID(id) != null) {
			memberService.memberDelete(id);
		} else {
			
		}
		return "redirect:/";
	}
	
	//멤버리스트
	@RequestMapping(value="/memberList")
	public String memberList(Model model)
	{
		logger.info("memberList" + MemberController.this);
		List<MemberVO> alist = memberService.getMemberAll();
		model.addAttribute("memberVOS", alist);
		return "/member/memberList";
	}

	//멤버 아이디/비밀번호 찾기 페이지로 이동 
	@RequestMapping(value="/memberFind")
	public void memberFind(Model model) {	}
	
	//아이디 찾기
	@RequestMapping(value = "/memberFindID")
	public String findIdOK(@RequestParam("name") String name, @RequestParam("birth") String birth, 
		 										@RequestParam("phone") String phone, Model model) 
	{
	 model.addAttribute("id", memberService.findID(name, birth, phone));
	 return "/member/memberFindOK";
	}
		 
	//비밀번호 찾기
	@RequestMapping(value = "/memberFindPawd")
	public String findPasswdOK(@RequestParam("id") String id, @RequestParam("birth") String birth, 
		 										@RequestParam("phone") String phone, Model model) 
	{
	 model.addAttribute("passwd", memberService.findPswd(id, birth, phone));
	 return "/member/memberFindOK";
	}
	
}
