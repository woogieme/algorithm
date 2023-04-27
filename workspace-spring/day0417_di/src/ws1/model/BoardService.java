package ws1.model;

import java.sql.SQLException;
import java.util.List;

// 지금은 이 클래스가 하는일이 없음... 나중에 게시판 좀 복잡해지면 그때 일할거임..
public class BoardService {
	private IBoardDao dao; // mysql Dao가 올지 oracle Dao가 올지 난 모름. 신경 안씀.
	public void setDao(IBoardDao dao) {
		this.dao = dao;
	}
	
	public int write(BoardDto b) throws SQLException {
		return dao.insert(b);
	}
	
	// 지금은 모든글 그냥 조건없이 조회하지만 나중에는 전체글 중 일부만 가져온다던가 할 때 계산 필요함.
	public List<BoardDto> getBoards() throws SQLException{
		return dao.selectAll();
	}
	
	public BoardDto read(int bno) throws SQLException {
		return dao.selectOne(bno);
	}
}




