package org.donghyun.controller;

import org.donghyun.domain.SampleDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@CrossOrigin(origins = "*")
@RestController //썼으니 @ResponseBody 생략 가능
@Log4j
@RequestMapping("/samples")//REST api의 URL 설계는 뒤에s를 붙여준다(큰 범위)
public class SampleController {
	
	@PutMapping("/{sno}")
	public ResponseEntity<SampleDTO> modify(@RequestBody SampleDTO dto){
		
		log.info("modify...................");
		log.info("DTO: "+ dto);
//		log.info("SNO: " + sno);
		
		return new ResponseEntity<SampleDTO>(dto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{sno}")//id가 노출된다는 단점이 있다
	public ResponseEntity<Boolean> removeSample(@PathVariable(name = "sno") Integer sno) {
		
		log.info("SNO: " + sno);
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@PostMapping("/{cat}")
	public ResponseEntity<SampleDTO> postSample(
			@PathVariable(name = "cat") Long cat,
			@RequestParam(name = "perSheet") Integer perSheet,
			@RequestBody SampleDTO dto
			){
		
		log.info("cat: " + cat);
		log.info("perSheet: " + perSheet);
		log.info(dto);
		
		return new ResponseEntity<SampleDTO>(dto, HttpStatus.OK);
	}
	
	                             //만들어낸  //consumes는 소비만하는...들어오는 데이터... produces와 consumes는 둘다 JSON 방식의 데이터를 처리할 때 쓴다.
	@GetMapping(value = "/get1", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<SampleDTO> getSample() {
		
		SampleDTO result = new SampleDTO(11, "홍", "길동");
	
		return new ResponseEntity<SampleDTO>(result, HttpStatus.OK);
	}
}
