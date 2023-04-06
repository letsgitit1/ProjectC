package com.mvc.carshare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.carshare.vo.CReturnVo;
import com.mvc.carshare.vo.RentDto;

@Mapper
public interface CReturnDao {
	CReturnVo selectById (int id);
	List<RentDto> ReturnDate();
}
