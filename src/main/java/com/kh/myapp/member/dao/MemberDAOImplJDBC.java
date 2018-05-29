package com.kh.myapp.member.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.myapp.member.vo.MemberVO;

/*
ID	VARCHAR2(30 BYTE)	No		1	ȸ�����̵�(�̸���)
PASSWD	VARCHAR2(30 BYTE)	No		2	��й�ȣ
NAME	VARCHAR2(20 BYTE)	No		3	�̸�
BIRTH	CHAR(8 BYTE)	No		4	�������
PHONE	VARCHAR2(11 BYTE)	No		5	�޴�����ȣ
GENDER	CHAR(1 BYTE)	No		6	����
CDATE	DATE	No	SYSDATE 	7	������
UDATE	DATE	No	SYSDATE 	8	������
*/

// ���������� �����Ǵ� JDBC, ������ Ŭ������ 2���̱� ������ �̸� ����
@Repository
public class MemberDAOImplJDBC implements MemberDAO {

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
		
		//query�� ListŸ���̶� queryForObject ���
		//queryForObject�� ���� ������� 0�� �� error �߻��ϹǷ� try-catch�� ������.
		try {
			memberVO = (MemberVO)this.jdbcTemplate.queryForObject(str.toString(), new Object[] { id },
									new BeanPropertyRowMapper<>(MemberVO.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		return memberVO;
	}

	@Override
	public ArrayList<MemberVO> getMemberList() {
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
