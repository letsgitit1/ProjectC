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
	
	public CProductController(CProductService service) {
		this.service=service;
	}
	@GetMapping("/product/productAll")
	public String listAll(Model model) {
	    List<CProductVo> list = service.SelectAll();
	    int user_id = 1; // 사용자 아이디 임시 값
	    model.addAttribute("car", list);
	    model.addAttribute("user_id", user_id);
	    model.addAttribute("rent_id", 1);	// 임시데이터
	
	    // 해당 사용자가 찜한 상품 번호 리스트를 가져옴
	    List<Integer> wishList = service.wishCount(user_id);
	    model.addAttribute("wishList", wishList);
	    System.out.println(wishList);

	    return "product/productAll";
	}
	
	@PostMapping("/product/wishlist")
	@ResponseBody
	public String wishInsert(@RequestBody CWishListVo vo) {
		System.out.println("위시리스트들어옴");
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
	    service.wishlist_delete(vo);
	    return "success";
	}

}
