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
	public List<RbbsDTO> list(Integer bnum) throws Exception {
		return sqlSession.selectList(NAMESPACE + "listAll", bnum);
	}

	@Override
	public List<RbbsDTO> list(Integer bnum, RecordCriteria recordCriteria) throws Exception {
		
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
	public void delete(Integer rnum) throws Exception {
		sqlSession.delete(NAMESPACE + "delete", rnum);
	}

	@Override
	public Integer replyTotalRec(Integer bnum) {
		return sqlSession.selectOne(NAMESPACE + "replyTotalRec", bnum);
	}

	@Override
	public RbbsDTO oriInform(Integer rnum) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "replyView", rnum);
	}

	@Override
	public void reReply(RbbsDTO rbbsdto) throws Exception {
		System.out.println("reReply");
		
		// 원댓글 정보 가져오기 
		RbbsDTO rbbsOrgDTO = oriInform(rbbsdto.getRnum());
		
		rbbsdto.setBnum(rbbsOrgDTO.getBnum());
		rbbsdto.setRgroup(rbbsOrgDTO.getRgroup());
		rbbsdto.setRstep(rbbsOrgDTO.getRstep());
		rbbsdto.setRindent(rbbsOrgDTO.getRindent());
		
		// 이전 댓글 step 업데이트 
		updateStep(rbbsOrgDTO.getRgroup(), rbbsOrgDTO.getRstep());
		
		System.out.println("rbbsOrgDTO : " + rbbsOrgDTO.toString());
		System.out.println("rbbsdto : " + rbbsdto.toString());
		
		
		sqlSession.insert(NAMESPACE + "reply", rbbsdto);
	}

	@Override
	public void updateStep(Integer rGroup, Integer rStep) throws Exception {
		System.out.println("updateStep!");
		
		Map<String, Object> map = new HashMap<>();
		map.put("rgroup", rGroup);
		map.put("rstep", rStep);
		
		sqlSession.update(NAMESPACE + "updateStep", map);
	}

	@Override
	public void goodOrBad(Integer rnum, String goodOrBad) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("rnum", rnum);
		map.put("goodOrBad", goodOrBad);
		
		sqlSession.update(NAMESPACE + "goodOrBad", map);
	}

}
