package model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 지금은 이 클래스가 하는일이 없음... 나중에 게시판 좀 복잡해지면 그때 일할거임..
public class BoardService {
	private BoardService() {}
	private static BoardService instance = new BoardService();
	public static BoardService getInstance() {
		return instance;
	}
/////////////////////////////////////////////////////////////////////
	private BoardDao dao = BoardDao.getInstance();
	
	public int write(BoardDto b) throws SQLException {
		return dao.insert(b);
	}
	
	// 지금은 모든글 그냥 조건없이 조회하지만 나중에는 전체글 중 일부만 가져온다던가 할 때 계산 필요함.
	public Map<String, Object> getBoards(int curPage) throws SQLException{
		Map <String, Object> pageMap = new HashMap<>();
		pageMap.put("curPage", curPage);
		
		int startPage = (curPage-1)/10*10+1; // 11,12,13.....20인 숫자 1빼서 /10하면 1됨 다시 *10 이면 10됨 +1해서 11페이지 만듬
		pageMap.put("startPage", startPage);
		int totalBoardCount =dao.selectTotalCount(); //총 게시굴 갯수 :706개....
		int totalPage = totalBoardCount/10;
		if(totalBoardCount%10 > 0) { //나머지가 남네? 페이지 하나 더 필요하겠구만
			totalPage++;
		}
		pageMap.put("totalPage", totalPage);
		
		int endPage = startPage+9;
		if(endPage>totalPage) { //총 페이지가 71인데 endPage를 80으로 계산하는 경우 생기면
			endPage=totalPage; //그냥 마지막 페이지로 셋팅
		}
		pageMap.put("endPage", endPage);
		
		int startRow = (curPage-1)*10; //1page -> limit 0,10 //2page -> 10,10 // 3page-> limit 20, 10 ...
		List<BoardDto> boardList = dao.select(startRow);
		
		System.out.println(curPage+ " : " +startPage+" : "+ totalPage+ " : "+endPage +" : "+startRow);
		pageMap.put("boardList", boardList);
		
		return pageMap;
		
	}
	
	public BoardDto read(int bno) throws SQLException {
		return dao.selectOne(bno);
	}
	
	public int deleteBoards(String[] bnos) throws NumberFormatException, SQLException { // 클라이언트가 보내는 파라미터는 무조건 자료형이 String
		int delCnt = 0;
		for(String bno: bnos) {
			delCnt+= dao.delete(Integer.parseInt(bno));
		}
		return delCnt;
	}
}




