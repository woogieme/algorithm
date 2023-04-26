package com.ssafy.board.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.BoardMapper;
import com.ssafy.board.model.dao.MemberMapper;
import com.ssafy.board.model.dto.Member;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper mDao;

	public Member login(String userId, String userPw) {
		
		return mDao.selectOne(userId,userPw);
	}
}
