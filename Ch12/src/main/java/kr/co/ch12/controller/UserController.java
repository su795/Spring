package kr.co.ch12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ch12.service.UserService;
import kr.co.ch12.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/user/register")
	public String register() {
		return "/user/register";
	}
	@PostMapping("/user/register")
	public String register(UserVo vo) {
		
		service.insertUser(vo);
		
		return "redirect:/user/list";
	}
	@GetMapping("/user/list")
	public String list(Model model) {
		
		List<UserVo> users = service.selectUsers();		
		model.addAttribute("users", users);
		
		return "/user/list";
	}
	
	// Json 객체 전송용 어노테이션
	
	@ResponseBody	
	@GetMapping("/user/listSort")
	public List<UserVo> listSort(String sort) {
		
		List<UserVo> users = service.selectUsersOrderBy(sort);	
		
		return users;
	}
	
	@GetMapping("/user/modify")
	public String modify(String uid, Model model) {
		
		UserVo user = service.selectUser(uid);
		model.addAttribute(user);
		
		return "/user/modify";
	}
	@PostMapping("/user/modify")
	public String modify(UserVo vo, Model model) {
		
		service.updateUser(vo);
		
		return "redirect:/user/list";
	}
	@GetMapping("/user/delete")
	public String delete(String uid) {
		
		service.deleteUser(uid);		
		
		return "redirect:/user/list";
	}
}
