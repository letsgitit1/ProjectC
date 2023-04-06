package com.mvc.carshare.vo;

import lombok.Data;

@Data
public class CNotRegCarDto {
	private int car_id;
	private String car_number;
	private int owner_id;
	private String car_image;
	private String car_model;
	private String manufacturer;
	private String engine_type;
	private String car_type;
	private String c_year;
}
