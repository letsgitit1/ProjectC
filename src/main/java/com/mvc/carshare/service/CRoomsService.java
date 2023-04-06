package com.mvc.carshare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mvc.carshare.vo.CMemberDTO;
import com.mvc.carshare.vo.CRoomsVO;

@Service
public interface CRoomsService {
	void register(CRoomsVO cRoomsVO);
	public List<CRoomsVO> getList(String email);
	public int getSeq();
	public List<CRoomsVO> contentIsNull();
	public void removeRoom(int id);
	public List<CRoomsVO> registerList(String email);
	public int checkRoom(CMemberDTO cMemberDTO);
}
