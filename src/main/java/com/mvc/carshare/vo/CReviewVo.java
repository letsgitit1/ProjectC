package com.mvc.carshare.vo;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//이동해

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CReviewVo {

	private int id;					//후기번호
	private int car_number;			//차 고유번호
	private int author_id;			//회원 고유번호
	private int car_score;			//자동차 점수
	private String content;			//내용
	private	Timestamp created_at;	//후기 작성날짜
}
