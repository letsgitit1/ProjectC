package com.mvc.carshare.controller;
//이동해

import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvc.carshare.service.CCarService;
import com.mvc.carshare.vo.CMemberVo;
import com.mvc.carshare.vo.CcarDto;
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
	
	// 내차조회 등록페이지로 이동
	@GetMapping("/carSel")
	public String carSel(Model model, HttpServletRequest request) { 
		//세션의 저장된 username값을 가져와야함
		HttpSession session = request.getSession();
		CMemberVo vo = (CMemberVo)session.getAttribute("vo");
		System.out.println(vo);
		String username = vo.getUsername();
		String email = vo.getEmail();
		
		//차의 평균 값 셋팅
		List<CcarDto> list = service.getCarList(username);
		List<Integer> list2 = service.getCarNum(email);
		System.out.println(list);
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getCar_score()!=0) {
			list.get(i).setCar_score(service.carSc((int)list2.get(i)));//i차량 평점을 주입
			}
		}
	
		
		model.addAttribute("list",list);
		model.addAttribute("username",username);
		return "car/carSel";
	}
	
}
