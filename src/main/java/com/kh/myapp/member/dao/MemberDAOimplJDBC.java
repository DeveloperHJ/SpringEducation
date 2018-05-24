package com.kh.myapp.member.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.myapp.member.vo.MemberVO;

/*
ID	VARCHAR2(30 BYTE)	No		1	회원아이디(이메일)
PASSWD	VARCHAR2(30 BYTE)	No		2	비밀번호
NAME	VARCHAR2(20 BYTE)	No		3	이름
BIRTH	CHAR(8 BYTE)	No		4	생년월일
PHONE	VARCHAR2(11 BYTE)	No		5	휴대폰번호
GENDER	CHAR(1 BYTE)	No		6	성별
CDATE	DATE	No	SYSDATE 	7	생성일
UDATE	DATE	No	SYSDATE 	8	수정일
*/

// 스프링에서 제공되는 JDBC
@Repository("memberDAO")
public class MemberDAOimplJDBC implements MemberDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void insert(MemberVO memberVO) {
		StringBuffer str = new StringBuffer();
		str.append("insert into member(id, passwd, name, birth, phone, gender) ")
			 .append("values (?, ?, ?, ?, ?, ?)");
		
		this.jdbcTemplate.update(str.toString(), 
				 memberVO.getId(), memberVO.getPasswd(), memberVO.getName(), 
				 memberVO.getBirth(), memberVO.getPhone(), memberVO.getGender());
	}

	@Override
	public MemberVO getMember(String id) {
		return null;
	}

	@Override
	public ArrayList<MemberVO> getMemberList() {
		return null;
	}

	@Override
	public void update(String id) {
	}

	@Override
	public void delete(String id) {
	}

}
