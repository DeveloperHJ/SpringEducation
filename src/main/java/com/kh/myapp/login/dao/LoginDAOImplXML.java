package com.kh.myapp.login.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.myapp.login.vo.LoginVO;
import com.kh.myapp.member.vo.MemberVO;

@Repository
public class LoginDAOImplXML implements LoginDAO {
	
	//�����̳ʷκ��� ����, myBatis���� DataSource�� �����ϴ� ����
	//SqlSessionTemplate	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public MemberVO getMember(LoginVO loginVO) {
		MemberVO memVO = sqlSession.selectOne("getByMemID", loginVO);
		return memVO;
	}

}
