package com.kh.myapp;

import java.util.List;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.myapp.bbs.dao.RbbsDAO;
import com.kh.myapp.bbs.dto.RbbsDTO;
import com.kh.myapp.util.RecordCriteria;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
class RbbsTest {

private static final Logger logger = Logger.getLogger(RbbsTest.class);
	
	@Autowired
	@Qualifier("rbbsDAOImplXML")
	RbbsDAO rs;
	
	RbbsDTO rdto = new RbbsDTO();;
	
	@Test @Disabled
	void write() throws Exception {
		rdto.setRid("user@kh.com");
		rdto.setBnum(3712);
		rdto.setRname("유저");
		rdto.setRcontent("댓글 테스트1");

		rs.write(rdto);
	}
	
	@Test @Disabled
	void listAll() throws Exception {
		List<RbbsDTO> list = rs.list(3712);
		logger.info(list.size());
	}
	
	@Test @Disabled
	void list() throws Exception {
		RecordCriteria rc = new RecordCriteria(1, 10);
		List<RbbsDTO> list = rs.list(1781, rc);
		logger.info(list.size());
	}
	
	@Test @Disabled
	void update() throws Exception {
		rdto.setRnum(1723);
		rdto.setRcontent("댓글 테스트1 수정");
		rs.update(rdto);
	}

	@Test @Disabled
	void delete() throws Exception {
		rs.delete(1723);
	}
	
	@Test @Disabled
	void replyTotalRec() throws Exception {
		logger.info(rs.replyTotalRec(1781));
	}
	
	@Test @Disabled
	void replyView() throws Exception {
		logger.info(rs.oriInform(1708).toString());
	}
	
	// 보류, 불러오는 댓글, 작성 리댓으로 코드 수정해야 됨. 
	@Test @Disabled
	void reply() throws Exception {
		rdto.setRid("admin@kh.com");
		rdto.setBnum(1781);
		rdto.setRname("관리자");
		rdto.setRcontent("리댓 테스트");
		rdto.setRgroup(0);
	}

}
