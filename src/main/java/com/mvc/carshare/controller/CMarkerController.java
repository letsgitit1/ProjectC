package com.mvc.carshare.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@Controller
public class CMarkerController {

    private ObjectMapper objectMapper= new ObjectMapper();
    private CMarkerService service;
    private CProductService pservice;
    private CRegistrationsService rservice;

    public CMarkerController(CMarkerService service ,CProductService pservice , CRegistrationsService  rservice ){
        this.service= service; //marker
        this.pservice= pservice; //product
        this.rservice= rservice; //reg
    }

    @GetMapping("/Map/MapTestKyung")
    public String map(Model model) {

        List<CMarkerJoinCarDTO> list = null;
        list = service.getAllMarkersJoinCars();
        System.out.println(list);
        model.addAttribute("markers" ,list);

        return"Map/MapTestKyung";
    }

    @PostMapping("/Map/Insert")
    @ResponseBody //이렇게 선언해야 ajax 데이타 받을 수 있음
    public String insert(@RequestBody CMarker vo) throws JsonProcessingException {
        System.out.println(vo);
        vo.setCar_number(1);
        int cnt=service.insertMarker(vo);
        Map<String, Object> result=new HashMap<>();
        System.out.println(vo);

        result.put("cnt", cnt);
        String json=null;
        json=objectMapper.writeValueAsString(result);
        return json;
    }
}

