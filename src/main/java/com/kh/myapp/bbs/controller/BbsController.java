package com.kh.myapp.bbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kh.myapp.bbs.dto.BbsDTO;
import com.kh.myapp.bbs.service.BbsService;


@Controller
@RequestMapping("/bbs")
public class BbsController {

	private static final Logger logger = LoggerFactory.getLogger(BbsController.class);
	
	@Autowired
	@Qualifier("bbsServiceImplXML")
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
	@RequestMapping(value = "/list", method = GET)
	public void list(HttpServletRequest request, Model model) throws Exception 
	{
		logger.info("list GET..");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info("�������� : " + auth.getPrincipal().toString());
		
		bs.list(request);
	} 
	
	//�Խñ� ����
	@RequestMapping(value="/view", method=GET)
	public void view(@RequestParam("bnum") int bnum, Model model) throws Exception
	{
		logger.info("view GET...");
		model.addAttribute("view", bs.view(bnum));
	}
	
	//��� �ۼ� ������
	@RequestMapping(value="/replyForm", method=GET)
	public void replyform(@RequestParam("bnum") int bnum, BbsDTO bbsdto, Model model) throws Exception
	{
		logger.info("reply GET...");
		model.addAttribute("reply", bs.view(bnum));
	}
	
	//��� ���
	@RequestMapping(value="/reply", method=POST)
	public String reply(BbsDTO bbsdto, Model model) throws Exception 
	{
		logger.info("reply POST...");
		logger.info(bbsdto.toString());
		bs.reply(bbsdto);
	
		return "redirect:/bbs/list";
	}
	
	//�Խñ� ���� 
	@RequestMapping(value="/delete", method=GET)
	public String delete(@RequestParam("bnum") int bnum, Model model)	throws Exception
	{
		logger.info("delete GET... : " + bnum);
		bs.delete(bnum);
		return "redirect:/bbs/list";
	}
	
	//�Խñ� ���� 
	@RequestMapping(value="/modify", method=GET)
	public String modify(@RequestParam("bNum") int bnum, BbsDTO bbsdto, Model model) throws Exception
	{
		logger.info("modify GET... : " + bnum);
		bs.update(bbsdto);
		model.addAttribute("view", bbsdto);
		return "redirect:/bbs/view?bnum="+bnum;
	}
		
	@RequestMapping(value="/replyPage")
	public String replyPage() 
	{
		return "/bbs/reply";
	}
}
