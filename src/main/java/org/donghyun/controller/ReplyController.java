package org.donghyun.controller;



import java.util.List;

import org.donghyun.common.RPageDTO;
import org.donghyun.domain.ReplyDTO;
import org.donghyun.service.ReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@CrossOrigin
@RestController
@Log4j
@RequestMapping("/replies")
@RequiredArgsConstructor
public class ReplyController {

	private final ReplyService service;
	
	@PostMapping(value =  "/insert")
	public ResponseEntity<String> insert(@RequestBody ReplyDTO dto) {
		
		service.insert(dto);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	@GetMapping(value =  "/read", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ReplyDTO>> read(Integer bno, RPageDTO rPageDTO) {
		
		List<ReplyDTO> list = service.selectList(bno, rPageDTO);
		
		return new ResponseEntity<List<ReplyDTO>>(list, HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody ReplyDTO replyDTO) {
		
		service.update(replyDTO);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);	
	}
	@DeleteMapping
	public ResponseEntity<String> delete(Integer rno) {
		
		service.delete(rno);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
}
