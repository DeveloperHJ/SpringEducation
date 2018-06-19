package com.kh.myapp.bbs.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kh.myapp.bbs.dao.RbbsDAO;
import com.kh.myapp.bbs.dto.RbbsDTO;

@Service
public class RbbsServiceImplXML implements RbbsService {

	@Autowired
	@Qualifier("rbbsDAOImplXML")
	RbbsDAO rs;
	
	@Override
	public void write(RbbsDTO rBbsdto) {
	}

	@Override
	public List<RbbsDTO> list(int bNum) {
		return null;
	}

	@Override
	public List<RbbsDTO> list(int bNum, int startRecord, int endRecord) {
		return null;
	}

	@Override
	public RbbsDTO view(int rNum) {
		return null;
	}

	@Override
	public void update(int rNum, RbbsDTO rBbsdto) {
	}

	@Override
	public void delete(int rNum) {
	}

	@Override
	public void replyTotalRec(int bNum) {
	}

	@Override
	public List<RbbsDTO> list(int startRecord, int endRecord, String searchType, String keyword) {
		return null;
	}

	@Override
	public void searchTotalRec(String searchType, String keyword) {
	}

	@Override
	public RbbsDTO oriInform(String bNum) {
		return null;
	}

	@Override
	public void reReply(String oriRNum, RbbsDTO rbbsdto) {
	}

	@Override
	public void updateStep(int rGroup, int rStep) {
	}

	@Override
	public void goodOrBad(int rNum, String goodOrBad) {
	}

}
