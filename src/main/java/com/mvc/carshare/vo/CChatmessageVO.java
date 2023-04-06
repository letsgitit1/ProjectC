package com.mvc.carshare.vo;

import lombok.Data;

@Data
public class CChatmessageVO {
	int id;				//메세지 번호
    int chat_room_id;	//채팅방 번호
    int sender_id;		//보낸 사람
    String content;		//채팅 내용
    String created_at;	//채팅 작성 날짜
}
