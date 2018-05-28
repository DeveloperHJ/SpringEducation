package com.kh.myapp;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.myapp.member.service.MemberService;
import com.kh.myapp.member.vo.MemberVO;

//Junit4 버전에서 Spring framework에서 테스트하는 환경을 가져가겠다.
@RunWith(SpringJUnit4ClassRunner.class)	

//컨텍스트 환경파일은 root-context.xml을 참조하겠다.
/*@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})*/
class MemberServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);

	//상위타입으로 받고, 실제 컨테이너에서는 impl 사용. 
	//구현 클래스가 바뀌더라도 데이터타입은 바꿔줄 필요가 없다. 
	@Autowired
	@Qualifier("memberServiceImpl")
	private MemberService memberService;
	
	//회원목록
	@Test
	public void list() 
	{
		ArrayList<MemberVO> alist;
		alist = memberService.getMemberAll();
		logger.info(alist.toString());
	}
	
/*	//회원가입
	@Test
	public void join()
	{
		MemberVO memberVO = new MemberVO("admin5@admin.com", "1234", "관리자", "20180528", "01012345678", "W");
		memberService.memberInsert(memberVO);
	}*/
}
