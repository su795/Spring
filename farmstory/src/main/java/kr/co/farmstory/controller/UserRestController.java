package kr.co.farmstory.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.farmstory.service.UserService;

// 문자열과 Json을 출력하는 Controller		@ResponseBody + @Controller
@RestController
public class UserRestController {
	
	@Inject
	private UserService service;
	
	@GetMapping("/user/checkUid")
	public String checkUid(String uid) {
		
		int result = service.selectUserCount(uid);
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}
	@GetMapping("/user/checkNick")
	public String checkNick(String nick) {
		
		return null;
	}
	@GetMapping("/user/checkEmail")
	public String checkEmail(String email) {
		
		return null;
	}
	@GetMapping("/user/checkHp")
	public String checkHp(String hp) {
		
		return null;
	}

}
