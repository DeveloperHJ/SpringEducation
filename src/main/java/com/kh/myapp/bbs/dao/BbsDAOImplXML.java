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
	
	@Autowired
	private SqlSession sqlSession;

	
	@Override
	public void write(BbsDTO bbsdto) throws Exception {
		sqlSession.insert("insert", bbsdto);
	}

	@Override
	public List<BbsDTO> list(RecordCriteria recordCriteria) throws Exception {
		return sqlSession.selectList("listPageCri", recordCriteria);
	}

	@Override
	public BbsDTO view(int bNum) throws Exception {
		return sqlSession.selectOne("view", bNum);
	}

	@Override
	public void updateHit(int bNum) throws Exception {
	}

	@Override
	public void update(BbsDTO bbsdto) throws Exception {
		sqlSession.update("update", bbsdto);
	}

	@Override
	public void delete(int bNum) throws Exception {
		sqlSession.delete("delete", bNum);
	}

	
	@Override
	public BbsDTO replyView(int bNum) throws Exception {
		return sqlSession.selectOne("replyView", bNum);
	}

	@Override
	public void reply(BbsDTO bbsdto) throws Exception {
		System.out.println("BbsDAOImplXML reply(BbsDTO bbsdto)");
		sqlSession.insert("reply", bbsdto);
	}


	@Override
	public int totalRec() throws Exception {
		return sqlSession.selectOne("totalRec");
	}

	
	@Override
	public List<BbsDTO> list(FindCriteria findCriteria) throws Exception {
		return sqlSession.selectList("listFindCri", findCriteria);
	}

	@Override
	public int searchTotalRec(FindCriteria findCriteria) throws Exception {
		return sqlSession.selectOne("searchTotalRec", findCriteria);
	}

}
