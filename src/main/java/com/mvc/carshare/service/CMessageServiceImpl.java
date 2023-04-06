package com.mvc.carshare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.carshare.dao.CMessageDao;
import com.mvc.carshare.vo.CChatmessageDTO;
import com.mvc.carshare.vo.CChatmessageVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CMessageServiceImpl implements CMessageService {

	@Autowired
	private final CMessageDao cMessageDao;
	
	//채팅 내용 저장
	@Override
	public void register(CChatmessageVO cChatmessageVO) {
		cMessageDao.register(cChatmessageVO);
	}
	
	//해당 채팅방에 채팅 목록 리스트 불러오기
	@Override
	public List<CChatmessageDTO> getList(int chat_room_id) {
		List<CChatmessageDTO> list = cMessageDao.getList(chat_room_id);
		return list;
	}

	//채팅 기록중에 해당하는 이메일로 채팅 기록이 있는지 확인
	@Override
	public int getListByEamil(String email) {
		return cMessageDao.getListByEamil(email);
	}

}
