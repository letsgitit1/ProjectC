package com.mvc.carshare.vo;

import lombok.Data;

@Data
public class CMemberVo {
	int id;
	String email;
	String username;
	String password;
	String name;
	int age;
	String gender;
	String address;
	String phone_number;
	String driver_license_number;
	int point;
	String mannerscore;
	String auth;
}
