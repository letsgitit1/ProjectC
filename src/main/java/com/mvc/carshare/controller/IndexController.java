package com.mvc.carshare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping({"/","index"})
	public String index() {
		return "main";
	}
	@GetMapping("/kakaomapTest")
	public String map() {
		return"kakaomapTest";
	}
	@GetMapping("/people")
	public String people() {
		return"people";
	}
}

