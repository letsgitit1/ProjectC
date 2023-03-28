package com.mvc.carshare.dao;
//이동해

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.carshare.vo.CcarVo;

@Mapper
public interface CCarDao {

	//차량등록
	int carReg(CcarVo vo);
	
	//내차조회
	List<CcarVo>carSel(String username);
	
}
