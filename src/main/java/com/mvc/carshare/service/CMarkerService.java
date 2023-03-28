package com.mvc.carshare.service;

import com.mvc.carshare.dao.CMarkerDao;
import com.mvc.carshare.dao.CProductDao;
import com.mvc.carshare.vo.CMarker;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CMarkerService {

    private CMarkerDao dao;


    public CMarkerService(CMarkerDao dao) { this.dao=dao;}
    public List<CMarker> getAllMarkers() {
        return dao.getAllMarkers();
    }

}
