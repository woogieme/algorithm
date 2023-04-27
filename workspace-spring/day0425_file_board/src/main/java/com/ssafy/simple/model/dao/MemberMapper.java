package com.ssafy.simple.model.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.simple.model.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	public MemberDTO selectOne(@Param("ii")String id, @Param("pp")String pw) throws SQLException ;
}
