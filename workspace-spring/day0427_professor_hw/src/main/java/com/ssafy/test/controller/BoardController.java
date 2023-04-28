package com.ssafy.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.test.model.dto.Board;
import com.ssafy.test.model.dto.Comment;
import com.ssafy.test.model.dto.Member;
import com.ssafy.test.model.service.BoardService;
import com.ssafy.test.model.service.CommentService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@Autowired
	private CommentService cService;
	
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
	public String write(Board board, HttpSession session,MultipartFile[] myfile) throws IllegalStateException, IOException {
		Member loginInfo = (Member) session.getAttribute("loginInfo");
		if( loginInfo ==null){
			return "loginCheck";
		}
		else {
			board.setBwriter(loginInfo.getUserId());
			service.write(board, myfile);
			return "redirect:list";
		}
		
		
		
	}
	@GetMapping("read")
	public ModelAndView read(int bno) {
		ModelAndView mv = new ModelAndView("read");
		mv.addObject("board", service.read(bno));
		mv.addObject("commentList", cService.showComment(bno));
		return mv;
	}
	
	@PostMapping("comment-register")
	public String regist(Comment comment,HttpSession session,Model model) {
		System.out.println("asdasdasdasd");
		Member loginInfo = (Member) session.getAttribute("loginInfo");
		if(loginInfo==null) {
			return "loginInfo";
		}
		comment.setCwriter(loginInfo.getUserId());
		cService.insert(comment);
		return "redirect:read?bno="+comment.getBno();
		
	}
}
