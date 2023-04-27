package com.ssafy.simple.model.dto;

public class MemberDTO {
	private String userId; // user_id
	private String userPw; // user_pw
	private String userName; // user_name
	
	public MemberDTO() {}// DTO에 기본생성자 꼭만들기!! (라이브러리들이 객체 대신 만들어줄 때 씀)

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "MemberDTO [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + "]";
	}; 
	
	
}
