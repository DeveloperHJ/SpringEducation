package com.kh.myapp.login.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.myapp.member.vo.MemberVO;

@Repository
public class LoginDAOImplJDBC implements LoginDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/*
	 * JdbcTemplate ��ü�� root-context.xml�� ������ ��ϵǾ� �ּ�ó�� ��. 
	 * 
	 * @Autowired public void setDataSource(DataSource dataSource) {
	 * 	this.jdbcTemplate = new JdbcTemplate(dataSource); }
	 */
	
	@Override
	public MemberVO getMember(MemberVO memberVO) {
		MemberVO memVO;
		StringBuffer str = new StringBuffer();
		str.append("select * from member where id = ? and passwd = ?");
		
		//query�� ListŸ���̶� queryForObject ���
		memVO = (MemberVO)this.jdbcTemplate.queryForObject(str.toString(), 
						new Object[] { memberVO.getId(), memberVO.getPasswd() }, new BeanPropertyRowMapper<>(MemberVO.class));
		
		return memVO;
	}

}
