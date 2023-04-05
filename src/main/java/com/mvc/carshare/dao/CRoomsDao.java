package com.mvc.carshare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.carshare.vo.CMemberDTO;
import com.mvc.carshare.vo.CRoomsVO;

@Mapper
public interface CRoomsDao {
	void register(CRoomsVO cRoomsVO);					//방 만들기
	public List<CRoomsVO> getList(String email);		//이메일로 대화방 목록 조회
	public int getSeq();								//시퀀스 값 가져오기
	public List<CRoomsVO> contentIsNull();				//대화내용 없는 방 조회
	public void removeRoom(int id);						//방 삭제
	public List<CRoomsVO> registerList(String email);	//판매자의 메신저 방(판매자의 대화 내용이 없어도 상대방이 대화를 남겨놨을때 생성됨)
	public int checkRoom(CMemberDTO cMemberDTO);		//기존에 대화중인 방이 있는지 검사
}
