package com.kh.myapp.bbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kh.myapp.bbs.dao.BbsDAO;
import com.kh.myapp.bbs.dto.BbsDTO;
import com.kh.myapp.bbs.service.BbsService;
import com.kh.myapp.util.FindCriteria;
import com.kh.myapp.util.PageCriteria;
import com.kh.myapp.util.RecordCriteria;

@Controller
@RequestMapping("/bbs")
public class BbsController {

	private static final Logger logger = LoggerFactory.getLogger(BbsController.class);
	
	@Autowired
	@Qualifier("bbsServiceImplXML")
//	@Qualifier("bbsDAOImplXML")
	private BbsService bs;
	
	//게시글 작성 페이지
	@RequestMapping(value="/write", method=GET)
	public void writeGet(BbsDTO bbsdto, Model model) throws Exception 
	{
		logger.info("write GET...");
	}

	//게시글 작성 로직
	@RequestMapping(value="/write", method=POST)
	public String writePost(BbsDTO bbsDTO) throws Exception 
	{
		logger.info("write POST...");
		logger.info(bbsDTO.toString());
		
		bs.write(bbsDTO);
		
		return "redirect:/bbs/list";	//글 등록 후 목록으로 이동 
	}
	
	//게시글 목록
	@RequestMapping(value = "/list", method = GET)
	public void list(HttpServletRequest request, Model model) throws Exception 
	{
		logger.info("list GET..");
		
		int reqPage = 0;
		
		// 요청페이지가 없으면 1페이지로 이동
		if (request.getParameter("reqPage") == null ||
				request.getParameter("reqPage") == "") {
			reqPage = 1;
		}else {
			reqPage = Integer.parseInt(request.getParameter("reqPage"));
		}
		
		// 검색유무조건에 따라 분기
		String searchType = request.getParameter("searchType");
		String keyword	= request.getParameter("keyword");
		

		List<BbsDTO> list = null;
		PageCriteria pc = null;
		RecordCriteria rc = null;
		
		if(keyword == null || keyword.trim().equals("")) {
			// 검색조건이 없는 경우
			rc = new RecordCriteria(reqPage, 10);		
			list = bs.list(rc);		
			int totalRec = bs.totalRec();
			pc = new PageCriteria(rc,totalRec);		
			
		}else {
			// 검색조건이 있는 경우
			rc = new FindCriteria(reqPage, 10, searchType, keyword);
			list = bs.list(rc);		
			int totalRec = bs.searchTotalRec((FindCriteria)rc);
			pc = new PageCriteria(rc,totalRec);	
			
			request.setAttribute("findCriteria", (FindCriteria)rc);			
		}	
				
		request.setAttribute("list", list);
		request.setAttribute("pageCriteria", pc);
	} 
	
	//게시글 보기
	@RequestMapping(value="/view", method=GET)
	public void view(@RequestParam("bNum") int bNum, Model model) throws Exception
	{
		model.addAttribute("view", bs.view(bNum));
	}
	
	//답글 작성 페이지
	@RequestMapping(value="/replyForm", method=GET)
	public void replyform(@RequestParam("bNum") int bNum, BbsDTO bbsdto, Model model)
	{
		model.addAttribute("bNum", bNum);
		logger.info("답글작성폼");
	}
	
	//답글 등록
	@RequestMapping(value="/reply", method=POST)
	public String reply(BbsDTO bbsdto, Model model) throws Exception 
	{
		logger.info("답글등록" + bbsdto.toString());
		bs.reply(bbsdto);
		return "redirect:/bbs/list";
	}
	
	//게시글 삭제 
	@RequestMapping(value="/delete", method=GET)
	public String delete(@RequestParam("bNum") int bNum, Model model)	throws Exception
	{
		logger.info("게시글삭제: " + bNum);
		bs.delete(bNum);
		return "redirect:/bbs/list";
	}
	
	//게시글 수정 
	@RequestMapping(value="/modify", method=GET)
	public String modify(@RequestParam("BNum") int bNum, BbsDTO bbsdto, Model model) throws Exception
	{
		logger.info("게시글수정: " + bNum);
		bs.update(bbsdto);
		model.addAttribute("view", bbsdto);
		return "redirect:/bbs/view?bNum="+bNum;
	}
}
