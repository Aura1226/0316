package org.donghyun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.donghyun.domain.BoardVO;

public interface BoardMapper {
	
	@Select("select * from tbl_board2 order by bno desc limit #{skip}, #{perSheet}")
	List<BoardVO> getList(@Param("skip")Integer skip,
			@Param("perSheet") Integer perSheet);
	
	@Select("select replyCount from tbl_board2 where bno = #{bno}")
	Integer getReplyCount(Integer bno);

}
