package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Util.DBUtil;

public class BookManagerDao implements IBookManager {
	private static IBookManager instance = new BookManagerDao();
	private BookManagerDao() { // 외부에서 객체 생성을 하지 못하도록 접근 제어자를  private으로 만든 생성자
	}
	public static IBookManager getInstance() {
		return instance;
	}
	private DBUtil util = new DBUtil();
	@Override
	public void insert(Book book) {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement pstmt=null;
		int result=0;
		String sql=null;
		try {
			conn=util.getConnection();
			sql = "insert into book_tb(isbn,title,author,publisher,price,description, quantity)\n"+
					"values\n"+
					"(?,?,?,?,?,?,?)";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setString(4, book.getPublisher());
			pstmt.setInt(5, book.getPrice());
			pstmt.setString(6, book.getDesc());
			pstmt.setInt(7, book.getQuantity());
			
			result = pstmt.executeUpdate();
			System.out.println("책 추가 결과: "+result);
		}catch(Exception ex) {
			System.out.println("insert 예외발생");
			ex.printStackTrace();
		}finally {
			util.close(pstmt,conn);
		}
		
		
	}
	@Override
	public void delete(String isbn) {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement pstmt=null;
		int result=0;
		String sql=null;
		try {
			conn=util.getConnection();
			sql = "delete\n"+
					"from book_tb\n"+
					"where isbn=?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, isbn);
			
			result = pstmt.executeUpdate();
			System.out.println("책 삭제 결과: "+result);
		}catch(Exception ex) {
			System.out.println("delete 예외발생");
			ex.printStackTrace();
		}finally {
			util.close(pstmt,conn);
		}
	}
	@Override
	public Book selectByIsbn(String isbn) {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		Book result =null;
		String sql=null;
		try {
			conn =util.getConnection();
			sql ="select isbn, title, author, publisher, price, description, quantity\n"+
					"from book_tb\n"+
					"where isbn=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, isbn);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result =new Book();
				result.setIsbn(rs.getString(1));
				result.setTitle(rs.getString(2));
				result.setAuthor(rs.getString(3));
				result.setPublisher(rs.getString(4));
				result.setPrice(rs.getInt(5));
				result.setDesc(rs.getString(6));
				result.setQuantity(rs.getInt(7));
			}
			
		}catch(Exception ex) {
			System.out.println("select 예외발생");
			ex.printStackTrace();
		}finally {
			util.close(pstmt,conn);
		}
		return result;
	}
	@Override
	public List<Book> selectByTitle(String title) {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		List<Book> result =new ArrayList<>();
		Book tmp = null;
		String sql=null;
		try {
			conn =util.getConnection();
			sql ="select isbn, title, author, publisher, price, description, quantity\n"+
					"from book_tb\n"+
					"where title like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+title+"%");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				tmp = new Book();
				tmp.setIsbn(rs.getString(1));
				tmp.setTitle(rs.getString(2));
				tmp.setAuthor(rs.getString(3));
				tmp.setPublisher(rs.getString(4));
				tmp.setPrice(rs.getInt(5));
				tmp.setDesc(rs.getString(6));
				tmp.setQuantity(rs.getInt(7));
				result.add(tmp);
			}
			
		}catch(Exception ex) {
			System.out.println("select 예외발생");
			ex.printStackTrace();
		}finally {
			util.close(pstmt,conn);
		}

		return result;
	}
	
	@Override
	public List<Book> selectAll() {
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		List<Book> result =new ArrayList<>();
		Book tmp = null;
		String sql=null;
		try {
			conn =util.getConnection();
			sql ="select isbn, title, author, publisher, price, description, quantity\n"+
					"from book_tb";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				tmp = new Book();
				tmp.setIsbn(rs.getString(1));
				tmp.setTitle(rs.getString(2));
				tmp.setAuthor(rs.getString(3));
				tmp.setPublisher(rs.getString(4));
				tmp.setPrice(rs.getInt(5));
				tmp.setDesc(rs.getString(6));
				tmp.setQuantity(rs.getInt(7));
				result.add(tmp);
			}
			
		}catch(Exception ex) {
			System.out.println("select 예외발생");
			ex.printStackTrace();
		}finally {
			util.close(pstmt,conn);
		}

		return result;
	}

}
