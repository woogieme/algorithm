package project9_1;

import java.util.List;

/**
 * 도서리스트를 관리하기 위한 클래스를 위한 명세역할의 인터페이스
 */
public interface IBookManager {
	public void add(Book book);
	public List<Magazine> getMagazines();
	public List<Book> getBooks();
	public void remove(String isbn);
	public Book searchByIsbn(String isbn);
	public List<Book> searchByTitle(String title);
	public int getTotalPrice();
	public double getPriceAvg();
}
