package com.mvc.carshare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mvc.carshare.dao.CPaymentDao;
import com.mvc.carshare.vo.CPaymentDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CPaymentServiceImpl implements CPaymentService {
	
	private final CPaymentDao cPaymentDao;
	
//	일별 매출 조회
	@Override
	public List<CPaymentDTO> getDaily() {
		List<CPaymentDTO> list = cPaymentDao.getDaily();
		return list;
	}

//	주별 매출 조회
	@Override
	public List<CPaymentDTO> getWeeks() {
		List<CPaymentDTO> list = cPaymentDao.getWeeks();
		return list;
	}

//	월별 매출 조회
	@Override
	public List<CPaymentDTO> getMonths() {
		List<CPaymentDTO> list = cPaymentDao.getMonths();
		return list;
	}

//	연간 매출 조회
	@Override
	public List<CPaymentDTO> getYears() {
		List<CPaymentDTO> list = cPaymentDao.getYears();
		return list;
	}

}