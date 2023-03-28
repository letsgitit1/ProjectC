package com.mvc.carshare.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.carshare.vo.CReturnVo;

@Mapper
public interface CReturnDao {
	CReturnVo selectById (int id);
}
