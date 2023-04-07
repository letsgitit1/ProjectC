package com.mvc.carshare.service;

import com.mvc.carshare.dao.CMarkerDao;
import com.mvc.carshare.dao.CProductDao;
import com.mvc.carshare.vo.CMarker;
import com.mvc.carshare.vo.CMarkerJoinCarDTO;
import com.mvc.carshare.vo.CMarkerjoinCarDTO2;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CMarkerService {

    private CMarkerDao dao;


    public CMarkerService(CMarkerDao dao) { this.dao=dao;}
    
    public List<CMarker> getAllMarkers() {
        return dao.getAllMarkers();
    }

    public List<CMarkerJoinCarDTO> getAllMarkersJoinCars() {
        return dao.getAllMarkersJoinCars();
    }
    public int insertMarker(CMarker vo) {
    	return dao.insertMarker(vo);
    }
    public int selectByCarid(int rid) {
    	return dao.selectByCarid(rid);
    }
    public List<CMarkerjoinCarDTO2> selectBySell(int owner_id){
    	return dao.selectBySell(owner_id);
    }

}
