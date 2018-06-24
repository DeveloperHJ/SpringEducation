package com.kh.myapp.bbs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.web.bind.annotation.RestController;

import com.kh.myapp.bbs.dao.RbbsDAO;
import com.kh.myapp.bbs.dto.RbbsDTO;
import com.kh.myapp.bbs.service.RbbsService;
import com.kh.myapp.util.PageCriteria;
import com.kh.myapp.util.RecordCriteria;

@RestController
@Controller
@RequestMapping("/rbbs")
public class RbbsController {
	
	private static final Logger logger = LoggerFactory.getLogger(RbbsController.class);

	@Autowired
	@Qualifier("rbbsServiceImplXML")
	RbbsService rs;
	
	@RequestMapping(value="/write", method=POST)
	public ResponseEntity<String> write(@RequestBody RbbsDTO rbbsdto)
	{
		ResponseEntity<String> responseEntity = null;
		
		logger.info("write POST...");
		
		try {
			rs.write(rbbsdto);
			responseEntity = new ResponseEntity<>("Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	@RequestMapping(value="/list/{bnum}/{reReqPage}", method=GET)
	public ResponseEntity<String> list(
			@PathVariable Integer bnum, 
			@PathVariable Integer reReqPage) 
	{
		logger.info("Rbbs List GET..." + RbbsController.this);
		ResponseEntity<String> responseEntity = null;
		RecordCriteria recordCriteria = new RecordCriteria(reReqPage, 10);
		
		try {
			rs.list(bnum, recordCriteria);
			responseEntity = new ResponseEntity<>("Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	// 댓글 수정
	@RequestMapping(value="/modify", method=PUT)
	public ResponseEntity<String> modify(@RequestBody RbbsDTO rbbsdto)
	{
		ResponseEntity<String> responseEntity = null;
		
		try {
			rs.update(rbbsdto);
			responseEntity = new ResponseEntity<String>("Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("Fail", HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	// 댓글 삭제	
	@RequestMapping(value="/delete/{rnum}", method=DELETE)
	public ResponseEntity<String> delete(@PathVariable Integer rnum){
		ResponseEntity<String> responseEntity = null;

		try {
			rs.delete(rnum);
			responseEntity = new ResponseEntity<String>("Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("Fail", HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	// 좋아요 
	@RequestMapping(value="/good/{rnum}", method=PUT)
	public ResponseEntity<String> good(@PathVariable Integer rnum) {
		ResponseEntity<String> responseEntity = null;

		try {
			rs.goodOrBad(rnum, "good");
			responseEntity = new ResponseEntity<String>("Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("Fail", HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	// 나빠요 
	@RequestMapping(value="/bad/{rnum}", method=PUT)
	public ResponseEntity<String> bad(@PathVariable Integer rnum) {
		ResponseEntity<String> responseEntity = null;

		try {
			rs.goodOrBad(rnum, "bad");
			responseEntity = new ResponseEntity<String>("Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("Fail", HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	// 요청 댓글목록 전체 + 페이징 처리 
	@RequestMapping(value="/map/{bnum}/{reReqPage}", method=GET)
	public ResponseEntity<Map<String, Object>> map2
				(@PathVariable Integer bnum, @PathVariable Integer reReqPage)
	{
		ResponseEntity<Map<String, Object>> responseEntity = null;
		Map<String, Object> map = new HashMap<>();
		RecordCriteria recordCriteria = new RecordCriteria(reReqPage, 10);
		
		try {
			// 페이지 처리 =========================================================================
			PageCriteria pageCriteria = new PageCriteria(recordCriteria, rs.replyTotalRec(bnum), 5);
			// =====================================================================================
			
			map.put("item", rs.list(bnum, recordCriteria));
			map.put("pageCriteria", pageCriteria);
			responseEntity = new ResponseEntity<>(map, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}

	// 리댓달기
	@RequestMapping(value="reReply", method=POST)
	public ResponseEntity<String> reReply(@RequestBody RbbsDTO rbbsdto)
	{
		ResponseEntity<String> responseEntity = null;
		
		logger.info("reRply POST...");
		
		try {
			rs.reReply(rbbsdto);
			responseEntity = new ResponseEntity<>("Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
}
