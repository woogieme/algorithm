package com.ssafy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	public ConnectionTest() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로딩 실패!!");
		}
	}
	private Connection makeConnection() {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC","ssafy","ssafy");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void main(String[] args) {
		ConnectionTest ct =new ConnectionTest();
		Connection conn = ct.makeConnection();
		if(conn !=null) {
			System.out.println("DB 연결 성공!!");
		}
	}
}
