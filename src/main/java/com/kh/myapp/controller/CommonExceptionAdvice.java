package com.kh.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

// ���� Ŭ������ ��Ʈ�ѷ����� �߻��ϴ� Exception�� ���������� ó���ϴ� Ŭ�������� �˷���.
@ControllerAdvice
public class CommonExceptionAdvice {
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	@ExceptionHandler(Exception.class)
	private ModelAndView err(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/err_exception");
		mav.addObject("exception", e);
		
		return mav;
	}
}