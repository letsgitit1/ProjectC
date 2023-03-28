package com.mvc.carshare.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.carshare.vo.CMemberVo;

@Mapper
public interface CMemberDao {
	CMemberVo selectOne (int id);
}
