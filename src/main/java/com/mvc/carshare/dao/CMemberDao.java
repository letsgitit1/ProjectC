package com.mvc.carshare.dao;
//이동해
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

import com.mvc.carshare.vo.CMemberVo;

@Mapper
public interface CMemberDao {

	//회원가입
	int member_reg(CMemberVo vo);
	
	//로그인
	CMemberVo login(Map<String, String> map);
	
	//ajax 아이디 확인
	int idCheck (String email);

	//ajax 닉네임 확인
	int nameCheck (String name);
	
	//ajax 운전면허 확인
	int lisenseCheck (String name);
	
//	//로그인 확인
//	int loginCheck (String email, String password);
	
	//아이디 찾기
	String find_id (CMemberVo vo);
	
	//비밀번호 찾기
	String find_pass (CMemberVo vo);
	

	CMemberVo selectOne (int id);
	
	//상훈이형
		public void remove(String email);
		public void modify(CMemberVo cMemberVo);
		public CMemberVo findByEmailAll(String email);
		public int findByEmail(String email);
		public String findByEamilAtRegisterId(int id);
}

