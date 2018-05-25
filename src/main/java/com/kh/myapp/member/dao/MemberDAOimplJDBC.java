package com.kh.myapp.member.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
		MemberVO memberVO = new MemberVO();
		StringBuffer str = new StringBuffer();
		str.append("select * from member where id = ?");
		
		System.out.println("getMember");
		
		//query는 List타입이라 queryForObject 사용
		memberVO = (MemberVO)this.jdbcTemplate.queryForObject(str.toString(), new Object[] { id },
								new BeanPropertyRowMapper<>(MemberVO.class));
		
		System.out.println(memberVO.toString());
		
		return memberVO;
	}

	@Override
	public ArrayList<MemberVO> getMemberList() {
		System.out.println("list 호출");
		ArrayList<MemberVO> alist = new ArrayList<>();
		StringBuffer str = new StringBuffer();
		str.append("select * from member");
		
		alist = (ArrayList<MemberVO>)this.jdbcTemplate.query(str.toString(), 
							new BeanPropertyRowMapper<MemberVO>(MemberVO.class));
		
		return alist;
	}

	@Override
	public void update(MemberVO memberVO) {
		StringBuffer str = new StringBuffer();
		str.append("update member set passwd = ?, name = ?, birth = ?, phone = ?, gender = ? ")
			 .append("where id = ?");
		
		this.jdbcTemplate.update(str.toString(), 
				memberVO.getPasswd(), memberVO.getName(), memberVO.getBirth(), 
				memberVO.getPhone(), memberVO.getGender(), memberVO.getId());
	}

	@Override
	public void delete(String id) {
		this.jdbcTemplate.update("delete from member where id = ?", id);
	}

}
