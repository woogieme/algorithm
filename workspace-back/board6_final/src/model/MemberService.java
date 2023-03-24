package model;

import java.sql.SQLException;

public class MemberService {
	private MemberDao mdao = new MemberDao();
	public MemberDto login(String id, String pw) throws SQLException {
		return mdao.selectOne(id, pw);
	}
}
