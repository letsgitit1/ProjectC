package com.mvc.carshare.service;

import org.springframework.stereotype.Service;

import com.mvc.carshare.dao.CReturnDao;
import com.mvc.carshare.vo.CReturnVo;

@Service
public class CReturnService {
	private CReturnDao dao;
	public CReturnService(CReturnDao dao) {
		this.dao=dao;
	}
	public CReturnVo selectById(int id) {
		return dao.selectById(id);
	}
}
