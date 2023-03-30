package com.mvc.carshare.vo;

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
public class CProductVo {
	int car_id;
	String car_Number;
	int owner_id;
	String car_image;
	String car_model;
	String manufacturer;
	String engine_type;
	String car_type;
	String c_year;
		
}
