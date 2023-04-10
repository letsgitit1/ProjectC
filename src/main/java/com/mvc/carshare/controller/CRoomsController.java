package com.mvc.carshare.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.mvc.carshare.service.CMarkerService;
import com.mvc.carshare.service.CMessageService;
import com.mvc.carshare.service.CRoomsService;
import com.mvc.carshare.service.CSMemberService;
import com.mvc.carshare.vo.CMemberDTO;
import com.mvc.carshare.vo.CMemberVo;
import com.mvc.carshare.vo.CRoomsVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@RequestMapping("/rooms/*")
public class CRoomsController {
	
	private final CRoomsService cRoomsService;
	
	private final CMessageService cMessageService;
	
	private final CSMemberService cMemberService;
	
	private final CMarkerService cMarkerService;
	
	
	
//	방 만드는 페이지		필요 없음
    @GetMapping("/register")

    public String register( Model model, int car_id,HttpSession request) {
    	
    	CMemberVo vo = (CMemberVo) request.getAttribute("vo");		//임시로 만든 세션에 담긴 값
    	model.addAttribute("email", vo.getEmail());
    	model.addAttribute("registrNum", cMarkerService.selectByCarid(car_id));

        return "rooms/register";
    }
    
//    방 만들고 나서 바로 방으로 이동	방 만들기 버튼 누르면 바로 실행
    @PostMapping("/register")
    public RedirectView register(CRoomsVO cRoomsVO,  HttpSession request,Model model) {
    	
    	CMemberVo vo = (CMemberVo) request.getAttribute("vo");		
    	model.addAttribute("email", vo.getEmail());
    	CMemberDTO cMemberDTO = new CMemberDTO();
    	cMemberDTO.setRegistrNum(cRoomsVO.getRegistrNum());
    	cMemberDTO.setEmail(vo.getEmail());
    	
		if(cRoomsService.checkRoom(cMemberDTO) != 0) {	//방을 만들때 이미 존재하는 방인지 체크, 맞으면 원래 있던 대화방으로 이동
			return new RedirectView("/chat?roomId=" + cRoomsService.checkRoom(cMemberDTO));
		}
    	
    	cRoomsService.register(cRoomsVO);
    	return new RedirectView("/chat?roomId=" + cRoomsService.getSeq());
    }
    
    //채팅방 목록 페이지
    @GetMapping("/rooms")
    public String getList(Model model, String email, HttpSession request) {
    	CMemberVo vo = (CMemberVo) request.getAttribute("vo");		
    	model.addAttribute("email", vo.getEmail());
    	
//    	방을 조회해서 채팅 기록이 없는 방은 삭제
    	for (CRoomsVO nulls : cRoomsService.contentIsNull()) {
			cRoomsService.removeRoom(nulls.getId());
		}
    	
//    	판매자가 등록했을때 나오는 방
    	model.addAttribute("list", cRoomsService.registerList(vo.getEmail())); 
    	
//    	구매자 리스트 가져오기
    	if(cMemberService.findByEamilAtRegisterEmail(vo.getEmail()) != 1) {		//판매 번호로 이메일 조회, 로그인 한 사람이 판매자인지 조회(판매자는 구매 불가)
    		if(cMessageService.getListByEamil(vo.getEmail()) != 0) {			//보낸 사람의 채팅기록이 있을때 리스트 전달
    			model.addAttribute("list", cRoomsService.getList(vo.getEmail()));
    		}    		
    	}
    		
    	model.addAttribute("email", vo.getEmail());
        return "rooms/rooms";
    }
//  채팅방 삭제
    @GetMapping("/remove")
    public String remove(int id, Model model, HttpSession request) {
    	CMemberVo vo = (CMemberVo) request.getAttribute("vo");		//임시로 만든 세션에 담긴 값
    	model.addAttribute("email", vo.getEmail());
    	
    	cRoomsService.removeRoom(id);
    	
    	if(cMessageService.getListByEamil(vo.getEmail()) != 0) {	//채팅기록이 있을때 리스트 전달
    		model.addAttribute("list", cRoomsService.getList(vo.getEmail()));
    	} 
    	
    	model.addAttribute("email", vo.getEmail());
    	
    	return "rooms/rooms";
    }
    
    
    
}