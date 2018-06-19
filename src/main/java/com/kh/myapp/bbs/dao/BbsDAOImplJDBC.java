package com.kh.myapp.bbs.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kh.myapp.bbs.dto.BbsDTO;
import com.kh.myapp.util.FindCriteria;
import com.kh.myapp.util.PageCriteria;
import com.kh.myapp.util.RecordCriteria;

@Repository
public class BbsDAOImplJDBC implements BbsDAO {

	@Override
	public void write(BbsDTO bbsdto) {
	}

	@Override
	public List<BbsDTO> list(RecordCriteria recordCriteria) {
		return null;
	}

	@Override
	public BbsDTO view(int bNum) {
		return null;
	}

	@Override
	public void updateHit(int bNum) {
	}

	@Override
	public void update(BbsDTO bbsdto) {
	}

	@Override
	public void delete(int bNum) {
	}

	@Override
	public BbsDTO replyView(int bNum) {
		return null;
	}

	@Override
	public void reply(BbsDTO bbsdto) {
	}
	
	@Override
	public void updateStep(BbsDTO bbsdto) throws Exception {
	}

	@Override
	public int totalRec() {
		return 0;
	}

	@Override
	public List<BbsDTO> list(FindCriteria findCriteria) {
		return null;
	}

	@Override
	public int searchTotalRec(FindCriteria findCriteria) {
		return 0;
	}

}
