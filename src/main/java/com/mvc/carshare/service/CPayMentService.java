package com.mvc.carshare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mvc.carshare.vo.CPaymentDTO;

@Service
public interface CPaymentService {
	public List<CPaymentDTO> getDaily();
	public List<CPaymentDTO> getWeeks();
	public List<CPaymentDTO> getMonths();
	public List<CPaymentDTO> getYears();
}
