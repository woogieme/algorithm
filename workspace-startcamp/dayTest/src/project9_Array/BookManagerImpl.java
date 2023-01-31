package project9_Array;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 * 도서리스트를 배열로 유지하며 관리하는 클래스
 */
import java.util.Arrays;
import java.util.List;

import project9.Book;
import project9.ISBNNotFoundException;
import project9.QuantityException;

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
			if (books.get(i) instanceof  Magazine) {
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
			tmp+=books.get(i).getPrice();
		}
		return tmp;
	}
	
	public  double getPriceAvg() {
		double tmp=0;
		for(int i=0; i<books.size();i++) {
			tmp+=books.get(i).getPrice();
		}
		return tmp/books.size();
	}
	
	public void buy (String isbn, int quantity) throws ISBNNotFoundException{

		Book b = searchByIsbn(isbn);
		if (b!=null) {
		b.setQuantity(b.getQuantity()+quantity);
		}
		else {
			throw new ISBNNotFoundException(isbn);

		}
		
		
		
	}
	
	
	public void sell (String isbn, int quantity) throws QuantityException,ISBNNotFoundException{
		Book b = searchByIsbn(isbn);
		if (b!=null) {
			if (b.getQuantity()>=quantity) {
				b.setQuantity(b.getQuantity()-quantity);
			}
			else {
				throw new QuantityException();
			}
		}
		else {
			throw new ISBNNotFoundException(isbn);
		}
	}
	
	public void localData() {
		try (ObjectOutputStream arr = new ObjectOutputStream(new FileOutputStream("books.dat")) ){
			arr.writeObject(books);
			System.out.println("저장 완료");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveData() {
		try(ObjectInputStream oin = new ObjectInputStream(new FileInputStream("books.dat"))){
			Object obj = oin.readObject();

        	if(obj !=null && obj instanceof Book[]) {
        		Book[] book = (Book[])obj;
        		System.out.println(book.toString());
        	}
        	else {
        		System.out.println("등록된 도서가 없습니다.");
        	}
			
		}catch(IOException | ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}
}
