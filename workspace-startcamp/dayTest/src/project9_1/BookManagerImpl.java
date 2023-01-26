package project9_1;

import java.util.ArrayList;
/**
 * 도서리스트를 배열로 유지하며 관리하는 클래스
 */
import java.util.Arrays;
import java.util.List;

public class BookManagerImpl implements IBookManager{
	private final int MAX_SIZE=100;
	private List<Book> books = new ArrayList<Book>();
	private BookManagerImpl() {}
	private static BookManagerImpl instance = new BookManagerImpl();
	public static BookManagerImpl getInstance() {
		return instance;
	}
	
	public void add(Book book) {
		if(books.size()<MAX_SIZE) books.add(book);
	}//end for add()
	
	public List<Book> getList() {
		
		return books; 
		//return Arrays.copyOfRange(books, 0, size);
	}//end for getList()
	
	public List<Magazine> getMagazines() {
		List<Magazine> temp = new ArrayList<Magazine>();
		for(int i=0; i<books.size(); i++) {
			if (books.get(i)instanceof  Magazine) {
				temp.add((Magazine) books.get(i));
			}
		}
		return temp;
	}
	
	public List<Book> getBooks() {
		List<Book> temp = new ArrayList<Book>();
		for(int i=0; i<books.size(); i++) {
			if (!(books.get(i)instanceof  Magazine)) {
				temp.add(books.get(i));
			}
		}
		return temp;
	}
	
	public void remove(String isbn) {
		for(int i=0; i<books.size(); i++) {
			if ((books.get(i).getIsbn()).equals(isbn)){
				books.remove(i);
			}
		}
	}//end for remove method
	
	public Book searchByIsbn(String isbn) {
		Book temp = null;
		for(Book b : books) {
			if( b!= null) {
				if(b.getIsbn().equals(isbn)) {
					temp=b;
				}
			}
		}
		return temp;
	}
	
	public List<Book> searchByTitle(String title) {
		List<Book> temp = new ArrayList<Book>();
		for(int i=0; i<books.size(); i++) {
			if(books.get(i).getTitle().contains(title)) {
				temp.add(books.get(i));
			}
		}
		return temp;
	}
	
	public int getTotalPrice() {
		int tmp=0;
		for(int i=0; i<books.size();i++) {
			tmp+=books.get(i).price;
		}
		return tmp;
	}
	
	public  double getPriceAvg() {
		double tmp=0;
		for(int i=0; i<books.size();i++) {
			tmp+=books.get(i).price;
		}
		return tmp/books.size();
	}
	
	
}
