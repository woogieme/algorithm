package projectSSAFY;

//package com.ssafy.hw.step2;

public interface IUserManager {
	
	public void add(User user);
	
	public User[] getList();
	
	public User[] getUsers();
	
	public VipUser[] getVipUsers();
	
	// 예외를 던진다고 선언
	public User[] searchByName(String name) throws NameNotFoundException;
	
	public double getAgeAvg();
	
	public void saveData();
	public void loadData();
	
}
