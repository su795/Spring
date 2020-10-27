package kr.co.farmstory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.farmstory.service.BoardService;
import kr.co.farmstory.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/board/write")
	public String write(String group, String cate, Model model) {
		
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		
		return "/board/write";
	}
	
	@GetMapping("/board/list")
	public String list(String group, String cate, String pg, Model model) {
		
		int total 		 = service.selectCountBoard(cate);
		int pageEnd 	 = service.getPageEnd(total);
		int currentPage  = service.getCurrentPage(pg);
		int start 		 = service.getLimitStart(currentPage);		
		int count 		 = service.getListCount(total, start);
		// �Ǽ��� ������ ceil(�ø�)�� �����ؼ� ���� �������� ��� �� �׷����� �����Ѵ�. 12������/10.0 = 1.2(�Ҽ��� �ø�) => 2�������� ��
		int groupCurrent = (int)Math.ceil(currentPage/10.0); 
		int groupStart 	 = (groupCurrent - 1) * 10 + 1;
		int groupEnd 	 = groupCurrent * 10;

		List<BoardVO> boards = service.selectBoards(start, cate);
		
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		model.addAttribute("boards", boards);
		model.addAttribute("pageEnd", pageEnd);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("count", count);
		model.addAttribute("groupCurrent", groupCurrent);
		model.addAttribute("groupStart", groupStart);
		model.addAttribute("groupEnd", groupEnd);
		
		return "/board/list";
	}
	@GetMapping("/board/view")
	public String view(String group, String cate, Model model) {
		
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		
		return "/board/view";
	}
	@GetMapping("/board/modify")
	public String modify(String group, String cate, Model model) {
		
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		
		return "/board/modify";
	}
	@GetMapping("/board/delete")
	public void delete(String group, String cate, Model model) {

		model.addAttribute("group", group);
		model.addAttribute("cate", cate);		
	}
}
