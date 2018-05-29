package com.kh.myapp;

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


//�׽�Ʈ ȯ��
//@RunWith(SpringJUnit4ClassRunner.class) // JUnit 4���� ���
@ExtendWith(SpringExtension.class) // JUnit 5���� ���
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
class MybatisTest {
	private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);

	@Autowired
	@Qualifier("memberServiceImplXML")
	MemberService xml;
	
	@Test
	void test() {
		MemberVO memberVO = xml.getByMemberID("admin@kh.com");
		logger.info(memberVO.toString());
	}
}
