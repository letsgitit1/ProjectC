package com.mvc.carshare.vo;
//이동해
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CMemberVo {
	int id;							//회원아이디(회원번호)
	String email;					//이메일(사실상ID)
	String username;				//이름
	String password;				//비밀번호
	String name;					//닉네임
	int age;						//나이
	String gender;					//성별
	String address;					//주소
	String phone_number;			//핸드폰번호
	String driver_license_number;	//운전면허번호
	int point;						//포인트
	String mannerscore;				//매너지수
	String auth;					//권한
}