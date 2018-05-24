package com.kh.myapp;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.myapp.member.dao.MemberDAOimplJDBC;
import com.kh.myapp.member.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class JDdbcTemplateTest {

	private static final Logger logger = LoggerFactory.getLogger(JDdbcTemplateTest.class);

	private MemberDAOimplJDBC memberDAO = new MemberDAOimplJDBC();
	
	@Autowired
	private DataSource ds;
	
	@Test
	public void test() 
	{
		memberDAO.setDataSource(ds);
		MemberVO memberVO = new MemberVO("admin2@kh.com", "1234", "°ü¸®ÀÚ", "19920615", "01012345678", "W");
		logger.info(memberDAO.toString());
		
		memberDAO.insert(memberVO);
	}
	
/*	@Autowired
	DefaultListableBeanFactory df;
	
	@Test
	public void beans() 
	{
		for (String name : df.getBeanDefinitionNames()) {
			logger.info(name + "\t" + df.getBean(name).getClass().getName());
		}
	}*/

}
