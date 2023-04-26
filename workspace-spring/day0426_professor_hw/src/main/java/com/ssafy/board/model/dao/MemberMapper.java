package com.ssafy.board.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.board.model.dto.Member;

@Mapper
public interface MemberMapper {

	public Member selectOne(@Param("userId")String userId,@Param("userPw")String userPw);

}
