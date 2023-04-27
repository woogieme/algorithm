package com.ssafy.test.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.test.model.dto.Member;
import com.ssafy.test.model.service.MemberService;

@Controller
@RequestMapping("/user")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	
	@PostMapping("/login")
	public String login(String userId, String userPw,HttpSession session) throws SQLException{
		Member loginInfo = service.login(userId,userPw);
		if(loginInfo !=null) {
			session.setAttribute("loginInfo", loginInfo);
			System.out.println(loginInfo.getUserName());
		}
		return "index";
	}
	
}
