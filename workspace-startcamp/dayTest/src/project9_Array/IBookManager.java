package project9_Array;

import java.util.List;

import project9.ISBNNotFoundException;
import project9.QuantityException;

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
	public void sell (String isbn, int quantity) throws QuantityException, ISBNNotFoundException;
	public void buy (String isbn, int quantity) throws ISBNNotFoundException;
	public void localData();
	public void saveData();
}
