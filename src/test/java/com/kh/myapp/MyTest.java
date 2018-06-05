package com.kh.myapp;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.myapp.member.vo.MemberVO;

import jdk.nashorn.internal.ir.annotations.Ignore;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/test.xml"})
class MyTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MyTest.class);
/*	
	@Autowired
	private DataSource ds;

	@Test @Ignore
	void test() {
		try(Connection conn = ds.getConnection()) {
			logger.info(conn.toString());
			logger.info("연결성공");
		} catch (Exception e) {
			logger.info("연결오류");
			e.printStackTrace();
		}
	}
	*/
	
	@Autowired
	@Qualifier("memVO")
	private MemberVO memberVO;
	
	@Test
	void memberVO() {
		logger.info(memberVO.toString());
	}
}
