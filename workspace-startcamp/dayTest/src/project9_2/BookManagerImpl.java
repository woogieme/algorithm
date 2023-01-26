package project9_2;

/**
 * 도서리스트를 배열로 유지하며 관리하는 클래스
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class BookManagerImpl implements IBookManager{
	private final int MAX_SIZE=100;
	private int size=0;
	private Map<String,Book> books = new HashMap<>();
	private BookManagerImpl() {}
	private static BookManagerImpl instance = new BookManagerImpl();
	public static BookManagerImpl getInstance() {
		return instance;
	}
	
	public void add(Book book) {
		if(books.size()<MAX_SIZE)
		{
			books.put(book.getIsbn(), book);
			size+=1;
		}
	}//end for add()
	
	public Book[] getList() {
		Book[] temp = new Book[size];
		int i=0;
    	for(Entry<String, Book> answer : books.entrySet()) {
    		temp[i]=answer.getValue();
    		i+=1;
    	}
		return temp;
		//return Arrays.copyOfRange(books, 0, size);
	}//end for getList()
	
	public Magazine[] getMagazines() {
		int i=0;
		for(Entry<String, Book> answer : books.entrySet()) {
			if (answer.getValue()instanceof  Magazine) {
				i+=1;
			}
		}
		Magazine[] temp = new Magazine[i];
		int count=0;
		for(Entry<String, Book> answer : books.entrySet()) {
			if (answer.getValue()instanceof  Magazine) {
				temp[count]=(Magazine) answer.getValue();
				count+=1;
			}
		}
		return temp;
	}
	
	public Book[] getBooks() {
		int i=0;
		for(Entry<String, Book> answer : books.entrySet()) {
			if(!(answer.getValue() instanceof  Magazine)) {
				i+=1;
			}
		}
		Book[] temp = new Book[i];
		int count=0;
		for(Entry<String, Book> answer : books.entrySet()) {
			if (!(answer.getValue() instanceof  Magazine)) {
				temp[count]=answer.getValue();
				count+=1;
			}
		}
		return temp;
	}
	
	public void remove(String isbn) {
		books.remove(isbn);
	}//end for remove method
	
	public Book searchByIsbn(String isbn) {
		Book temp = null;
		for(Entry<String, Book> answer : books.entrySet()) {
			if (answer.getKey().equals(isbn) ) {
				temp=answer.getValue();
				break;
			}
		}
		return temp;
	}
	
	public Book[] searchByTitle(String title) {
		Book[] temp = new Book[size];
		int i=0;
		for(Entry<String, Book> answer : books.entrySet()) {
			if(answer.getValue().getTitle().contains(title)) {
				temp[i]=answer.getValue();
			}

		}
		return temp;
	}
	
	public int getTotalPrice() {
		int tmp=0;
		for(Entry<String, Book> answer : books.entrySet()) {
			tmp+=answer.getValue().getPrice();

		}
		return tmp;
	}
	
	public  double getPriceAvg() {
		double tmp=0;
		for(Entry<String, Book> answer : books.entrySet()) {
			tmp+=answer.getValue().getPrice();

		}
		return tmp/books.size();
	}
	
	
}
