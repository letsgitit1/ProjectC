package com.mvc.carshare.service;

import org.springframework.stereotype.Service;


import com.mvc.carshare.dao.CRegistrationsDao;
import com.mvc.carshare.vo.CRegistrationsVo;

@Service
public class CRegistrationsService {
private CRegistrationsDao dao;
public CRegistrationsService (CRegistrationsDao dao) {this.dao=dao;}
	public CRegistrationsVo selectRegByCarNumber (int car_number) {
		return dao.selectRegByCarNumber(car_number);
		}
	public int insertReg(CRegistrationsVo vo) {
		return dao.insertReg(vo);
	}
	
}
