package com.mvc.carshare.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CPayMentVo {
	int id;
	int reg_id; //판매
	int return_number; //반납
	int payer_id; //회원
	String payment_method;
	int price;
	Timestamp payment_date;
}
