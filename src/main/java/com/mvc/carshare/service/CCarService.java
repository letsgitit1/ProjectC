package com.mvc.carshare.service;
//이동해

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.carshare.dao.CCarDao;
import com.mvc.carshare.vo.CMDto;
import com.mvc.carshare.vo.CNotRegCarDto;
import com.mvc.carshare.vo.CcarDto;
import com.mvc.carshare.vo.CcarVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CCarService {

	@Autowired
	private CCarDao dao;

	public CCarService(CCarDao dao) {
		this.dao = dao;
	}

	// 차량등록
	public int car_reg(CcarVo vo) {
		log.info("service vo = {}", vo);
		return dao.carReg(vo);
	}

	// 차량조회
	public List<CcarDto> getCarList(int id) {
		log.info("service id = {}", id);
		return dao.carSel(id);
	}
	
	//평점
	public int carSc(int car_number) {
		log.info("service car_number = {}", car_number);
		return dao.carSc(car_number);
	}
	
	//테스트
	public List<Integer> getCarNum(String id) {
		return dao.getCarNum(id);
	}
	
	public CMDto memberByCar(int id, int car_id) {
	    Map<String, Object> params = new HashMap<>();
	    params.put("id", id);
	    params.put("car_id", car_id);
	    return dao.memberByCar(params);
	}
	public List<CNotRegCarDto> notregcar(int owner_id) {
		return dao.notregcar(owner_id);
	}
	 //등록차량 삭제
	   public int delete_car(CcarVo vo) {
	      log.info("service carvo = {}",vo);
	      return dao.delete_car(vo);
	   }
	   public int insertCarMarker(int car_number) {
		   return dao.insertCarMarker(car_number);
	   }
	   
}
