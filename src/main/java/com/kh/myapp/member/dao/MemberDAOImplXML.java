package com.kh.myapp.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.myapp.member.vo.MemberVO;


// Mybatis 연습을 위한 클래스, 구현한 클래스 구분 위해 이름 지정
@Repository
public class MemberDAOImplXML implements MemberDAO {
	
	//컨테이너로부터 주입, myBatis에서 DataSource에 접근하는 역할
	//SqlSessionTemplate
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(MemberVO memberVO) {
		sqlSession.insert("memberInsert", memberVO);
	}

	@Override
	public MemberVO getMember(String id) {
		MemberVO memberVO = sqlSession.selectOne("getByMemberID", id);
		return memberVO;
	}

	@Override
	public List<MemberVO> getMemberList() {
		List<MemberVO> list = sqlSession.selectList("getMemberAll");
		return list;
	}

	@Override
	public void update(MemberVO memberVO) {
		sqlSession.update("memberUpdate", memberVO);
	}

	@Override
	public void delete(String id) {
		sqlSession.delete("memberDelete", id);
	}

	@Override
	public String findID(String name, String birth, String phone) {
		return sqlSession.getMapper(MemberDAO.class).findID(name, birth, phone);
	}

	@Override
	public String findPswd(String id, String birth, String phone) {
		return sqlSession.getMapper(MemberDAO.class).findPswd(id, birth, phone);
	}
}
