package com.mvc.carshare.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvc.carshare.service.CMarkerService;
import com.mvc.carshare.service.CProductService;
import com.mvc.carshare.service.CRegistrationsService;
import com.mvc.carshare.service.CReturnService;
import com.mvc.carshare.vo.CMarker;
import com.mvc.carshare.vo.CMarkerJoinCarDTO;
import com.mvc.carshare.vo.CMarkerjoinCarDTO2;
import com.mvc.carshare.vo.CMemberVo;
import com.mvc.carshare.vo.CReturnVo;


@Controller
public class CMarkerController {

    private ObjectMapper objectMapper = new ObjectMapper();
    private CMarkerService service;
    private CProductService pservice;
    private CRegistrationsService rservice;
    private CReturnService reService; //REturn serviece

    public CMarkerController(CMarkerService service, CProductService pservice, CRegistrationsService rservice,CReturnService reService) {
        this.service = service; //marker
        this.pservice = pservice; //product
        this.rservice = rservice; //reg
        this.reService=reService;
    }

    @GetMapping("/Map/MapTestKyung")
    public String map(Model model,HttpSession session) {
        List<CMarkerJoinCarDTO> list = null;
        list = service.getAllMarkersJoinCars();
        model.addAttribute("markers", list);
        CMemberVo vo= (CMemberVo)session.getAttribute("vo");
        //회원의 렌트여부를 담음
        int rentB = service.booleanRent(vo.getId());
        System.out.println("rentB=>>>>>>>>"+rentB);
        model.addAttribute("rentB",rentB);
        //테스트용찜
        model.addAttribute("user_id",vo.getId() );
        
        CReturnVo rvo= reService.selectById(vo.getId());
        model.addAttribute("rvo",rvo);
        System.out.println(rvo);
        
        // 해당 사용자가 찜한 상품 번호 리스트를 가져옴
        List<Integer> wishList = pservice.wishCount(vo.getId());
        model.addAttribute("wishList", wishList);
        return "Map/MapTestKyung";
    }

    @GetMapping("/Map/MapTestKyung2")
    public String map2(Model model,HttpSession session) {
        List<CMarkerjoinCarDTO2> list = null;
        
        //테스트용찜
        CMemberVo vo= (CMemberVo) session.getAttribute("vo");
        list = service.selectBySell(vo.getId());
        System.out.println("list=>>>>>>>>>>>>>>>"+list);
        model.addAttribute("markers", list);
        model.addAttribute("user_id",vo.getId() );

        // 해당 사용자가 찜한 상품 번호 리스트를 가져옴
        List<Integer> wishList = pservice.wishCount(vo.getId());
        model.addAttribute("wishList", wishList);
        return "Map/MapTestKyung2";
    }

    
    @PostMapping("/Map/Insert")
    @ResponseBody //이렇게 선언해야 ajax 데이타 받을 수 있음
    public String insert(@RequestBody CMarker vo) throws JsonProcessingException {
    	System.out.println(vo.getCar_number());
        int cnt=service.updateMarker(vo);
        Map<String, Object> result=new HashMap<>();
        	
        result.put("cnt", cnt);
        String json=null;
        json=objectMapper.writeValueAsString(result);
        return json;
    }
    
    //대여 정보 삽입
    @PostMapping("/Map/rentInsert")
    @ResponseBody //이렇게 선언해야 ajax 데이타 받을 수 있음
    public String insert(@RequestBody CReturnVo vo)  {
    	vo.setReturn_region_id(1);
    	String result="";
    	System.out.println("vo=>>>>>>>>>>>>>>>>>>>>>>>"+vo);
    	if(reService.insertRent(vo)==1) {
    		result="success";
          return result;
    	}
    	return"";
    }
    //결제창 넘기기
    @GetMapping("/Map/payment")
    public String payment(CMarkerJoinCarDTO dto,Model model,HttpSession session) {
    	CMemberVo vo= (CMemberVo) session.getAttribute("vo");
    	CReturnVo rvo=reService.selectById(vo.getId());
    	model.addAttribute("dto",dto);
    	model.addAttribute("rvo",rvo);
    	System.out.println("rvo=>>>>>>>>>"+rvo);
        return "/product/payment";
    }


}
