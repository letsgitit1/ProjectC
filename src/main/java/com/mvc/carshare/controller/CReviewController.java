package com.mvc.carshare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvc.carshare.service.CReviewService;
import com.mvc.carshare.vo.CMemberVo;
import com.mvc.carshare.vo.CReviewVo;
import com.mvc.carshare.vo.CcarVo;

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
	
	//내가쓴 리뷰 조회 페이지로 이동
	@GetMapping("/review/writebyme")
	public String writebyme(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		CMemberVo vo = (CMemberVo)session.getAttribute("vo");
		int id = vo.getId();
		List<CReviewVo>list = service.writebyme(id);
		model.addAttribute("list",list);
		log.info("list : {}",list);
		return "/review/writebyme";
	}
	
	//내가 등록한차량 리뷰 조회 페이지로 이동
	@GetMapping("/review/review")
	public String review(@RequestParam("car_id") int carId, Model model) {
		
		List<CReviewVo> list = service.creviewOne(carId);
		log.info("list : {}",list);
		model.addAttribute("list",list);
		return "/review/review";
	}
	
	
}
