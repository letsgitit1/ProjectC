package com.mvc.carshare.dao;
//이동해

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.carshare.vo.CcarDto;
import com.mvc.carshare.vo.CcarVo;

@Mapper
public interface CCarDao {

	//차량등록
	int carReg(CcarVo vo);
	
	//내차조회
	List<CcarDto>carSel(String username);
	
	//평점
	int carSc(int car_number);
	
	//테스트
	List<Integer> getCarNum(String username);
	
}
