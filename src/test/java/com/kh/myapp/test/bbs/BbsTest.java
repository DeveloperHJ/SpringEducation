package com.kh.myapp.test.bbs;


import java.util.List;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.myapp.bbs.dao.BbsDAO;
import com.kh.myapp.bbs.dto.BbsDTO;
import com.kh.myapp.util.FindCriteria;
import com.kh.myapp.util.PageCriteria;
import com.kh.myapp.util.RecordCriteria;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
class BbsTest {

	private static final Logger logger = Logger.getLogger(BbsTest.class);
	
	@Autowired
	@Qualifier("bbsDAOImplXML")
	BbsDAO bbsdao;
	
/*	@Test @Disabled
	void insert_test() {
		BbsDTO bbsdto = new BbsDTO();
		bbsdto.setBTitle("mybatis Insert TEST");
		bbsdto.setBName("김현정");
		bbsdto.setBHit(1);
		bbsdto.setBContent("spring insert test, xml");
		bbsdao.write(bbsdto);
	}

	@Test @Disabled
	void list_test() {
		List<BbsDTO> list = bbsdao.list(null);
		logger.info(list.size());
	}
	
	@Test @Disabled
	void view_test() {
		BbsDTO bbsdto = bbsdao.view(3652);
		logger.info(bbsdto.toString());
	}
	
	@Test @Disabled
	void update_test() {
		BbsDTO bbsdto = new BbsDTO();
		bbsdto.setBNum(3652);
		bbsdto.setBContent("게시글 수정 테스트");
		bbsdto.setBTitle("게시글 수정 테스트");
		bbsdao.update(bbsdto);
	}
	
	@Test @Disabled
	void delete_test() {
		bbsdao.delete(3651);
	}
	
	@Test @Disabled
	void replyView_test() {
		logger.info(bbsdao.replyView(3650));
	}
	
	@Test @Disabled
	void reply_test() {
		BbsDTO bbsdto = new BbsDTO();
		bbsdto.setBNum(3650);
		bbsdto.setBName("김현정");
		bbsdto.setBTitle("답글 테스트2");
		bbsdto.setBContent("답글 테스트 내용2");
		bbsdto.setBGroup(3650);
		bbsdto.setBStep(0);
		bbsdto.setBIndent(0);
		
		bbsdao.reply(bbsdto);
	}
	
	@Test @Disabled
	void totalRec_test() {
		logger.info(bbsdao.totalRec());
	}
	*/
	
	@Test @Disabled
	void findList_test() throws Exception{
		RecordCriteria rc = new FindCriteria(1, 10, "W", "김현정");
		List<BbsDTO> list = bbsdao.list(rc);
		int totalRec = bbsdao.searchTotalRec((FindCriteria)rc);
		PageCriteria pc = new PageCriteria(rc, totalRec);	

		logger.info(list.toString());
		logger.info(pc.toString());
	}
	
	@Test @Disabled
	void searchTotalRec_test() throws Exception {
		FindCriteria findCriteria = new FindCriteria(1, 10, "TC", "제목");
		logger.info(bbsdao.searchTotalRec(findCriteria));
	}
	
	@Test @Disabled
	void list_test() {
		RecordCriteria recordCriteria = new RecordCriteria(1, 10);
		PageCriteria pageCriteria;
		try {
			pageCriteria = new PageCriteria(recordCriteria, bbsdao.totalRec());
			List<BbsDTO> list = bbsdao.list(recordCriteria);
			
			logger.info(list.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void reply_new() throws Exception {
		BbsDTO bbsdto = new BbsDTO();
		bbsdto.setBID("admin@kh.com");
		bbsdto.setBName("관리자");
		bbsdto.setBTitle("답글임");
		bbsdto.setBContent("답글내용");
		bbsdto.setBGroup(3769);
		bbsdto.setBStep(0);
		bbsdto.setBIndent(0);
		
		bbsdao.reply(bbsdto);
	}
}
