


package com.mvc.carshare.service;

//이동해
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.mvc.carshare.dao.CMemberDao;
import com.mvc.carshare.vo.CMemberVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CMemberService {
	@Autowired
	private CMemberDao dao;
	
	public CMemberService(CMemberDao dao) {
		this.dao = dao;
	}
	
	//회원가입
	public int member_reg(CMemberVo vo) {
		
		return dao.member_reg(vo);
	}
	
	//로그인
	public CMemberVo login(String email, String password) {
		
		Map<String, String> map = new HashMap<>();
		map.put(email, email);
		map.put(password, password);
		return dao.login(map);
	}
	
	public CMemberVo login(Map<String, String> map) {
		return dao.login(map);
	}
	
	//ajax 아이디 확인
	public int idCheck(String email) {
        return dao.idCheck(email);
    }
	
	//ajax 닉네임 확인
	public int nameCheck(String name) {
		return dao.nameCheck(name);
	}
	
	//ajax 닉네임 확인
	public int lisenseCheck(String driver_license_number) {
		return dao.lisenseCheck(driver_license_number);
	}
	
//	//로그인 확인
//	public int loginCheck(String email, String password) {
//		
//		return dao.loginCheck(email, password);
//	}

	
	

	//아이디 찾기
	public String find_id(CMemberVo vo) {
		
		return dao.find_id(vo);
	}
	
	//비밀번호 찾기
	public String find_pass(CMemberVo vo) {
		
		return dao.find_pass(vo);
	}

	
	//비밀번호 메일로보내기
	@Autowired
	public JavaMailSender javaMailSender;

	@Async
	public void sendMail(String email, String pass) {
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		simpleMessage.setFrom("ehdgo173@naver.com"); // NAVER, DAUM, NATE일 경우 넣어줘야 함
		//Naver 외에는 발신자 주소가 승인되지 않음 
		//다른ID 써도 안댐
//		wpfflajrdj@naver.com 경현
//		cjw5006@naver.com 재우
		System.out.println("service pass : " + pass);
		simpleMessage.setTo(email);
		simpleMessage.setSubject("회원님의 비밀번호 입니다.");
		simpleMessage.setText("비밀번호 : " + pass);
		
		javaMailSender.send(simpleMessage);
	}
	  public CMemberVo selectOne(int id) { return dao.selectOne(id); }
	  
	  
}
