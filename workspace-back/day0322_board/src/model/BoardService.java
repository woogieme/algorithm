package model;

import java.sql.SQLException;
import java.util.List;

public class BoardService {
	private BoardService() {}
	private static BoardService instance = new BoardService();
	public static BoardService getInstance() {
		return instance;
	}
	
	//////////////////////////////////////////
	
	private BoardDao dao = BoardDao.getInstance();
	
	public int write(BoardDto b) throws SQLException {
		return dao.insert(b);
	}
	
	public List<BoardDto> getBoards() throws SQLException{
		return dao.selectAll();
	}
	
	public BoardDto getBoardOne(int bno) throws SQLException{
		return dao.selectOne(bno);
	}
}
