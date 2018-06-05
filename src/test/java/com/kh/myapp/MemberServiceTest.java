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

//Junit4 �������� Spring framework���� �׽�Ʈ�ϴ� ȯ���� �������ڴ�.
//@RunWith(SpringJUnit4ClassRunner.class)	
@ExtendWith(SpringExtension.class)
//���ؽ�Ʈ ȯ�������� root-context.xml�� �����ϰڴ�.
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
class MemberServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);

	//����Ÿ������ �ް�, ���� �����̳ʿ����� impl ���. 
	//���� Ŭ������ �ٲ���� ������Ÿ���� �ٲ��� �ʿ䰡 ����. 
	@Autowired
	@Qualifier("memberServiceImplXML")
	private MemberService memberService;
	
/*	//ȸ�����
	@Test
	public void list() 
	{
		List<MemberVO> list = memberService.getMemberAll();
		logger.info(list.toString());
	}*/
	
/*	//ȸ������
	@Test 
	public void join()
	{
		MemberVO memberVO = new MemberVO("admin6@admin.com", "1234", "������", "20180528", "01012345678", "W");
		memberService.memberInsert(memberVO);
	}*/
	
	//���̵� ã�� 
	@Test
	public void findID()
	{
		String id = memberService.findID("�����ڼ���", "19920615", "01012345678");
		logger.info(id);
	}
	
	@Test
	public void findPasswd()
	{
		String passwd = memberService.findPswd("admin@kh.com", "19920615", "01012345678");
		logger.info(passwd);
	}
}
