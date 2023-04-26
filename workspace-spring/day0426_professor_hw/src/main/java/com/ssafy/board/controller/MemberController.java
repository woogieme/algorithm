package com.ssafy.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Member;
import com.ssafy.board.model.service.MemberService;

@RestController
@RequestMapping("/user")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	
	@PostMapping("/login")
	public String login(String userId, String userPw,HttpSession session) {
		Member loginInfo = service.login(userId,userPw);
		if(loginInfo !=null) {
			session.setAttribute("loginInfo", loginInfo);
		}
		return "index";
	}
	
}
