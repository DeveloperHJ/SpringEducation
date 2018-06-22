package com.kh.myapp.bbs.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kh.myapp.bbs.controller.BbsController;
import com.kh.myapp.bbs.dao.BbsDAO;
import com.kh.myapp.bbs.dto.BbsDTO;
import com.kh.myapp.util.FindCriteria;
import com.kh.myapp.util.PageCriteria;
import com.kh.myapp.util.RecordCriteria;

@Service
public class BbsServiceImplXML implements BbsService {

	private static final Logger logger = LoggerFactory.getLogger(BbsServiceImplXML.class);
	
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
	public List<BbsDTO> list(FindCriteria findCriteria) throws Exception {
		return bbsdao.list(findCriteria);
	}
	
	// Service단에서 해주는 가공 메서드
	@Override
	public void list(HttpServletRequest request) throws Exception {
		
		int reqPage = 0;
		
		// 요청페이지가 없으면 1페이지로 이동
		if (request.getParameter("reqPage") == null ||
				request.getParameter("reqPage") == "") {
			reqPage = 1;
		}else {
			reqPage = Integer.parseInt(request.getParameter("reqPage"));
		}
		
		// 검색유무조건에 따라 분기
		List<BbsDTO> list = null;
		PageCriteria pc = null;
		RecordCriteria rc = null;
		
		// 검색 관련 변수
		String searchType = request.getParameter("searchType");
		String keyword	= request.getParameter("keyword");
		
		if(keyword == null || keyword.trim().equals("")) {
			// 검색조건이 없는 경우
			rc = new RecordCriteria(reqPage, 10);		
			list = list(rc);		
			int totalRec = totalRec();
			pc = new PageCriteria(rc,totalRec);		
			
		}else {
			// 검색조건이 있는 경우
			rc = new FindCriteria(reqPage, 10, searchType, keyword);
			list = list((FindCriteria)rc);		
			int totalRec = searchTotalRec((FindCriteria)rc);
			pc = new PageCriteria(rc, totalRec);	
			
			logger.info(rc.toString());
			logger.info("검색된 전체 레코드 수 : " + totalRec);
			logger.info("검색 목록 수 : " + list.size());
			
			request.setAttribute("findCriteria", (FindCriteria)rc);			
		}	
				
		request.setAttribute("list", list);
		request.setAttribute("pageCriteria", pc);
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
	public int searchTotalRec(FindCriteria findCriteria) throws Exception {
		return bbsdao.searchTotalRec(findCriteria);
	}

}
