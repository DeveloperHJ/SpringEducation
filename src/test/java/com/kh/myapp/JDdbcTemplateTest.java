package com.kh.myapp;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.myapp.member.dao.MemberDAO;
import com.kh.myapp.member.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class JDdbcTemplateTest {

	private static final Logger logger = LoggerFactory.getLogger(JDdbcTemplateTest.class);

	@Autowired
	private DataSource ds;
	
	@Autowired	// impl�� �������� �ʿ� ���� DAO ȣ������ �� �ֵ��� ������̼� 
	private MemberDAO memberDAO;	
	
	@Test
	public void test() 
	{
		MemberVO memberVO = new MemberVO("admin3@kh.com", "1234", "������", "19920615", "01012345678", "W");
		logger.info(memberDAO.toString());
		
		memberDAO.insert(memberVO);
	}
	
	// �� ������� ���
	@Autowired
	DefaultListableBeanFactory df;
	
	@Test
	public void beans() 
	{
		for (String name : df.getBeanDefinitionNames()) {
			logger.info(name + "\t" + df.getBean(name).getClass().getName());
		}
	}

}
