package com.mvc.carshare.controller;
//이동해

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvc.carshare.service.CCarService;
import com.mvc.carshare.vo.CcarVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CCarController {
	private CCarService service;
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public CCarController(CCarService service) {
		this.service = service;
	}
	
	// 내차등록페이지로 이동
	@GetMapping("/carReg")
	public String carReg() {
		
		return "car/carReg";
	}
	
	// 내차등록
	@PostMapping("/carReg")
	public String carReg(@ModelAttribute CcarVo vo) {
		log.info("controller vo = {}",vo);
		service.car_reg(vo);
		return "redirect:/";
	}
	
	// 내차조회
	@GetMapping("/carSel")
	public String carSel(Model model) {
		List<CcarVo> list = service.getCarList("이동해");
		log.info("controller list = {}",list);
		log.info("controller list.model = {}",list.get(1).getCar_model());
		model.addAttribute("list",list);
		return "car/carSel";
	}
}
