package com.kh.myapp.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kh.myapp.bbs.dao.BbsDAO;
import com.kh.myapp.bbs.dto.BbsDTO;
import com.kh.myapp.util.FindCriteria;
import com.kh.myapp.util.PageCriteria;
import com.kh.myapp.util.RecordCriteria;

@Service
public class BbsServiceImplXML implements BbsService {

	@Autowired
	@Qualifier("bbsDAOImplXML")
	BbsDAO bbsdao;
	
	@Override
	public void write(BbsDTO bbsdto) throws Exception {
		bbsdao.write(bbsdto);
	}

	@Override
	public List<BbsDTO> list(RecordCriteria recordCriteria) throws Exception {
		return bbsdao.list(recordCriteria);
	}

	@Override
	public BbsDTO view(int bNum) throws Exception {
		return bbsdao.view(bNum);
	}

	@Override
	public void updateHit(int bNum) throws Exception {
	}

	@Override
	public void update(BbsDTO bbsdto) throws Exception {
		bbsdao.update(bbsdto);
	}

	@Override
	public void delete(int bNum) throws Exception {
		bbsdao.delete(bNum);
	}

	@Override
	public BbsDTO replyView(int bNum) throws Exception {
		return bbsdao.replyView(bNum);
	}

	@Override
	public void reply(BbsDTO bbsdto) throws Exception {
		bbsdao.reply(bbsdto);
	}

	@Override
	public int totalRec() throws Exception {
		return bbsdao.totalRec();
	}

	@Override
	public List<BbsDTO> list(FindCriteria findCriteria) throws Exception {
		return bbsdao.list(findCriteria);
	}

	@Override
	public int searchTotalRec(FindCriteria findCriteria) throws Exception {
		return bbsdao.searchTotalRec(findCriteria);
	}

}
