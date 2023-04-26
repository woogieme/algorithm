package model;

import java.util.List;

public interface BoardMapper { //SQL실행을ㅇ ㅟ한 목적. (기존에 Dao로 불리던 클래스 대체)
	public int insert(BoardDto board);
	public BoardDto selectOne(@Param("id") String id, @Param("pw") String pw); //2개일떄  @Param 써야함
	public List<BoardDto> selectAll();
}
