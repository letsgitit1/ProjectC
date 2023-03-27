package com.mvc.carshare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CPaymentController {
	@GetMapping("/product/payment")
	public String paymentView(@RequestParam("user_id") int user_id,@RequestParam("car_id") int car_id) {
		
		return "/product/payment";
	}
		
}
