package com.kh.myapp.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kh.myapp.bbs.dao.RbbsDAO;
import com.kh.myapp.bbs.dto.RbbsDTO;
import com.kh.myapp.util.RecordCriteria;

@Service
public class RbbsServiceImplXML implements RbbsService {

	@Autowired
	@Qualifier("rbbsDAOImplXML")
	RbbsDAO rs;
	
	@Override
	public void write(RbbsDTO rBbsdto) throws Exception {
		rs.write(rBbsdto);
	}

	@Override
	public List<RbbsDTO> list(int bNum) throws Exception {
		return rs.list(bNum);
	}

	@Override
	public List<RbbsDTO> list(int bNum, RecordCriteria recordCriteria) throws Exception {
		return rs.list(bNum, recordCriteria);
	}

	@Override
	public void update(RbbsDTO rBbsdto) throws Exception {
		rs.update(rBbsdto);
	}

	@Override
	public void delete(int rNum) throws Exception {
		rs.delete(rNum);
	}

	@Override
	public Integer replyTotalRec(int bNum) throws Exception {
		return rs.replyTotalRec(bNum);
	}

	@Override
	public RbbsDTO oriInform(int bNum) throws Exception {
		return rs.oriInform(bNum);
	}

	@Override
	public void reReply(RbbsDTO rbbsdto) throws Exception {
		rs.reReply(rbbsdto);
	}

	@Override
	public void updateStep(int rGroup, int rStep) throws Exception {
		rs.updateStep(rGroup, rStep);
	}

	@Override
	public void goodOrBad(int rNum, String goodOrBad) throws Exception {
		rs.goodOrBad(rNum, goodOrBad);
	}

}
