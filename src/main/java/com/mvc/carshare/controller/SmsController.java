package com.mvc.carshare.controller;
 
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mvc.carshare.service.CMemberService;
import com.mvc.carshare.service.CReturnService;
import com.mvc.carshare.service.SmsService;
import com.mvc.carshare.vo.CMemberVo;
import com.mvc.carshare.vo.MessageDTO;
import com.mvc.carshare.vo.RentDto;
import com.mvc.carshare.vo.SmsResponseDTO;

import lombok.RequiredArgsConstructor;
 
@EnableScheduling
@Controller
@RequiredArgsConstructor
public class SmsController {
	
	private final SmsService smsService;
	private final CReturnService reService;
	private final CMemberService mService;
	
//	  @Scheduled(cron = "0 * * * * ?") // 매 분 0초에 실행
//	    public void scheduleSendReservationSms() throws JsonProcessingException, RestClientException, InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException, URISyntaxException {
//		  List<RentDto> list=reService.ReturnDate();
//		  for(int i=0; i<list.size(); i++) {
//			  System.out.println(list);
//			  long remainingMillis = list.get(i).getRemaining_time().getTime();
//			  Timestamp currentTime = new Timestamp(System.currentTimeMillis());
//			  long currentMillis = currentTime.getTime();
//			  long timeDiffMillis = remainingMillis-currentMillis ;
//				  long timeDiffMinutes = TimeUnit.MILLISECONDS.toMinutes(timeDiffMillis);
//				  if((timeDiffMinutes/60)==1) { //반납시간 한시간남은 차량에게 아래 로직실행
//					  CMemberVo mvo=mService.selectOne(list.get(i).getUser_id());
//					  String content=mvo.getName()+"님 "+"자동차 공유 사이트 Budy입니다. 회원님의 자동차 반납이 1시간 남았습니다.";
//					  System.out.println(mvo);  
//					  MessageDTO messageDto=new MessageDTO(mvo.getPhone_number(),content);
//					  SmsResponseDTO response = smsService.sendSms(messageDto);
//					  System.out.println(response);
//				  }
//				else if((timeDiffMinutes/60)<0) {
//	  				CMemberVo mvo=mService.selectOne(list.get(i).getUser_id());
//	  				String content=mvo.getName()+"님 "+"자동차 반납시간이 지났습니다. 추가 요금이 발생할 수 있습니다.";
//	  				MessageDTO messageDto=new MessageDTO(mvo.getPhone_number(),content);
//	  				SmsResponseDTO response = smsService.sendSms(messageDto);
//				}
//				  }
//		  }
	    }
