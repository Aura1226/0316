package org.donghyun.service;

import java.util.List;
import java.util.stream.Collectors;

import org.donghyun.common.RPageDTO;
import org.donghyun.domain.ReplyDTO;
import org.donghyun.domain.ReplyVO;
import org.donghyun.mapper.ReplyMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

	private final ReplyMapper replyMapper;
	
	@Override
	public void insert(ReplyDTO replyDTO) {
		replyMapper.insert(toVO(replyDTO));
		replyMapper.replyCountUpdate(replyDTO.getBno());

	}

	@Override
	public ReplyDTO selectOne(Integer rno) {
		
		return toDTO(replyMapper.selectOne(rno));
	}

	@Override
	public void update(ReplyDTO replyDTO) {
		replyMapper.update(toVO(replyDTO));

	}

	@Override
	public void delete(Integer rno) {
		replyMapper.delete(rno);

	}

	@Override
	public List<ReplyDTO> selectList(Integer bno, RPageDTO rPageDTO) {
		
		return replyMapper.selectList(bno, rPageDTO.getSkip()).stream().map(board -> toDTO(board)).collect(Collectors.toList());
	}
	
}
