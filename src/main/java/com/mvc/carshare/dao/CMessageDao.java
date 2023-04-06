package com.mvc.carshare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.carshare.vo.CChatmessageDTO;
import com.mvc.carshare.vo.CChatmessageVO;

@Mapper
public interface CMessageDao {
	void register(CChatmessageVO cChatmessageVO);		//채팅 내용 저장
	List<CChatmessageDTO> getList(int chat_room_id);	//해당 채팅방에 채팅 목록 리스트 불러오기
	int getListByEamil(String email);					//채팅 기록중에 해당하는 이메일로 채팅 기록이 있는지 확인
}
