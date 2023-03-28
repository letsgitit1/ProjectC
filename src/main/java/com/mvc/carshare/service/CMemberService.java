package com.mvc.carshare.service;
//이동해
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.carshare.dao.CMemberDao;
import com.mvc.carshare.vo.CMemberVo;

import lombok.extern.slf4j.Slf4j;

@Service
public class CMemberService {
	@Autowired
	private CMemberDao dao;
	
	public CMemberService(CMemberDao dao) {
		this.dao = dao;
	}
	
	//회원가입
	public int member_reg(CMemberVo vo) {
		
		return dao.member_reg(vo);
	}
	
	//로그인
	public CMemberVo login(String email, String password) {
		
		Map<String, String> map = new HashMap<>();
		map.put(email, email);
		map.put(password, password);
		return dao.login(map);
	}
	
	public CMemberVo login(Map<String, String> map) {
		return dao.login(map);
	}
	
	//ajax 아이디 확인
	public int idCheck(String email) {
        return dao.idCheck(email);
    }
	
	  public CMemberVo selectOne(int id) { return dao.selectOne(id); }
	 
	
	
}

