package com.kh.myapp.login.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.myapp.login.vo.LoginVO;
import com.kh.myapp.member.vo.MemberVO;

@Repository
public class LoginDAOImplJDBC implements LoginDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/*
	 * JdbcTemplate 객체가 root-context.xml에 빈으로 등록되어 주석처리 됨. 
	 * 
	 * @Autowired public void setDataSource(DataSource dataSource) {
	 * 	this.jdbcTemplate = new JdbcTemplate(dataSource); }
	 */
	
	@Override
	public MemberVO getMember(LoginVO loginVO) {
		MemberVO memVO;
		StringBuffer str = new StringBuffer();
		str.append("select * from member where id = ? and passwd = ?");
		
		//query는 List타입이라 queryForObject 사용
		memVO = (MemberVO)this.jdbcTemplate.queryForObject(str.toString(), 
						new Object[] { loginVO.getId(), loginVO.getPasswd() }, new BeanPropertyRowMapper<>(MemberVO.class));
		
		return memVO;
	}

}
