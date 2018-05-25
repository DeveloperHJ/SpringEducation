package com.kh.myapp;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.myapp.member.service.MemberService;
import com.kh.myapp.member.vo.MemberVO;

//Junit4 �������� Spring framework���� �׽�Ʈ�ϴ� ȯ���� �������ڴ�.
@RunWith(SpringJUnit4ClassRunner.class)	
//���ؽ�Ʈ ȯ�������� root-context.xml�� �����ϰڴ�.
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})	
class MemberServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);

	//����Ÿ������ �ް�, ���� �����̳ʿ����� impl ���. 
	//���� Ŭ������ �ٲ���� ������Ÿ���� �ٲ��� �ʿ䰡 ����. 
	@Autowired
	@Qualifier("memberServiceimpl")
	private MemberService memberService;
	
	//ȸ�����
	@Test
	public void list() 
	{
		ArrayList<MemberVO> alist;
		alist = memberService.getMemberAll();
		logger.info(alist.toString());
	}
}
