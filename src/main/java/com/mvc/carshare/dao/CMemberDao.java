package com.mvc.carshare.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.carshare.vo.CMemberVo;

@Mapper
public interface CMemberDao {
	public void remove(String email);
	public void modify(CMemberVo cMemberVo);
	public CMemberVo findByEmailAll(String email);
	public int findByEmail(String email);
	public String findByEamilAtRegisterId(int id);
}
