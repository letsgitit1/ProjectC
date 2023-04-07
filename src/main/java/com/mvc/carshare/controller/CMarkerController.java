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
import com.mvc.carshare.vo.CMarker;
import com.mvc.carshare.vo.CMarkerJoinCarDTO;
import com.mvc.carshare.vo.CMarkerjoinCarDTO2;
import com.mvc.carshare.vo.CMemberVo;


@Controller
public class CMarkerController {

    private ObjectMapper objectMapper = new ObjectMapper();
    private CMarkerService service;
    private CProductService pservice;
    private CRegistrationsService rservice;

    public CMarkerController(CMarkerService service, CProductService pservice, CRegistrationsService rservice) {
        this.service = service; //marker
        this.pservice = pservice; //product
        this.rservice = rservice; //reg
    }

    @GetMapping("/Map/MapTestKyung")
    public String map(Model model,HttpSession session) {
        List<CMarkerJoinCarDTO> list = null;
        list = service.getAllMarkersJoinCars();
        model.addAttribute("markers", list);

        //테스트용찜
        CMemberVo vo= (CMemberVo) session.getAttribute("vo");
        model.addAttribute("user_id",vo.getId() );
        model.addAttribute("rent_id", 1);    // 임시데이터

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
        System.out.println(vo);
        System.out.println(list);
        model.addAttribute("markers", list);
        model.addAttribute("user_id",vo.getId()
        );
        model.addAttribute("rent_id", 1);    // 임시데이터

        // 해당 사용자가 찜한 상품 번호 리스트를 가져옴
        List<Integer> wishList = pservice.wishCount(vo.getId());
        model.addAttribute("wishList", wishList);
        return "Map/MapTestKyung2";
    }

    
    @PostMapping("/Map/Insert")
    @ResponseBody //이렇게 선언해야 ajax 데이타 받을 수 있음
    public String insert(@RequestBody CMarker vo) throws JsonProcessingException {
        vo.setCar_number(3);
        int cnt=service.insertMarker(vo);
        Map<String, Object> result=new HashMap<>();

        result.put("cnt", cnt);
        String json=null;
        json=objectMapper.writeValueAsString(result);
        return json;
    }

}
