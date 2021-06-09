package org.donghyun.mapper;

import org.donghyun.domain.ReplyVO;
import org.donghyun.mapper.ReplyMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTests {

	@Autowired
	private ReplyMapper mapper;
	
	@Test
	public void testInsertDummies() {
		
		int bno = 975;
		
		for(int i = 0; i < 15; i++) {
			
			ReplyVO vo = ReplyVO.builder()
					.reply("test..." + i)
					.replyer("user....." + i)
					.bno(bno)
					.build();
			
			mapper.insert(vo);
		}
		
	}
	
	@Test
	public void testSelectOne() {
		
		ReplyVO vo = mapper.selectOne(60);
		
		log.info(vo); 
	}
	
	@Test
	public void testDelete() {
		mapper.delete(60);
	}
	
	@Test
	public void testUpdate() {
		
		ReplyVO vo = ReplyVO.builder().rno(15).reply("Update reply").build();
		
		mapper.update(vo);
	}
	
	@Test
	public void testList() {
		
		mapper.selectList(975, 0).forEach(reply -> System.out.println(reply));
		log.info("=======end=========");
	}
	

}
