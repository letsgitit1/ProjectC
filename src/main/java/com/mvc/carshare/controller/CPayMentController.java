package com.mvc.carshare.controller;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvc.carshare.service.CMarkerService;
import com.mvc.carshare.service.CMemberService;
import com.mvc.carshare.service.CProductService;
import com.mvc.carshare.service.CRegistrationsService;
import com.mvc.carshare.service.CReturnService;
import com.mvc.carshare.service.CSPaymentService;
import com.mvc.carshare.vo.CMemberVo;
import com.mvc.carshare.vo.CPayMentVo;
import com.mvc.carshare.vo.CProductVo;
import com.mvc.carshare.vo.CRegistrationsVo;
import com.mvc.carshare.vo.CReturnVo;

@Controller
public class CPayMentController {
	private final String SECRET_KEY = "test_sk_ODnyRpQWGrNdJ2vGWe23Kwv1M9EN";
	private final RestTemplate restTemplate = new RestTemplate();
	private ObjectMapper objectMapper = new ObjectMapper();
	private CProductService cService; //상품서비스
	private CMemberService mService; //회원서비스
	private CRegistrationsService rService; //판매등록서비스
	private CReturnService reService; //반납서비스
	private CSPaymentService pService; //결제서비스
	private CMarkerService cmservice; //마커서비스

	public CPayMentController(CSPaymentService pService,CProductService cService, CMemberService mService, CRegistrationsService rService,
			CReturnService reService,CMarkerService cmservice, CSPaymentService service) {
		this.cService = cService; // Car
		this.mService = mService; // member
		this.rService = rService; // Registration
		this.reService = reService; // rent
		this.pService=pService; //payment
		this.cmservice=cmservice;
	}

	@GetMapping("/product/payment")
	public String paymentView(@RequestParam("user_id") int user_id, @RequestParam("car_id") int car_id,
			@RequestParam("rent_id") int rent_id, Model model) {
		CProductVo cvo = cService.selectCarByCar_number(car_id);
		CMemberVo mvo = mService.selectOne(user_id);
		CRegistrationsVo rvo = rService.selectRegByCarNumber(car_id);
		CReturnVo revo = reService.selectById(rent_id);
		//
		model.addAttribute("cvo", cvo); // Car
		model.addAttribute("mvo", mvo); // member
		model.addAttribute("rvo", rvo); // Registration
		model.addAttribute("revo", revo); // rent
		return "/product/payment";
	}
	
	@GetMapping("/product/paymentSuccess")
	public String payMentSuccess(@RequestParam String paymentKey, @RequestParam String orderId,
			@RequestParam int amount, @RequestParam Map<String, String> map, Model model)
			throws JsonProcessingException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Basic " + Base64.getEncoder().encodeToString((SECRET_KEY + ":").getBytes()));
		headers.setContentType(MediaType.APPLICATION_JSON);
		String result = "";
		Map<String, String> payloadMap = new HashMap<>();
		payloadMap.put("orderId", orderId);
		payloadMap.put("amount", String.valueOf(amount));

		HttpEntity<String> request = new HttpEntity<>(objectMapper.writeValueAsString(payloadMap), headers);
		ResponseEntity<JsonNode> responseEntity = restTemplate
				.postForEntity("https://api.tosspayments.com/v1/payments/" + paymentKey, request, JsonNode.class);
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			JsonNode successNode = responseEntity.getBody();
			// 데이터베이스에 들어갈 변수 초기화
			int rid = Integer.parseInt(map.get("rid"));
			int reg_id = Integer.parseInt(map.get("reid"));
			int return_number = Integer.parseInt(map.get("rid"));
			int payer_id = Integer.parseInt(map.get("mid")); 
			int marker_id=Integer.parseInt(map.get("cmid"));
			String payment_method = successNode.get("method").asText();
			int price = amount;
			String payment_date = successNode.get("approvedAt").asText();
			OffsetDateTime odt = OffsetDateTime.parse(payment_date);
			Timestamp ts = Timestamp.from(odt.toInstant());
			CPayMentVo vo = new CPayMentVo(rid, reg_id, return_number, payer_id, payment_method, price, ts);
			// 생성자에 불러온 값 저장하기
			model.addAttribute("orderId", successNode.get("orderId").asText());
			pService.paymentInsert(vo);
			reService.updateReturn(payer_id);
			cmservice.markerDelete(marker_id);
			String secret = successNode.get("secret").asText(); // 가상계좌의 경우 입금 callback 검증을 위해서 secret을 저장하기를 권장함
			result = "/product/paymentSuccess";
		} else {
			JsonNode failNode = responseEntity.getBody();
			model.addAttribute("message", failNode.get("message").asText());
			model.addAttribute("code", failNode.get("code").asText());
			result = "/product/fail";
		}
		return result;
	}

	//마이페이지 페이지로 이동 동해 테스트중
	   @GetMapping("/mypage")
	 public String mypage(Model model, HttpServletRequest request) {
		   
		HttpSession session = request.getSession();
		CMemberVo vo = (CMemberVo) session.getAttribute("vo");
		int payer_id = vo.getId();
		List<CPayMentVo> list=pService.paymentlist(payer_id);
		System.out.println(vo);
		System.out.println("마이페이지 !!!!id = " + payer_id);
		System.out.println("멤버컨트롤 확인중입니당^^" + list );
		   
		model.addAttribute("list",list);
		pService.paymentlist(payer_id);
	      return "/member/mypage";
	   }
	
	
}
