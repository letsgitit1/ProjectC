package com.mvc.carshare.dao;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.carshare.vo.CProductVo;
import com.mvc.carshare.vo.CWishListVo;
@Mapper
public interface CProductDao {
	List<CProductVo> SelectAll();
	int wishlist_insert(CWishListVo vo);
	int check_wish(CWishListVo vo);
	int wishlist_delete(CWishListVo vo);
	CProductVo selectCarByCar_number(int car_number);
	List<Integer> wishCount(int user_id);
}
