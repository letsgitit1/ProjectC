package com.mvc.carshare.vo;

import java.sql.Timestamp;

import lombok.Data;
@Data
public class RentDto {
	Timestamp remaining_time;
	int id;
	int user_id;
}
