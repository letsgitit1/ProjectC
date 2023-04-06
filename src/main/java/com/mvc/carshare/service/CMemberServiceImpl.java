package com.mvc.carshare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.carshare.dao.CMemberDao;
import com.mvc.carshare.vo.CMemberVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CMemberServiceImpl implements CSMemberService {

	@Autowired
	private final CMemberDao cMemberDao;
	
	@Override
	public void remove(String email) {
		cMemberDao.remove(email);
	}

	@Override
	public void modify(CMemberVo cMemberVo) {
		cMemberDao.modify(cMemberVo);
	}

	@Override
	public CMemberVo findByEmailAll(String email) {
		return cMemberDao.findByEmailAll(email);
	}

	@Override
	public int findByEmail(String email) {
		return cMemberDao.findByEmail(email);
	}

	@Override
	public String findByEamilAtRegisterId(int id) {
		return cMemberDao.findByEamilAtRegisterId(id);
	}
	
	

}
