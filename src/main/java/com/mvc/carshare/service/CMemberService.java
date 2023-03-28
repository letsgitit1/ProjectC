package com.mvc.carshare.service;

import org.springframework.stereotype.Service;

import com.mvc.carshare.dao.CMemberDao;
import com.mvc.carshare.vo.CMemberVo;

@Service
public class CMemberService {
	private CMemberDao dao;
	public CMemberService(CMemberDao dao) {
		this.dao=dao;
	}
	public CMemberVo selectOne(int id) {
		return dao.selectOne(id);
	}
}
