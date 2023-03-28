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
	int return_region_id;
	int car_number;
	int rent_price;
	int rent_time;
	Timestamp registered_at;
}
