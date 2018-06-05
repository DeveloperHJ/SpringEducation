package com.kh.myapp.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.myapp.member.vo.MemberVO;


// Mybatis ������ ���� Ŭ����, ������ Ŭ���� ���� ���� �̸� ����
@Repository
public class MemberDAOImplXML implements MemberDAO {
	
	//�����̳ʷκ��� ����, myBatis���� DataSource�� �����ϴ� ����
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
