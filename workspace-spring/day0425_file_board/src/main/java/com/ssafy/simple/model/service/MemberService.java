package com.ssafy.simple.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.simple.model.dao.MemberMapper;
import com.ssafy.simple.model.dto.MemberDTO;

@Service // @Component
public class MemberService {
	@Autowired
	private MemberMapper dao;
	
	public MemberDTO login(String id, String pw) throws SQLException {
		return dao.selectOne(id, pw);
	}
}
