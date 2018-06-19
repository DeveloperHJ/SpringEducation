package com.kh.myapp.bbs.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.myapp.bbs.dto.RbbsDTO;
import com.kh.myapp.util.RecordCriteria;

@Repository
public class RbbsDAOImplXML implements RbbsDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.kh.myapp.bbs.dao.RbbsDAO.";
	
	@Override
	public void write(RbbsDTO rBbsdto) throws Exception {
		sqlSession.insert(NAMESPACE + "write", rBbsdto);
	}

	@Override
	public List<RbbsDTO> list(int bnum) throws Exception {
		return sqlSession.selectList(NAMESPACE + "listAll", bnum);
	}

	@Override
	public List<RbbsDTO> list(int bnum, RecordCriteria recordCriteria) throws Exception {
		
		Map<String, Object> map = new HashMap<>();
		map.put("bnum", bnum);
		map.put("recordCriteria", recordCriteria);
		
		return sqlSession.selectList(NAMESPACE + "list", map);
	}

	@Override
	public void update(RbbsDTO rBbsdto) throws Exception {
		sqlSession.update(NAMESPACE + "update", rBbsdto);
	}

	@Override
	public void delete(int rnum) throws Exception {
		sqlSession.delete(NAMESPACE + "delete", rnum);
	}

	@Override
	public Integer replyTotalRec(int bnum) {
		return sqlSession.selectOne(NAMESPACE + "replyTotalRec", bnum);
	}

	@Override
	public RbbsDTO oriInform(int rnum) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "replyView", rnum);
	}

	@Override
	public void reReply(RbbsDTO rbbsdto) throws Exception {
		// 원댓글 정보 가져오기 
		RbbsDTO rbbsOrgDTO = oriInform(rbbsdto.getRnum());
		
		// 이전 댓글 step 업데이트 
		updateStep(rbbsOrgDTO.getRgroup(), rbbsOrgDTO.getRstep());
		
		sqlSession.insert(NAMESPACE + "reply", rbbsdto);
	}

	@Override
	public void updateStep(int rGroup, int rStep) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("rgroup", rGroup);
		map.put("rstep", rStep);
		
		sqlSession.update(NAMESPACE + "updateStep", map);
	}

	@Override
	public void goodOrBad(int rNum, String goodOrBad) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("rnum", rNum);
		map.put("goodOrBad", goodOrBad);
		
		sqlSession.update(NAMESPACE + "update", map);
	}

}
