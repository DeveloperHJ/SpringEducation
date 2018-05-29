package com.kh.myapp;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.myapp.member.dao.MemberDAO;
import com.kh.myapp.member.vo.MemberVO;


//�׽�Ʈ ȯ��
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class JDdbcTemplateTest {

	private static final Logger logger = LoggerFactory.getLogger(JDdbcTemplateTest.class);

	@Autowired
	private DataSource dataSource;
	
	@Autowired	// impl�� �������� �ʿ� ���� DAO ȣ������ �� �ֵ��� ������̼� 
	@Qualifier("memberServiceImpl")	// ���� Ÿ���� �������� ��� ������ �߱� ������ �� id�� ���� ���� �����´�.
	private MemberDAO memberDAO;	
	
	//ȸ�����
	@Test @Ignore
	public void insert() 
	{
		MemberVO memberVO = new MemberVO("admin3@kh.com", "1234", "������", "19920615", "01012345678", "W");
		logger.info(memberDAO.toString());
		
		memberDAO.insert(memberVO);
	}
	
	//ȸ������
	@Test @Ignore
	public void update()
	{
		MemberVO memberVO = new MemberVO("admin3@kh.com", "123", "������", "19920615", "01011111111", "W");
		memberDAO.update(memberVO);
	}
	
	//ȸ������
	@Test @Ignore
	public void delete()
	{
		memberDAO.delete("admin3@kh.com");
	}
	
	//ȸ�����
	@Test
	public void list() 
	{
		List<MemberVO> alist = memberDAO.getMemberList();
		logger.info(alist.toString());
	}
	
	@Test 
	public void getMember() 
	{
		MemberVO memverVO = memberDAO.getMember("admin@kh.com");
		logger.info(memverVO.toString());
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
