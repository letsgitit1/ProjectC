package com.mvc.carshare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mvc.carshare.dao.CProductDao;
import com.mvc.carshare.vo.CProductVo;
import com.mvc.carshare.vo.CWishListVo;
@Service
public class CProductService {
	private CProductDao dao;
	
	public CProductService(CProductDao dao) {
		this.dao=dao;
	}
	
	public List<CProductVo> SelectAll(){
		return dao.SelectAll();
	}
	
	public int wishlist_insert(CWishListVo vo) {
		return dao.wishlist_insert(vo);
	}
	public int check_wish(CWishListVo vo) {
		return dao.check_wish(vo);
	}
	public int wishlist_delete(CWishListVo vo) {
		return dao.wishlist_delete(vo);
	}
	public CProductVo selectCarByCar_number(int car_number) {
		return dao.selectCarByCar_number(car_number);
	}
	public List<Integer> wishCount(int user_id){
		return dao.wishCount(user_id);
	}
	
}
