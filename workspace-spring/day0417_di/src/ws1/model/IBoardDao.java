package ws1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IBoardDao {
	public int insert(BoardDto board) throws SQLException ;
	public List<BoardDto> selectAll() throws SQLException;
	public BoardDto selectOne(int bno) throws SQLException;
}
