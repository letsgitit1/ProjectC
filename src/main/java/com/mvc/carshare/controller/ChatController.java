package com.mvc.carshare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.carshare.service.CMessageService;
import com.mvc.carshare.service.CSMemberService;
import com.mvc.carshare.vo.CChatmessageDTO;
import com.mvc.carshare.vo.CChatmessageVO;
import com.mvc.carshare.vo.CMemberVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@Slf4j
public class ChatController {
	
	private final CMessageService cMessageService;
	private final CSMemberService cMemberService;
//	채팅방 페이지
    @GetMapping("/chat")
    public String chatGet(Model model,int roomId, HttpServletRequest request) {
    	
    	HttpSession session = request.getSession(); // 세션 가져오기
    	CMemberVo vo= (CMemberVo) session.getAttribute("vo");
    	int id = cMemberService.findByEmail(vo.getEmail());	//외부에서 전달받은 id 값 넣어주기, 세션에 담긴 이메일로 pk(id값) 가져오기
    	
//    	값이 비어있으면 실행
    	if(cMessageService.getList(roomId).isEmpty()) {
    		System.out.println("들어옴" + cMessageService.getList(roomId).isEmpty());
    		model.addAttribute("list", cMessageService.getList(roomId));
    		model.addAttribute("check", cMessageService.getList(roomId).isEmpty());
    	}else {
    		model.addAttribute("list", cMessageService.getList(roomId));
    	}
    	
    	model.addAttribute("id", id);
        model.addAttribute("email", vo.getEmail());
        model.addAttribute("roomId", roomId);
        
        
        
        
        
        return "chat";
    }
//  실시간 메세지 저장  
    @PostMapping("/chat/message")
    @ResponseBody
    public void register(@RequestBody CChatmessageVO cChatmessageVO,HttpServletRequest request) {
    	HttpSession session = request.getSession(); // 세션 가져오기
    	CMemberVo vo= (CMemberVo) session.getAttribute("vo");

    	cMessageService.register(cChatmessageVO);
    }
    
    
    
}