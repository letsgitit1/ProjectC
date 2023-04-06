package com.mvc.carshare.service;

import org.springframework.stereotype.Service;

import com.mvc.carshare.vo.CMemberVo;

@Service
public interface CSMemberService {
	public void remove(String email);
	public void modify(CMemberVo cMemberVo);
	public CMemberVo findByEmailAll(String email);
	public int findByEmail(String email);
	public String findByEamilAtRegisterId(int id);
}
