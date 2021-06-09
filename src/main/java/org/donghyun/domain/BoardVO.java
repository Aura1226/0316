package org.donghyun.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j
public class BoardVO {

	Integer bno;
	String title;
	String content;
	String writer;
	Timestamp regdate;
	Timestamp updateDate;
	Integer replyCount;
}
