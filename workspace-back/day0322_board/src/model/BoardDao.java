package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BoardDao {
	private static BoardDao instance  = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	///////////////////////////////////////////////////////////////////////////////
	public int insert(BoardDto board) throws SQLException {
		Connection conn =null;
		PreparedStatement pstmt =null;
		int result = 0 ;
		String sql = null;
		DBUtil util = new DBUtil();
		try {
			conn = util.getConnection();
			sql = "INSERT INTO BOARD_TB(BWRITER , BTITLE, BCONTENT, BWRITE_DATE)"
					+ "VALUE(?,?,?,NOW()) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,board.getBwriter());
			pstmt.setString(2,board.getBtitle());
			pstmt.setString(3,board.getBcontent());
			
			result = pstmt.executeUpdate();
			
		}finally {
			util.close(pstmt,conn);
			
		}
		return result;
		
	}
	
	public List<BoardDto>  selectAll() throws SQLException{
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs= null;
		List<BoardDto> result = new ArrayList<>();
		String sql = null;
		DBUtil util = new DBUtil();
		try {
			conn = util.getConnection();
			sql = "SELECT BNO, BWRITER , BTITLE, BWRITE_DATE  FROM BOARD_TB";
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDto b =new BoardDto();
				b.setBno(rs.getInt(1));
				b.setBwriter(rs.getString(2));
				b.setBtitle(rs.getString(3));
				b.setBwriteDate(rs.getString(4));
				
				result.add(b);
			}
		}finally {
			util.close(rs,pstmt,conn);
			
		}
		return result;
		
	}
	public BoardDto selectOne (int bno) throws SQLException {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs= null;
		BoardDto result = new BoardDto();
		String sql = null;
		DBUtil util = new DBUtil();
		try {
			conn = util.getConnection();
			sql = "SELECT BNO, BWRITER , BTITLE, BWRITE_DATE  BCONTENT FROM "+ " BOARD_TB WHERE BNO =?";
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				result.setBno(rs.getInt(1));
				result.setBwriter(rs.getString(2));
				result.setBtitle(rs.getString(3));
				result.setBcontent(rs.getString(4));
				result.setBwriteDate(rs.getString(5));
			}
		}finally {
			util.close(rs,pstmt,conn);
			
		}
		return result;
		
		
	}
//	public int delete(int bno) {
//		
//	}
//	public int 
	

}
