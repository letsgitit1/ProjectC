package com.mvc.carshare.vo;

import java.sql.Timestamp;

import lombok.Data;
@Data
public class CReturnVo {
	int id; //반납아이디
	int car_id; //자동차아이디
	Timestamp returned_at; //반납기준 시간
	Timestamp rent_at; //대여기준 시간
	int return_region_id; // 반납지역 아이디
	int user_id; //반납하는 사람 id
	String car_number;
}
