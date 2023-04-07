package com.mvc.carshare.dao;

import java.util.List;

import com.mvc.carshare.vo.CMarker;
import com.mvc.carshare.vo.CMarkerJoinCarDTO;
import com.mvc.carshare.vo.CMarkerjoinCarDTO2;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CMarkerDao {


    public List<CMarker> getAllMarkers();
    public List<CMarkerJoinCarDTO> getAllMarkersJoinCars();
    public int insertMarker(CMarker vo);
    public int selectByCarid(int rid);
   public List<CMarkerjoinCarDTO2> selectBySell(int owner_id); 
}