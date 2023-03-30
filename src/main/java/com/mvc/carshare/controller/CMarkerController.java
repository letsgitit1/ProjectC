package com.mvc.carshare.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvc.carshare.service.CMarkerService;
import com.mvc.carshare.service.CProductService;
import com.mvc.carshare.service.CRegistrationsService;
import com.mvc.carshare.vo.CMarker;
import com.mvc.carshare.vo.CProductVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CMarkerController {


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
//        List<CMarker> list = null;
//        list = service.getAllMarkers();
//        try {
//            String jsonString = mapper.writeValueAsString(list);
//        model.addAttribute("markers", jsonString);
//            System.out.println(jsonString);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
        List<CMarker> list = null;
        list = service.getAllMarkers();

        model.addAttribute("markers", list);
//        List <CProductVo> productlist =pservice.SelectAll();
//       model.addAttribute("carlist",productlist);

        return"Map/MapTestKyung";
}
    }


