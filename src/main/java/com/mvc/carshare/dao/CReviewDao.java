package com.mvc.carshare.dao;
//이동해

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.carshare.vo.CReviewVo;

@Mapper
public interface CReviewDao {

	//차량고유번호로 차량 모든 리뷰 조회
	List<CReviewVo> creviewOne(int car_number);
	
	//내가쓴 리뷰 조회
	List<CReviewVo> writebyme(int author_id);
	
}
