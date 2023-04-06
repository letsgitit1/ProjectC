package com.mvc.carshare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.carshare.vo.CPaymentDTO;

@Mapper
public interface CPaymentDao {
	public List<CPaymentDTO> getDaily();
	public List<CPaymentDTO> getWeeks();
	public List<CPaymentDTO> getMonths();
	public List<CPaymentDTO> getYears();
}