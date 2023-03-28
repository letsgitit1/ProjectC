package com.mvc.carshare.dao;

import java.util.List;

import com.mvc.carshare.vo.CMarker;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CMarkerDao {



    public List<CMarker> getAllMarkers();


}