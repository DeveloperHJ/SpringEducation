package com.kh.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/") 
	public String main() {
		return "index";
	}
	
	@RequestMapping("/edu") 
	public String mainEdu() {
		
		return "index_edu";
	}
	
	@RequestMapping(value="/main") 
	public String mainContent() {
		
		return "index/indexContent";
	}
}
