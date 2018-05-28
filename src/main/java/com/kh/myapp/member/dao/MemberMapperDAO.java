package com.kh.myapp.member.dao;

import java.util.ArrayList;

import com.kh.myapp.member.service.MemberService;
import com.kh.myapp.member.vo.MemberVO;

// Mybatis 연습을 위한 클래스
public class MemberMapperDAO implements MemberService {

	@Override
	public void memberInsert(MemberVO memberVO) {
	}

	@Override
	public MemberVO getByMemberID(String id) {
		return null;
	}

	@Override
	public ArrayList<MemberVO> getMemberAll() {
		return null;
	}

	@Override
	public void memberUpdate(MemberVO memberVO) {
	}

	@Override
	public void memberDelete(String id) {
	}

}
