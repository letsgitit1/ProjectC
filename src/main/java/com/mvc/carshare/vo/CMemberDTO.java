package com.mvc.carshare.vo;

import lombok.Data;

@Data
public class CMemberDTO {
	private int id;
	private String email;
	private String username;
	private String password;
	private String name;
	private int age;
	private String gender;
	private String address;
	private String phone_number;
	private String driver_license_number;
	private int point;
	private String mannerscore;
	private String auth;
	int registrNum;
}
