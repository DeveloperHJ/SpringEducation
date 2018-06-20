package com.kh.myapp.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DbConnTest {

		private static final Logger logger = LoggerFactory.getLogger(DbConnTest.class);
		
		@Autowired // root-context에 등록된 빈을 가져다 쓸 때 사용
		private DataSource ds;
		
		@Test
		public void testConnection() throws SQLException 
		{
			try(Connection conn = ds.getConnection()){
				logger.info(conn.toString());
				logger.info("연결성공");
			} catch (Exception e) {
				logger.info("연결오류");
				e.printStackTrace();
			}
		}
		
		
		@Autowired // 얘를 통해 메모리 올라감.
		private SqlSessionFactory sqlFactory;

		@Test 
		public void testSqlSessionFactiory()
			// root-context.xml에서 SqlSessionFactory 접속 테스트 
			// Factory 내 파일 : mybaties-config, mapper 
		{
			logger.info(sqlFactory.toString());
		}
		
		
		@Test
		public void testSqlSessionTemplate()
		{
			try(SqlSession session = sqlFactory.openSession()) {
				logger.info(session.toString());
			} catch(Exception e) {
				logger.info("SqlSession 가져오기 실패!");
				e.printStackTrace();
			}
		}
}
