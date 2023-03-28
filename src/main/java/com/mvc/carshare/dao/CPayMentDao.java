package com.mvc.carshare.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.carshare.vo.CPayMentVo;
@Mapper
public interface CPayMentDao {
	int paymentInsert(CPayMentVo vo);
}
