package com.mvc.carshare.controller;
//이동해

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvc.carshare.service.CCarService;
import com.mvc.carshare.service.CMarkerService;
import com.mvc.carshare.service.CRegistrationsService;
import com.mvc.carshare.vo.CMDto;
import com.mvc.carshare.vo.CMemberVo;
import com.mvc.carshare.vo.CNotRegCarDto;
import com.mvc.carshare.vo.CRegistrationsVo;
import com.mvc.carshare.vo.CcarDto;
import com.mvc.carshare.vo.CcarVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CCarController {
	private CCarService service;
	private CRegistrationsService rService;
	private CMarkerService Cservice;
	
	public CCarController(CCarService service, CRegistrationsService rService,CMarkerService Cservice) {
		this.service = service;
		this.rService = rService;
		this.Cservice=Cservice;
	}

	// 내차등록페이지로 이동
	@GetMapping("/carReg")
	public String carReg() {

		return "car/carReg";
	}

	// 내차등록
	@PostMapping("/carReg")
	public String carReg(@ModelAttribute CcarVo vo, HttpSession request,
	        @RequestParam("file") MultipartFile file) {
		
	    String uploadDir = "C:\\uploadimage";
	    //ServletContext context = request.getServletContext();
	    //String realPath = context.getRealPath(uploadDir);
	    // 파일 이름 설정
	    String fileName = file.getOriginalFilename();
	    String filePath = uploadDir + File.separator + fileName;
	    System.out.println(fileName);
	    // 저장할 디렉토리가 없으면 생성
//	    File dir = new File(filePath);
//	    if (!dir.exists()) {
//	        dir.mkdirs();
//	    }
	    
	    //파일 저장
	    try {
	    	System.out.println(file);
	        file.transferTo(new File(filePath));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    System.out.println(file.getOriginalFilename());
	    vo.setCar_image(file.getOriginalFilename());
	    System.out.println(vo);
	   
	    log.info("controller vo = {}", vo);
	    service.car_reg(vo);
	    return "redirect:/";
	}

	// 내차조회 등록페이지로 이동
	@GetMapping("/carSel")
	public String carSel(Model model, HttpServletRequest request) {

		// 세션의 저장된 username값을 가져와야함
		HttpSession session = request.getSession();
		CMemberVo vo = (CMemberVo) session.getAttribute("vo");
		System.out.println(vo);
		int id = vo.getId();
		String email = vo.getEmail();

		// 차의 평균 값 셋팅
		List<CcarDto> list = service.getCarList(id);
		List<Integer> list2 = service.getCarNum(email);
		List<CNotRegCarDto> list3 = service.notregcar(vo.getId());
		model.addAttribute("list3", list3);
		System.out.println("차량리스트=======================>" + list);
		System.out.println(list3);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCar_score() != 0) {
				list.get(i).setCar_score(service.carSc((int) list2.get(i)));// i차량 평점을 주입
			}
		}
		model.addAttribute("list", list);
		model.addAttribute("id", id);

		return "car/carSel";
	}

	// 자동차 판매등록창
	@GetMapping("/car/saleReg")
	public String saleReg(@RequestParam("carId") int carId, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		CMemberVo vo = (CMemberVo) session.getAttribute("vo");
		CMDto cmvo = service.memberByCar(vo.getId(), carId);
		model.addAttribute("cmvo", cmvo);
		 
		System.out.println(cmvo);

		return "car/saleReg";
	}

	// 자동차 판매등록
	@PostMapping("/car/car_sReg")
	public String insertReg(@ModelAttribute CRegistrationsVo vo) {
		String url = "";
		System.out.println(vo.getCar_number());
		service.insertCarMarker(vo.getCar_number());
		if (rService.insertReg(vo) == 1) {
			url = "member/mypage";
		} else {
			url = "car/regfail";
		}
		return url;
	}

	// 등록차량 삭제
	@PostMapping("/delete")
	public String delete_car(@ModelAttribute CcarVo vo) {
		log.info("controller vo = {}", vo);
		service.delete_car(vo);
		return "redirect:/";
	}
}
