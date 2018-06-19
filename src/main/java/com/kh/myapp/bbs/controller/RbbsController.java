package com.kh.myapp.bbs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.myapp.member.service.MemberService;
import com.kh.myapp.member.vo.MemberVO;

@RestController // 리소스(데이터) 자체를 반환하는데 사용(JSON, XML, 문자열) 
@Controller
@RequestMapping("/rest")
public class RbbsController {
	
	@Autowired
	@Qualifier("memberServiceImplXML")
	MemberService ms;
	
	@RequestMapping("/hello")	
	public String hello() {
		return "hello";	// RestContorller 안 붙일 시에 hello.jsp를 찾도록 되어있어 404오류
										// 								존재할 경우 hello 문자열 반환
	}
	
	// 406 오류.
	@ResponseBody
	@RequestMapping(value = "/mem/{id:.+}", method = RequestMethod.GET)
	public MemberVO mem(@PathVariable("id") String id) {	// 매개변수 @RequestParam String id : /rest/member?id=admin@kh.com
																													// @RequestMapping("/member/{id:.+}") && 매개변수 @PathVariable("id") : /rest/member/admin@kh.com
		MemberVO memberVO = null;
		System.out.println(id);
		memberVO = ms.getByMemberID(id);
		System.out.println(id);
		System.out.println(memberVO.toString());
		return memberVO;
	}
	
	// produces: 서버쪽에서 데이터포맷 결정, 해주지 않으면 client에서 결정 
	// GET 방식이면 마지막에 .json 붙이거나, header에서 accept key 값을 xml이나 json으로 주면 됨. 
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public MemberVO member() {	// 매개변수 @RequestParam String id : /rest/member?id=admin@kh.com
																										// @RequestMapping("/member/{id:.+}") && 매개변수 @PathVariable("id") : /rest/member/admin@kh.com
		MemberVO memberVO = new MemberVO("test@test.com", "1234", "김현정1", "20180608", "01012345678", "W");
		return memberVO;
	}

	@RequestMapping(value = "/member/", method = RequestMethod.GET)
	public MemberVO member(@RequestParam String id) {	// 매개변수 @RequestParam String id : /rest/member?id=admin@kh.com
																										// @RequestMapping("/member/{id:.+}") && 매개변수 @PathVariable("id") : /rest/member/admin@kh.com
		MemberVO memberVO = null;
		memberVO = ms.getByMemberID(id);
		return memberVO;
	}
	
	// 배열 내 객체 
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	public List<MemberVO> memberList() {
		List<MemberVO> list = new ArrayList<>();
		
		MemberVO memberVO1 = new MemberVO("test1@test.com", "1234", "김현정1", "20180608", "01012345678", "W");
		list.add(memberVO1);
		
		MemberVO memberVO2 = new MemberVO("test2@test.com", "1234", "김현정2", "20180608", "01012345678", "W");
		list.add(memberVO2);
		
		return list;
	}
	
	// 객체 내 객체
	@RequestMapping("/memberMap")
	public Map<Integer, MemberVO> memberMap() {
		Map<Integer, MemberVO> map = new HashMap<>();
		
		for (int i = 0; i < 10; i++) {
			MemberVO mvo = new MemberVO();
			mvo.setId("restTest" + i + "@kh.com");
			mvo.setPasswd("1234");
			mvo.setName("테스트" + i);
			mvo.setPhone("010-1234-5678");
			
			map.put(i, mvo);
		}
		
		return map;
	}
	
	// 배열
	@RequestMapping("/array")
	public String[] array() {
		String[] str = new String[] {"김현정", "이지은", "차민욱", "임상현"};
		
		return str;
	}
}
