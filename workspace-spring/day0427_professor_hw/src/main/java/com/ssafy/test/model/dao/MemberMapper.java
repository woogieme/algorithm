package com.ssafy.test.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.test.model.dto.Member;

@Mapper
public interface MemberMapper {

	public Member selectOne(@Param("ii")String id, @Param("pp")String pw);

}
