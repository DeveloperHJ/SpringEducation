package com.kh.myapp.bbs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.myapp.bbs.dto.BbsDTO;
import com.kh.myapp.member.dao.MemberDAO;
import com.kh.myapp.util.FindCriteria;
import com.kh.myapp.util.PageCriteria;
import com.kh.myapp.util.RecordCriteria;

@Repository
public class BbsDAOImplXML implements BbsDAO {
	
	private static final String NAMESPACE = "com.kh.myapp.bbs.dao.BbsDAO.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void write(BbsDTO bbsdto) throws Exception {
		sqlSession.insert(NAMESPACE + "insert", bbsdto);
	}

	@Override
	public List<BbsDTO> list(RecordCriteria recordCriteria) throws Exception {
		return sqlSession.selectList(NAMESPACE + "listPageCri", recordCriteria);
	}

	@Override
	public BbsDTO view(int bNum) throws Exception {
		updateHit(bNum);
		return sqlSession.selectOne(NAMESPACE + "view", bNum);
	}

	@Override
	public void updateHit(int bNum) throws Exception {
		System.out.println("updateHit!");
		sqlSession.update(NAMESPACE + "updateHit", bNum);
	}

	@Override
	public void update(BbsDTO bbsdto) throws Exception {
		sqlSession.update(NAMESPACE + "update", bbsdto);
	}

	@Override
	public void delete(int bNum) throws Exception {
		sqlSession.delete(NAMESPACE + "delete", bNum);
	}

	
	@Override
	public BbsDTO replyView(int bNum) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "replyView", bNum);
	}

	@Override
	public void reply(BbsDTO bbsdto) throws Exception {
		updateStep(bbsdto);
		
		sqlSession.insert(NAMESPACE + "reply", bbsdto);
	}

	@Override
	public void updateStep(BbsDTO bbsdto) throws Exception {
		System.out.println("updateStep" + bbsdto.toString());
		sqlSession.update(NAMESPACE + "updateStep", bbsdto);
	}

	@Override
	public int totalRec() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "totalRec");
	}

	
	@Override
	public List<BbsDTO> list(FindCriteria findCriteria) throws Exception {
		return sqlSession.selectList(NAMESPACE + "listFindCri", findCriteria);
	}

	@Override
	public int searchTotalRec(FindCriteria findCriteria) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "searchTotalRec", findCriteria);
	}


}
