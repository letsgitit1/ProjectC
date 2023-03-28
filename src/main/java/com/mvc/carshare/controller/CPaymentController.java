package com.mvc.carshare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.carshare.service.CMemberService;
import com.mvc.carshare.service.CProductService;
import com.mvc.carshare.service.CRegistrationsService;
import com.mvc.carshare.vo.CMemberVo;
import com.mvc.carshare.vo.CProductVo;
import com.mvc.carshare.vo.CRegistrationsVo;

@Controller
public class CPayMentController {
    private CProductService cService;
    private CMemberService mService;
    private CRegistrationsService rService;
    
    public CPayMentController(CProductService cService,CMemberService mService,CRegistrationsService rService) {
        this.cService = cService;
        this.mService=mService;
        this.rService=rService;
    }
    
    @GetMapping("/product/payment")
    public String paymentView(@RequestParam("user_id") int user_id, @RequestParam("car_id") int car_id, Model model) {
        CProductVo cvo = cService.selectCarByCar_number(car_id);
        CMemberVo mvo=mService.selectOne(user_id);
        CRegistrationsVo rvo=rService.selectRegByCarNumber(car_id);
        model.addAttribute("cvo", cvo);
        model.addAttribute("mvo", mvo);
        model.addAttribute("rvo", rvo);
        return "/product/payment";
    }
    @GetMapping("/product/paymentSuccess")
    public String payMentSuccess() {
    	return "/product/paymentSuccess";
    }
    
}

