
package com.mvc.carshare.dao;
//이동해
import java.util.Map;


import org.apache.ibatis.annotations.Mapper;

import com.mvc.carshare.vo.CMemberVo;

@Mapper
public interface CMemberDao {

	//회원가입
	int member_reg(CMemberVo vo);
	
	//로그인
	CMemberVo login(Map<String, String> map);
	
	//아이디 확인
	int idCheck (String email);
	
	CMemberVo selectOne (int id);
}

