package com.mvc.carshare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvc.carshare.service.CReviewService;

import lombok.extern.slf4j.Slf4j;

//이동해

@Controller
@Slf4j
public class CReviewController {
	private CReviewService service;
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public CReviewController(CReviewService service) {
		this.service = service;
	}
	
	// 리뷰작성 페이지로 이동
	@GetMapping("/review/write")
	public String write() {
		
		return "/review/write";
	}
}
