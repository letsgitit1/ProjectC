package com.mvc.carshare.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.carshare.vo.CRegistrationsVo;

@Mapper
public interface CRegistrationsDao {
	CRegistrationsVo selectRegByCarNumber (int car_number);
	int insertReg(CRegistrationsVo vo);
}
