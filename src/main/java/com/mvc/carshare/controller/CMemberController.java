package com.mvc.carshare.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.carshare.dao.CPaymentDao;
import com.mvc.carshare.service.CMemberService;
import com.mvc.carshare.service.CPaymentService;
import com.mvc.carshare.vo.CMemberVo;
import com.mvc.carshare.vo.CPaymentDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/*")
public class CMemberController {
	
	private final CMemberService cMemberService;
	
	private final CPaymentService cPaymentService;
	
	@GetMapping("/remove")
	public String remove(String email) {
		cMemberService.remove(email);
		return "redirect:/";
	}
	
	@GetMapping("/modify")
	public String modyfy(Model model, String email) {
		model.addAttribute("member", cMemberService.findByEmailAll(email));
		return "/member/modify";
	}
	
	@PostMapping("/modify")
	public String modyfy(CMemberVo cMemberVo) {
		cMemberService.modify(cMemberVo);
		return "redirect:/";
	}
	
	@GetMapping("/point")
	public String findByPoint(Model model, String email) {
		model.addAttribute("member", cMemberService.findByEmailAll(email));
		return "/member/point";
	}
	
	@GetMapping("/login")
	public String login(Model model, String email) {
		if(email.equals("admin")) {
			
			List<CPaymentDTO> dailyList = cPaymentService.getDaily();
			List<CPaymentDTO> weeksList = cPaymentService.getWeeks();
			List<CPaymentDTO> monthsList = cPaymentService.getMonths();
			List<CPaymentDTO> yearsList = cPaymentService.getYears();
			
			model.addAttribute("dailyList", dailyList);
			model.addAttribute("weeksList", weeksList);
			model.addAttribute("monthsList", monthsList);
			model.addAttribute("yearsList", yearsList);
			
			return "/member/adminPage";
		}
		return "index";
	}
	
}
