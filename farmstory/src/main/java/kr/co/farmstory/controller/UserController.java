package kr.co.farmstory.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.farmstory.vo.TermsVO;
import kr.co.farmstory.vo.UserVO;
import kr.co.farmstory.service.UserService;

@Controller
public class UserController {

	@Inject
	private UserService service;
	
	@GetMapping("/user/login")
	public String login(String uid, String pass) {
		
		
		return "/user/login";
	}
	@PostMapping("/user/login")
	public String login(UserVO vo, HttpSession sess) {
		UserVO user = service.selectUser(vo);		
		if(user == null) {
			return "redirect:/user/login?success=fail";
		}else {
			sess.setAttribute("user", user);
			return "redirect:/index";
		}
	}
	
	@GetMapping("/user/logout")
	public String logout() {
		return "/user/login";
	}
	
	@GetMapping("/user/terms")
	public String terms(Model model) {
		
		TermsVO vo = service.selectTerms();
		model.addAttribute(vo);
		
		return "/user/terms";
	}
	
	@GetMapping("/user/register")
	public String register() {
		
		return "/user/register";
	}
	@PostMapping("/user/register")
	public String register(UserVO vo, HttpServletRequest req) {
		
		vo.setRegip(req.getRemoteAddr());		
		service.insertUser(vo);
		
		return "/user/register";
	}
}
