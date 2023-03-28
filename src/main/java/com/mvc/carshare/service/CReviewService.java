package com.mvc.carshare.service;
//이동해
import org.springframework.stereotype.Service;

import com.mvc.carshare.dao.CReviewDao;


@Service
public class CReviewService {

	private CReviewDao dao;
	
	public CReviewService(CReviewDao dao) {
		this.dao = dao;
	}
}
