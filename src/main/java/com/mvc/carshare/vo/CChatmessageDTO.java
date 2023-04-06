package com.mvc.carshare.vo;

import lombok.Data;

@Data
public class CChatmessageDTO {
	int id;				//메세지 번호
    int chat_room_id;	//채팅방 번호
    int sender_id;		//보낸 사람
    String content;		//채팅 내용
    String created_at;	//채팅 작성 날짜
    String name;		//보낸 사람 닉네임(적용안함, 나중에 할 예정)
    String email;		//보낸 사람 이메일(세션값으로 기본 적용되있음, 채팅하면 이 값이 아이디처럼 사용됨)
}
