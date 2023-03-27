package com.mvc.carshare.service;
import org.springframework.beans.factory.annotation.Autowired;
//이동해
import org.springframework.stereotype.Service;

import com.mvc.carshare.dao.CReviewDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CReviewService {

	@Autowired
	private CReviewDao dao;
	
	public CReviewService(CReviewDao dao) {
		this.dao = dao;
	}
}
