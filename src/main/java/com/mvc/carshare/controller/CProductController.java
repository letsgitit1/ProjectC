package com.mvc.carshare.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvc.carshare.service.CProductService;
import com.mvc.carshare.vo.CProductVo;
import com.mvc.carshare.vo.CWishListVo;

@Controller

public class CProductController {
	private CProductService service;
	private ObjectMapper objectMapper= new ObjectMapper();
	
	public CProductController(CProductService service) {
		this.service=service;
	}
	@GetMapping("/product/productAll")
	public String listAll(Model model) {
		List <CProductVo>list =service.SelectAll();
		model.addAttribute("car",list);
		model.addAttribute("user_id", 1);
		System.out.println(list.get(1).getId());
		return "/product/productAll";
	}
	
	@PostMapping("/product/wishlist")
	@ResponseBody
	public String wishInsert(@RequestBody CWishListVo vo) {
		String result="fail";
		if(service.check_wish(vo)==0) {
			if(service.wishlist_insert(vo)==1) {
				result="success";
			}
		}
		return result;
	    
	}

	@DeleteMapping("/product/wishlist/delete")
	@ResponseBody
	public String wishDelete(@RequestBody CWishListVo vo) {
	    System.out.println("넘어옴!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	    service.wishlist_delete(vo);
	    return "success";
	}

}
