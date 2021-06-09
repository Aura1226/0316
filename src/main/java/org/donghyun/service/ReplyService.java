package org.donghyun.service;

import java.util.List;

import org.donghyun.common.RPageDTO;
import org.donghyun.domain.ReplyDTO;
import org.donghyun.domain.ReplyVO;

public interface ReplyService {

	default ReplyDTO toDTO(ReplyVO replyVO) {//vo를 dto로 변환해주려고

		ReplyDTO dto = new ReplyDTO();
		dto.setRno(replyVO.getRno());
		dto.setBno(replyVO.getBno());
		dto.setReply(replyVO.getReply());
		dto.setReplyer(replyVO.getReplyer());
		dto.setReplyDate(replyVO.getReplyDate());
		dto.setUpdateDate(replyVO.getUpdateDate());
		return dto;
	}

	default ReplyVO toVO(ReplyDTO replyDTO) {

		ReplyVO vo = ReplyVO.builder()
				.rno(replyDTO.getRno())
				.bno(replyDTO.getBno())
				.reply(replyDTO.getReply())
				.replyer(replyDTO.getReplyer())
				.replyDate(replyDTO.getReplyDate())
				.updateDate(replyDTO.getUpdateDate())
				.build();
		
		return vo;
	}

	void insert(ReplyDTO replyDTO);
	
	ReplyDTO selectOne(Integer rno);
	
	void update(ReplyDTO replyDTO);
	
	void delete(Integer rno);
	
	List<ReplyDTO> selectList(Integer bno, RPageDTO rPageDTO);
}
