package com.mvc.carshare.vo;

import java.sql.Timestamp;

import lombok.Data;
@Data
public class CRegistrationsVo {
	int id;
	int return_region_id;
	int car_number;
	int rent_price;
	int rent_time;
	Timestamp registered_at;
}
