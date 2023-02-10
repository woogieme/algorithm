package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DBUtil {
	private static final String DB_DRIVER ="com.mysql.cj.jdbc.Driver";
	private static final String DB_URL="jdbc:mysql://localhost:3306/ssafydb?characterEncoding=UTF-8&&serverTimezone=UTC";
	private static final String DB_ID="ssafy";
	private static final String DB_PW="ssafy";
	
	
	public DBUtil() {
		try {
			Class.forName(DB_DRIVER);
		}catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩오류");
		} //find for DB_DRIVER 
	}//end for DBUtil constructor
	
	public Connection getConnection() {
		Connection conn =null;
		try {
			conn= DriverManager.getConnection(DB_URL, DB_ID,DB_PW);
		} catch (SQLException e) {
			System.out.println("커넥션 생성 오류");
		}//connect FROM JAVA APPLICATION TO DATABASE
		return conn;	
	}//end for getConnection method
	
	public void close(AutoCloseable ... closeables ) {
		for (int i = 0; i < closeables.length; i++) {
			try {
				closeables[i].close();
			} catch (Exception e) {
				System.out.println("close 생성 오류");
			}
		}//close ALL
	}//end for close method
	
	
	
	
	
}
