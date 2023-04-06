package com.mvc.carshare.vo;

import lombok.Data;

@Data
public class CPaymentDTO {
	private String payment_date;
	private int price;
	private String car_model;
	private int profit;
}
