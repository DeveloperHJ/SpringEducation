package com.kh.myapp.login.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.myapp.member.vo.MemberVO;

@Repository
public class LoginDAOImplXML implements LoginDAO {
	
	//컨테이너로부터 주입, myBatis에서 DataSource에 접근하는 역할
	//SqlSessionTemplate	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public MemberVO getMember(MemberVO memberVO) {
		System.out.println("LoginDAOImplXML!!!!");
		MemberVO memVO = sqlSession.selectOne("getByMemID", memberVO);
		return memVO;
	}

}
