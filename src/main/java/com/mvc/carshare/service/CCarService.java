package com.mvc.carshare.service;
//이동해

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.carshare.dao.CCarDao;
import com.mvc.carshare.vo.CcarVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CCarService {

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
	public List<CcarVo> getCarList(String id) {
		log.info("service id = {}", id);
		return dao.carSel(id);
	}
	
	
}
