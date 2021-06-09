package org.donghyun.common;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RPageDTO {//service계층에서 얘를 이용해 데이터를 받을 거

	@Builder.Default
	private int page = 1;
	
	@Builder.Default
	private int perSheet = 10;
	
	private String type; //t, tc ,tcw = 단일 검색, 다중 검색?
	
	private String keyword;
	
	public int getSkip() {
		return (page -1) * perSheet;//음수가 나오면 안되니까... getter를 깔끔하게 쓰거나 벨리데이션을 해주자.
	}
	
	public String[] getArr() {
		if(keyword == null || keyword.trim().length() == 0) {
			return null;
		}
		if(type == null) {
			return null;
		}
		return type.split(""); //공백으로 쪼개준다 = 배열이 된다.
	}
	
	/*
	 * public Map<String, String> getMap() { Map<String, String> map = new
	 * HashMap<>(); map.put("t", "10"); map.put("c", "50"); map.put("w", "100");
	 * 
	 * return null; }
	 */
}
