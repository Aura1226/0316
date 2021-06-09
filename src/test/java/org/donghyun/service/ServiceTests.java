package org.donghyun.service;

import org.donghyun.domain.ReplyDTO;
import org.donghyun.service.ReplyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ServiceTests {

	
	@Autowired
	   private ReplyService replyService;
	   
	   @Test
	   public void testInsertDummies() {
	      
	      int bno = 2720;
	      
	      for(int i = 0; i < 15; i++) {
	         
	         ReplyDTO dto = ReplyDTO.builder()
	               .reply("test..." + i)
	               .replyer("user "+i)
	               .bno(bno)
	               .build();
	         
	         replyService.insert(dto);
	      }
	      
	   }
}
