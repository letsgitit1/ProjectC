package com.mvc.carshare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.carshare.vo.CReturnVo;
import com.mvc.carshare.vo.RentDto;

@Mapper
public interface CReturnDao {
	CReturnVo selectById (int id);
	List<RentDto> ReturnDate();
	//이동해
	//반납한 차량중 리뷰안쓴 차량 조회
	List<CReturnVo> retunCarNotreview(int user_id);

	 public int insertRent(CReturnVo vo);

}
