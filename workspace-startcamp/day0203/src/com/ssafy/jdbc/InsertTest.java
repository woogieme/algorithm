package com.ssafy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
	public InsertTest() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로딩 실패!!");
		}
	}
	
	private Connection makeConnection() throws SQLException {
		// TODO Auto-generated method stub
		//Connection conn = null;
//		try {
//		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC","ssafy","ssafy");
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC","ssafy","ssafy");
	}
	
	private int register(String name, int age) {
		// TODO Auto-generated method stub
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//DB 연결
			conn = makeConnection();
			//SQL Insert문 넣기
			StringBuilder sql = new StringBuilder("insert into jdbctestable (name,age) \n");
			sql.append("values (?, ?)"); //?는 치환변수
			//SQL 실행 준비 단계
			pstmt = conn.prepareStatement(sql.toString()); //builder는 toString으로 변환
			pstmt.setString(1,  name);
			pstmt.setInt(2, age);
			
			//SQL 실행 - insert해서 데이터가 몇개가 바뀌었는지 확인하는것 즉 cnt는 2여야함
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt !=null)
				pstmt.close();
				if(conn !=null)
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		int cnt = it.register("정재욱",27);
		if (cnt !=0)
			System.out.println("등록 성공!!!");
		else
			System.out.println("등록 실패!!!");
	}

	
}
