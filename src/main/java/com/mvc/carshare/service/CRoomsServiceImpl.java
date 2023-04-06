package com.mvc.carshare.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.mvc.carshare.dao.CRoomsDao;
import com.mvc.carshare.vo.CMemberDTO;
import com.mvc.carshare.vo.CRoomsVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CRoomsServiceImpl implements CRoomsService {

	private final CRoomsDao cRoomsDao;
	
	@Override
	public void register(CRoomsVO cRoomsVO) {
		cRoomsDao.register(cRoomsVO);
	}

	@Override
	public List<CRoomsVO> getList(String email) {
		List<CRoomsVO> list = cRoomsDao.getList(email);
		return list;
	}

	@Override
	public int getSeq() {
		return cRoomsDao.getSeq();
	}

	@Override
	public List<CRoomsVO> contentIsNull() {
		List<CRoomsVO> list = cRoomsDao.contentIsNull();
		return list;
	}

	@Override
	public void removeRoom(int id) {
		cRoomsDao.removeRoom(id);
	}

	@Override
	public List<CRoomsVO> registerList(String email) {
		List<CRoomsVO> list = cRoomsDao.registerList(email);
		return list;
	}

	@Override
	public int checkRoom(CMemberDTO cMemberDTO) {
		return cRoomsDao.checkRoom(cMemberDTO);
	}

}
