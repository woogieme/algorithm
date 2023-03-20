package com.ssafy.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ssafy.board.model.BoardDto;
import com.ssafy.util.DBUtil;

public class BoardDaoImpl implements BoardDao {

	private static BoardDao boardDao = new BoardDaoImpl();
	private DBUtil dbUtil;
	
	private BoardDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}

	public static BoardDao getBoardDao() {
		return boardDao;
	}
	
	@Override
	public int writeArticle(BoardDto boardDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into board (user_id, subject, content, hit, register_time) \n");
			sql.append("values (?, ?, ?, 0, now())");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, boardDto.getUserId());
			pstmt.setString(2, boardDto.getSubject());
			pstmt.setString(3, boardDto.getContent());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		return cnt;
	}

	@Override
	public List<BoardDto> listArticle() {
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder listArticle = new StringBuilder();
			listArticle.append("select article_no, user_id, subject, content, hit, register_time \n");
			listArticle.append("from board \n");
			
			pstmt = conn.prepareStatement(listArticle.toString());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setArticleNo(rs.getInt("article_no"));
				boardDto.setUserId(rs.getString("user_id"));
				boardDto.setSubject(rs.getString("subject").replace("<", "&lt;"));
				boardDto.setContent(rs.getString("content").replace("\n", "<br/>"));
				boardDto.setHit(rs.getInt("hit"));
				boardDto.setRegisterTime(rs.getString("register_time"));
				
				list.add(boardDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	

	@Override
	public BoardDto viewArticle(int articleNo)  {
		BoardDto boardDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder listArticle = new StringBuilder();
			listArticle.append("select article_no, user_id, subject, content, hit, register_time\n");
			listArticle.append("from board \n");
			pstmt = conn.prepareStatement(listArticle.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				boardDto = new BoardDto();
				boardDto.setArticleNo(rs.getInt("article_no"));
				boardDto.setUserId(rs.getString("user_id"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setHit(rs.getInt("hit"));
				boardDto.setRegisterTime(rs.getString("register_time"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return boardDto;
	}


}