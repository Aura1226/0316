package org.donghyun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.donghyun.domain.ReplyVO;

public interface ReplyMapper {
	
	@Insert("insert into tbl_reply (bno, reply, replyer) values (#{bno}, #{reply}, #{replyer})")// bno?
	void insert(ReplyVO vo);
	
	@Select("select * from tbl_reply where rno = #{rno}")
	ReplyVO selectOne(Integer rno);
	
	@Update("update tbl_reply set reply = #{reply}, updateDate = now() where rno = #{rno}")
	void update(ReplyVO vo);
	
	@Delete("delete from tbl_reply where rno = #{rno}")
	void delete(Integer rno);
	//원랜 여기서 트랜잭션 해줘야 하는데...책보고 마무리해보자...
	
	@Select("select * from tbl_reply where bno = #{bno} order by rno asc limit #{skip}, 10")
	List<ReplyVO> selectList(//..값이 두개이상이면 mybatis는 못 쓴다... 그럴때 @Param을 써야...
			@Param("bno") Integer bno, 
			@Param("skip") int skip);

	@Update("update tbl_board2 set replyCount = (select count(*) from tbl_reply where bno=#{bno}) where bno = #{bno}")
	   void replyCountUpdate(Integer bno);
}
