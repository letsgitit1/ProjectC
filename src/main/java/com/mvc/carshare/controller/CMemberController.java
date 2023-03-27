package com.mvc.carshare.controller;
//이동해
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvc.carshare.service.CMemberService;
import com.mvc.carshare.vo.CMemberVo;


@Controller
public class CMemberController {
	private CMemberService service;
	private ObjectMapper objectMapper = new ObjectMapper();

	public CMemberController(CMemberService service) {
		this.service = service;
	}

	// 회원가입 페이지로 이동
	@GetMapping("/reg")
	public String reg() {
		return "member/reg";
	}

	// 회원가입
	@PostMapping("/reg")
	public String reg_insert(@ModelAttribute CMemberVo vo) {
		service.member_reg(vo);
		return "redirect:/";
	}

	// 로그인 페이지로 이동
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}

	// 로그인
	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> param,
			RedirectAttributes reattr,
			HttpSession session) {
		String message = "로그인 계정 정보가 다릅니다.";
		String url = "/";
		CMemberVo vo = service.login(param);
		if(vo == null) {
			reattr.addFlashAttribute("alert",message);
			url="login";
		} else {
			session.setAttribute("vo", vo);
		}
		return "redirect:"+url;
	}

	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	
}
