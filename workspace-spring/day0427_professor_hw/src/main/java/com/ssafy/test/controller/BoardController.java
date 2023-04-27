package com.ssafy.test.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.test.model.dto.Board;
import com.ssafy.test.model.dto.Member;
import com.ssafy.test.model.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardList", service.list());
		mv.setViewName("list");
		
		return mv;
		
	}
	@GetMapping("write")
	public String write(HttpSession session) {
		Member member = (Member) session.getAttribute("loginInfo");
		if(member ==null) {
			return "loginCheck";
		}
		else {
			return "write";
		}
	}
	
	@PostMapping("write")
	public String write(Board board, HttpSession session) {
		Member loginInfo = (Member) session.getAttribute("loginInfo");
		if( loginInfo ==null){
			return "loginCheck";
		}
		else {
			board.setBwriter(loginInfo.getUserId());
			service.write(board);
		}
		return "redirect:list";
		
		
	}
	@GetMapping("read")
	public ModelAndView read(int bno) {
		ModelAndView mv = new ModelAndView("read");
		mv.addObject("board", service.read(bno));
		return mv;
	}
}
