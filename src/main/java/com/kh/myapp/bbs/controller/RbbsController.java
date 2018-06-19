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

@RestController // ���ҽ�(������) ��ü�� ��ȯ�ϴµ� ���(JSON, XML, ���ڿ�) 
@Controller
@RequestMapping("/rest")
public class RbbsController {
	
	@Autowired
	@Qualifier("memberServiceImplXML")
	MemberService ms;
	
	@RequestMapping("/hello")	
	public String hello() {
		return "hello";	// RestContorller �� ���� �ÿ� hello.jsp�� ã���� �Ǿ��־� 404����
										// 								������ ��� hello ���ڿ� ��ȯ
	}
	
	// 406 ����.
	@ResponseBody
	@RequestMapping(value = "/mem/{id:.+}", method = RequestMethod.GET)
	public MemberVO mem(@PathVariable("id") String id) {	// �Ű����� @RequestParam String id : /rest/member?id=admin@kh.com
																													// @RequestMapping("/member/{id:.+}") && �Ű����� @PathVariable("id") : /rest/member/admin@kh.com
		MemberVO memberVO = null;
		System.out.println(id);
		memberVO = ms.getByMemberID(id);
		System.out.println(id);
		System.out.println(memberVO.toString());
		return memberVO;
	}
	
	// produces: �����ʿ��� ���������� ����, ������ ������ client���� ���� 
	// GET ����̸� �������� .json ���̰ų�, header���� accept key ���� xml�̳� json���� �ָ� ��. 
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public MemberVO member() {	// �Ű����� @RequestParam String id : /rest/member?id=admin@kh.com
																										// @RequestMapping("/member/{id:.+}") && �Ű����� @PathVariable("id") : /rest/member/admin@kh.com
		MemberVO memberVO = new MemberVO("test@test.com", "1234", "������1", "20180608", "01012345678", "W");
		return memberVO;
	}

	@RequestMapping(value = "/member/", method = RequestMethod.GET)
	public MemberVO member(@RequestParam String id) {	// �Ű����� @RequestParam String id : /rest/member?id=admin@kh.com
																										// @RequestMapping("/member/{id:.+}") && �Ű����� @PathVariable("id") : /rest/member/admin@kh.com
		MemberVO memberVO = null;
		memberVO = ms.getByMemberID(id);
		return memberVO;
	}
	
	// �迭 �� ��ü 
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	public List<MemberVO> memberList() {
		List<MemberVO> list = new ArrayList<>();
		
		MemberVO memberVO1 = new MemberVO("test1@test.com", "1234", "������1", "20180608", "01012345678", "W");
		list.add(memberVO1);
		
		MemberVO memberVO2 = new MemberVO("test2@test.com", "1234", "������2", "20180608", "01012345678", "W");
		list.add(memberVO2);
		
		return list;
	}
	
	// ��ü �� ��ü
	@RequestMapping("/memberMap")
	public Map<Integer, MemberVO> memberMap() {
		Map<Integer, MemberVO> map = new HashMap<>();
		
		for (int i = 0; i < 10; i++) {
			MemberVO mvo = new MemberVO();
			mvo.setId("restTest" + i + "@kh.com");
			mvo.setPasswd("1234");
			mvo.setName("�׽�Ʈ" + i);
			mvo.setPhone("010-1234-5678");
			
			map.put(i, mvo);
		}
		
		return map;
	}
	
	// �迭
	@RequestMapping("/array")
	public String[] array() {
		String[] str = new String[] {"������", "������", "���ο�", "�ӻ���"};
		
		return str;
	}
}
