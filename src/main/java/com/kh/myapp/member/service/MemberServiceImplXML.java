package com.kh.myapp.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kh.myapp.member.dao.MemberDAO;
import com.kh.myapp.member.vo.MemberVO;

// 서비스 메서드를 Controller에서 사용 
@Service
public class MemberServiceImplXML implements MemberService {
	
	@Autowired
	@Qualifier("memberDAOImplXML")
	MemberDAO memberDAO;

	@Override
	public void memberInsert(MemberVO memberVO) {
		memberDAO.insert(memberVO);
	}

	@Override
	public MemberVO getByMemberID(String id) {
		return memberDAO.getMember(id);
	}

	@Override
	public List<MemberVO> getMemberAll() {
		return memberDAO.getMemberList();
	}

	@Override
	public void memberUpdate(MemberVO memberVO) {
		memberDAO.update(memberVO);
	}

	@Override
	public void memberDelete(String id) {
		memberDAO.delete(id);
	}

	@Override
	public String findID(String name, String birth, String phone) {
		return memberDAO.findID(name, birth, phone);
	}

	@Override
	public String findPswd(String id, String birth, String phone) {
		return memberDAO.findPswd(id, birth, phone);
	}

}
