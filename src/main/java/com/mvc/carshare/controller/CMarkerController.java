package com.mvc.carshare.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvc.carshare.service.CMarkerService;
import com.mvc.carshare.vo.CMarker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CMarkerController {


    private CMarkerService service;

    public CMarkerController(CMarkerService service) {
        this.service = service;
    }

        ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/MapTestKyung")
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
        return"/Map/MapTestKyung";
}



    }


