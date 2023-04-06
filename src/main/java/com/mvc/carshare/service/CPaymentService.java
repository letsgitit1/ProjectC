package com.mvc.carshare.service;

import org.springframework.stereotype.Service;

import com.mvc.carshare.dao.CPayMentDao;
import com.mvc.carshare.vo.CPayMentVo;

@Service
public class CPayMentService {
private CPayMentDao dao;
	
	public CPayMentService(CPayMentDao dao) {
		this.dao=dao;
	}
	public int paymentInsert(CPayMentVo vo) {
		return dao.paymentInsert(vo);
	}
	
	
}
