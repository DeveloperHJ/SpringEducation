package com.kh.myapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.myapp.login.service.LoginService;
import com.kh.myapp.member.vo.MemberVO;



//�׽�Ʈ ȯ��
@RunWith(SpringJUnit4ClassRunner.class) // JUnit 4���� ���
//@ExtendWith(SpringExtension.class) // JUnit 5���� ���
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class LoginJDbcTemplateTest {

	private static final Logger logger = LoggerFactory.getLogger(LoginJDbcTemplateTest.class);
	
	@Autowired
	@Qualifier("loginServiceImplXML")
	LoginService loginService;	
	
	@Test
	public void getMember() 
	{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("admin2@kh.com");
		memberVO.setPasswd("1234");
		
		logger.info(loginService.getMember(memberVO).toString());
	}
}
