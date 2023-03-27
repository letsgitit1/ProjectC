package com.mvc.carshare.controller;
//이동해
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.carshare.service.CMemberService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CMemberRestController {
	
	 @Autowired
	   private CMemberService service;
	//아이디 중복체크
	 @PostMapping("/check/{email}")
	    public int checkID(@PathVariable String email) {
	        log.info("checkID=>"+ email);
	        return service.idCheck(email);
	    }
	
}
