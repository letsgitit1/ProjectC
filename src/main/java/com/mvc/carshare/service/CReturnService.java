package com.mvc.carshare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mvc.carshare.dao.CReturnDao;
import com.mvc.carshare.vo.CReturnVo;
import com.mvc.carshare.vo.RentDto;

@Service
public class CReturnService {
	private CReturnDao dao;
	public CReturnService(CReturnDao dao) {
		this.dao=dao;
	}
	public CReturnVo selectById(int id) {
		return dao.selectById(id);
	}
	public List<RentDto> ReturnDate() {
		return dao.ReturnDate();
	}
}
