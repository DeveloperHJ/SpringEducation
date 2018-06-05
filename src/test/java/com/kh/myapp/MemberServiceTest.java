package com.kh.myapp;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.myapp.member.service.MemberService;
import com.kh.myapp.member.vo.MemberVO;

import jdk.nashorn.internal.ir.annotations.Ignore;

//Junit4 버전에서 Spring framework에서 테스트하는 환경을 가져가겠다.
//@RunWith(SpringJUnit4ClassRunner.class)	
@ExtendWith(SpringExtension.class)
//컨텍스트 환경파일은 root-context.xml을 참조하겠다.
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
class MemberServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);

	//상위타입으로 받고, 실제 컨테이너에서는 impl 사용. 
	//구현 클래스가 바뀌더라도 데이터타입은 바꿔줄 필요가 없다. 
	@Autowired
	@Qualifier("memberServiceImplXML")
	private MemberService memberService;
	
/*	//회원목록
	@Test
	public void list() 
	{
		List<MemberVO> list = memberService.getMemberAll();
		logger.info(list.toString());
	}*/
	
/*	//회원가입
	@Test 
	public void join()
	{
		MemberVO memberVO = new MemberVO("admin6@admin.com", "1234", "관리자", "20180528", "01012345678", "W");
		memberService.memberInsert(memberVO);
	}*/
	
	//아이디 찾기 
	@Test
	public void findID()
	{
		String id = memberService.findID("관리자수정", "19920615", "01012345678");
		logger.info(id);
	}
	
	@Test
	public void findPasswd()
	{
		String passwd = memberService.findPswd("admin@kh.com", "19920615", "01012345678");
		logger.info(passwd);
	}
}
