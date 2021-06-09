package org.donghyun.domain;

import java.sql.Timestamp;

public class BoardDTO {

	Integer bno;
	String title;
	String content;
	String writer;
	Timestamp regdate;
	Timestamp updateDate;
	Integer replyCount;
}
