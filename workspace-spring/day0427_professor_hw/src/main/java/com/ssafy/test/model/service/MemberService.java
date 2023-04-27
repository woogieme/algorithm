package com.ssafy.test.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.test.model.dao.BoardMapper;
import com.ssafy.test.model.dao.MemberMapper;
import com.ssafy.test.model.dto.Member;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper mDao;

	public Member login(String id, String pw) {
		
		return mDao.selectOne(id,pw);
	}
}
