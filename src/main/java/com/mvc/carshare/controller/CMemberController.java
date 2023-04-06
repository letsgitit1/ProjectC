package com.mvc.carshare.controller;
import java.util.List;
//이동해
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvc.carshare.service.CMemberService;
import com.mvc.carshare.service.CSMemberService;
import com.mvc.carshare.service.CSPaymentService;
import com.mvc.carshare.vo.CMemberVo;
import com.mvc.carshare.vo.CPaymentDTO;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class CMemberController {
	private CMemberService service;
	private ObjectMapper objectMapper = new ObjectMapper();
	private final CSMemberService cSMemberService;
	private final CSPaymentService cSPaymentService;
	
	
	
	public CMemberController(CMemberService service,CSMemberService cSMemberService,CSPaymentService cSPaymentService) {
		this.service = service;
		this.cSMemberService=cSMemberService;
		this.cSPaymentService=cSPaymentService;
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
	public String login(@RequestParam Map<String, String> param, Model model,
			RedirectAttributes reattr,
			HttpSession session) {
		String message = "로그인 계정 정보가 다릅니다.";
		CMemberVo vo = service.login(param);
		if(vo == null) {
			reattr.addFlashAttribute("err",message);
		} else {
			session.setAttribute("vo", vo);
		}
		
		if(vo.getEmail().equals("admin")) {
			
			List<CPaymentDTO> dailyList = cSPaymentService.getDaily();
			List<CPaymentDTO> weeksList = cSPaymentService.getWeeks();
			List<CPaymentDTO> monthsList = cSPaymentService.getMonths();
			List<CPaymentDTO> yearsList = cSPaymentService.getYears();
			
			model.addAttribute("dailyList", dailyList);
			model.addAttribute("weeksList", weeksList);
			model.addAttribute("monthsList", monthsList);
			model.addAttribute("yearsList", yearsList);
			
			return "/member/adminPage";
		}
		System.out.println("member"+vo);
		return "redirect:/";
	}
	
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}


	//ID찾기페이지로 이동
	@GetMapping("/find_id")
	public String find_id() {
		
		return "/member/find_id";
	}
	
	//전화번호로 ID찾기
	@PostMapping("/find_id")
	public String find_id(CMemberVo vo, HttpServletRequest request) {
		String id = service.find_id(vo);
		request.setAttribute("id", id);
		return "/member/find_id_result";
	}
	
	//비밀번호 찾기페이지로 이동
	@GetMapping("/find_pass")
	public String find_pass() {
		
		return "/member/find_pass";
	}
	
	//아이디로 비밀번호 찾기
	@PostMapping("/find_pass")
	public String find_pass(CMemberVo vo, Model model) {
		String pass = service.find_pass(vo); 
		service.sendMail(vo.getEmail(),pass);
		System.out.println("controller pass : " + pass);
//		service.sendMail("cjw5006@naver.com");	//받을사람 
		model.addAttribute("pass",pass);
		return "/member/find_pass_result";
	}
	 //마이페이지 페이지로 이동
	   @GetMapping("/mypage")
	   public String mypage() {
	      
	      return "/member/mypage";
	   }
	   
	   //회원정보수정 페이지로 이동
	   @GetMapping("/update")
	   public String update() {
	      
	      return "/member/modify";
	   }
	   @GetMapping("/remove")
		public String remove(String email) {
		   cSMemberService.remove(email);
			return "redirect:/";
		}
		
		@GetMapping("/modify")
		public String modyfy(Model model, String email) {
			model.addAttribute("member", cSMemberService.findByEmailAll(email));
			return "/member/modify";
		}
		
		@PostMapping("/modify")
		public String modyfy(CMemberVo cMemberVo) {
			cSMemberService.modify(cMemberVo);
			return "redirect:/";
		}
		
		@GetMapping("/point")
		public String findByPoint(Model model, String email) {
			model.addAttribute("member", cSMemberService.findByEmailAll(email));
			return "/member/point";
		}
		
		

	
	
}
