package kr.co.kmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kmarket.service.MemberService;
import kr.co.kmarket.vo.ResultVo;

// @Controller는 주로 View를 반환하기 위해 사용 - data를 반환하기 위해서는 @ResponseBody 어노테이션을 활용

// @RestController는 Spring MVC Controller에 @ResponseBody가 추가된 것
// 주용도는 Json 형태로 객체 데이터를 반환

@RestController
public class MemberRestController {

	@Autowired
	private MemberService service;
	
	@GetMapping("/member/checkUid")
	public ResultVo checkUid(String uid) {
		
		return service.selectCountUid(uid);		
	}
}
