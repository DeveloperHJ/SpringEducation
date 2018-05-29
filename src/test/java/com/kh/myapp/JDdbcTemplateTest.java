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


//테스트 환경
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class JDdbcTemplateTest {

	private static final Logger logger = LoggerFactory.getLogger(JDdbcTemplateTest.class);

	@Autowired
	private DataSource dataSource;
	
	@Autowired	// impl로 생성해줄 필요 없이 DAO 호출해줄 수 있도록 어노테이션 
	@Qualifier("memberServiceImpl")	// 같은 타입이 여러개일 경우 오류가 뜨기 때문에 이 id를 가진 것을 가져온다.
	private MemberDAO memberDAO;	
	
	//회원등록
	@Test @Ignore
	public void insert() 
	{
		MemberVO memberVO = new MemberVO("admin3@kh.com", "1234", "관리자", "19920615", "01012345678", "W");
		logger.info(memberDAO.toString());
		
		memberDAO.insert(memberVO);
	}
	
	//회원수정
	@Test @Ignore
	public void update()
	{
		MemberVO memberVO = new MemberVO("admin3@kh.com", "123", "수정용", "19920615", "01011111111", "W");
		memberDAO.update(memberVO);
	}
	
	//회원수정
	@Test @Ignore
	public void delete()
	{
		memberDAO.delete("admin3@kh.com");
	}
	
	//회원목록
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
	
	// 빈 등록정보 출력
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
