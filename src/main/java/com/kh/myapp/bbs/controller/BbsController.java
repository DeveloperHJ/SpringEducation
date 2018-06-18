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
	
	//�Խñ� �ۼ� ������
	@RequestMapping(value="/write", method=GET)
	public void writeGet(BbsDTO bbsdto, Model model) throws Exception 
	{
		logger.info("write GET...");
	}

	//�Խñ� �ۼ� ����
	@RequestMapping(value="/write", method=POST)
	public String writePost(BbsDTO bbsDTO) throws Exception 
	{
		logger.info("write POST...");
		logger.info(bbsDTO.toString());
		
		bs.write(bbsDTO);
		
		return "redirect:/bbs/list";	//�� ��� �� ������� �̵� 
	}
	
	//�Խñ� ���
	@RequestMapping("/list")
	public void list(Model model) throws Exception 
	{
		RecordCriteria recordCriteria = new RecordCriteria(1, 10);
		PageCriteria pageCriteria = new PageCriteria(recordCriteria, bs.totalRec());
		List<BbsDTO> list = bs.list(recordCriteria);
		
		model.addAttribute("list", list);
		model.addAttribute("pageCriteria", pageCriteria);
	}
	
	//�Խù� �˻�
	@RequestMapping(value="/searchList", method=GET)
	public String list(@RequestParam("searchType") String searchType, @RequestParam("keyword") String keyword, 
												 Model model)
	{
		RecordCriteria rc;
		PageCriteria pc;
		List<BbsDTO> list;
		
		try {
			rc 		= new FindCriteria(1, 10, searchType, keyword);
			list = bs.list(rc);
			int totalRec = bs.searchTotalRec((FindCriteria) rc);
			pc		= new PageCriteria(rc, totalRec);
			
			model.addAttribute("list", list);
			model.addAttribute("findCriteria", (FindCriteria)rc);
			model.addAttribute("pageCriteria", pc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/bbs/list";
	} 
	
	//�Խñ� ����
	@RequestMapping(value="/view", method=GET)
	public void view(@RequestParam("bNum") int bNum, Model model) throws Exception
	{
		model.addAttribute("view", bs.view(bNum));
	}
	
	//��� �ۼ� ������
	@RequestMapping(value="/replyForm", method=GET)
	public void replyform(@RequestParam("bNum") int bNum, BbsDTO bbsdto, Model model)
	{
		model.addAttribute("bNum", bNum);
		logger.info("����ۼ���");
	}
	
	//��� ���
	@RequestMapping(value="/reply", method=POST)
	public String reply(BbsDTO bbsdto, Model model) throws Exception 
	{
		logger.info("��۵��" + bbsdto.toString());
		bs.reply(bbsdto);
		return "redirect:/bbs/list";
	}
	
	//�Խñ� ���� 
	@RequestMapping(value="/delete", method=GET)
	public String delete(@RequestParam("bNum") int bNum, Model model)	throws Exception
	{
		logger.info("�Խñۻ���: " + bNum);
		bs.delete(bNum);
		return "redirect:/bbs/list";
	}
	
	//�Խñ� ���� 
	@RequestMapping(value="/modify", method=GET)
	public String modify(@RequestParam("BNum") int bNum, BbsDTO bbsdto, Model model) throws Exception
	{
		logger.info("�Խñۼ���: " + bNum);
		bs.update(bbsdto);
		model.addAttribute("view", bbsdto);
		return "redirect:/bbs/view?bNum="+bNum;
	}
	

	
	
}