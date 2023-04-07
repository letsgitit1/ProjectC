package com.mvc.carshare.vo;


import lombok.Data;

@Data
public class CMarkerjoinCarDTO2 {
	 private double latitude;
	 private double longitude;
	 
	 private int car_id;
	 private String car_image;
	 private String car_model;
	 
	 
	 private int m_id;
	 
	 private int r_id;
	 private int rent_price;
	 private int rent_time;
	 
	 
}
