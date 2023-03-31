package com.mvc.carshare.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//이동해
import org.springframework.stereotype.Service;

import com.mvc.carshare.dao.CReviewDao;
import com.mvc.carshare.vo.CReviewVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CReviewService {

	@Autowired
	private CReviewDao dao;
	
	public CReviewService(CReviewDao dao) {
		this.dao = dao;
	}
	
	//차량고유번호로 차량 모든 리뷰 조회
	public List<CReviewVo> creviewOne(int car_number) {
		log.info("CreviewService id   --- {} ---",car_number);
		return dao.creviewOne(car_number);
	}
	
	//내가쓴 리뷰 조회
	public List<CReviewVo> writebyme(int author_id) {
		
		return dao.writebyme(author_id);
	}
}
