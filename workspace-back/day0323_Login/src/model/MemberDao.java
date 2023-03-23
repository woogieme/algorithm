package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	public MemberDto selectOne(String id, String pw) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto result =null;
		String sql = null;
		DBUtil util = new DBUtil();
		
		try {
			conn = util.getConnection();
			sql = " SELECT USER_ID, USER_NAME  FROM "
					+ " MEMBER_TB WHERE USER_ID=? and USER_PW=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = new MemberDto();
				result.setUserId(rs.getString(1));
				result.setUserName(rs.getString(2));
				
				
			}
		}finally {
			util.close(rs, pstmt, conn);
		}				
		return result;
	}
}
