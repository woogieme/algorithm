package com.trip.project.dto.user;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserRepository {
	Integer join(UserDto user);

	Integer find(UserDto user);

	UserDto login(UserDto user);

	Integer findLogin(UserDto user);

	Integer findUserId(long userId);

	UserDto viewMypage(long userId);
}
