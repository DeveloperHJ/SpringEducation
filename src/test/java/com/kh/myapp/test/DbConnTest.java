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
		
		@Autowired // root-context�� ��ϵ� ���� ������ �� �� ���
		private DataSource ds;
		
		@Test
		public void testConnection() throws SQLException 
		{
			try(Connection conn = ds.getConnection()){
				logger.info(conn.toString());
				logger.info("���Ἲ��");
			} catch (Exception e) {
				logger.info("�������");
				e.printStackTrace();
			}
		}
		
		
		@Autowired // �긦 ���� �޸� �ö�.
		private SqlSessionFactory sqlFactory;

		@Test 
		public void testSqlSessionFactiory()
			// root-context.xml���� SqlSessionFactory ���� �׽�Ʈ 
			// Factory �� ���� : mybaties-config, mapper 
		{
			logger.info(sqlFactory.toString());
		}
		
		
		@Test
		public void testSqlSessionTemplate()
		{
			try(SqlSession session = sqlFactory.openSession()) {
				logger.info(session.toString());
			} catch(Exception e) {
				logger.info("SqlSession �������� ����!");
				e.printStackTrace();
			}
		}
}
