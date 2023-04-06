package com.mvc.carshare.dao;
//이동해

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.carshare.vo.CMDto;
import com.mvc.carshare.vo.CNotRegCarDto;
import com.mvc.carshare.vo.CcarDto;
import com.mvc.carshare.vo.CcarVo;

@Mapper
public interface CCarDao {

	//차량등록
	int carReg(CcarVo vo);
	
	//내차조회
	List<CcarDto>carSel(int username);
	
	//평점
	int carSc(int car_number);
	
	//테스트
	List<Integer> getCarNum(String username);
	
	CMDto memberByCar(Map<String, Object> params);
	
	List<CNotRegCarDto> notregcar(int owner_id);
	//자동차 삭제
	 int delete_car(CcarVo vo);
}
