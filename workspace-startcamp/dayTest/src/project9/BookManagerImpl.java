package project9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;


public class BookManagerImpl implements IBookManager{
	private final int MAX_SIZE=100;
	private Book[] books =new Book[MAX_SIZE];
	private int size;
	private BookManagerImpl() {}
	private static BookManagerImpl instance = new BookManagerImpl();
	public static BookManagerImpl getInstance() {
		return instance;
	}
	
	public void add(Book book) {
		if(size<MAX_SIZE) books[size++] = book;
	}//end for add()
	
	Book[] getList() {
		Book[] temp = new Book[size];
		for(int i=0; i<books.length; i++) {
			if (books[i]!=null) {
				temp[i] = books[i];
//				break;
			}
		}
		return temp;
		//return Arrays.copyOfRange(books, 0, size);
	}//end for getList()
	
	public Magazine[] getMagazines() {
		int cnt=0;
		for(int i=0; i<size; i++) {
			if (books[i]instanceof  Magazine) {
				cnt++;
			}
		}
		int k=0;
		Magazine[] temp = new Magazine[cnt];{
		for(int i=0; i<size; i++) {
				if (books[i] instanceof  Magazine) {
					temp[k]=(Magazine) books[i];
					k+=1;
				}
			}
		}
		return temp;
	}
	
	public Book[] getBooks() {
		int cnt=0;
		for(int i=0; i<size; i++) {
			if (!(books[i]instanceof  Magazine)) {
				cnt++;
			}
		}
		int k=0;
		Book[] temp = new Book[cnt];{
		for(int i=0; i<size; i++) {
				if (!(books[i] instanceof  Magazine)) {
					temp[k]=books[i];
					k+=1;
				}
			}
		}
		return temp;
	}
	
	public void remove(String isbn) {
		for(int i=0; i<size; i++) {
			if ((books[i].getIsbn()).equals(isbn)){
				for (int j = i; j < books.length; j++) {
					if ((j+1)==books.length) {
						books[j]=null;
						break;
					}
					books[j]=books[j+1];
				}
				size-=1;
				break;
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
	
	public Book[] searchByTitle(String title) {
		Book[] temp = new Book[size];
		for(int i=0; i<size; i++) {
			if(books[i].getTitle().contains(title)) {
				temp[i]=books[i];
			}
		}
		return temp;
	}
	
	public int getTotalPrice() {
		int tmp=0;
		for(int i=0; i<size;i++) {
			tmp+=books[i].price;
		}
		return tmp;
	}
	
	public  double getPriceAvg() {
		double tmp=0;
		for(int i=0; i<size;i++) {
			tmp+=books[i].price;
		}
		return tmp/size;
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
	
	public void loadData() {
		File f = new File("book.dat");
		if(f.exists()) {
			try (ObjectOutputStream arr = new ObjectOutputStream(new FileOutputStream(f)) ){
				arr.writeObject(books);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		else {
			books =new Book[MAX_SIZE];
		}
	}
	
	public void saveData() {
		try(ObjectInputStream oin = new ObjectInputStream(new FileInputStream("book.dat"))){
			Object obj = oin.readObject();

        	if(obj !=null && obj instanceof Book[]) {
        		Book[] book = (Book[])obj;
        		for (int i = 0; i < book.length; i++) {
        			if(book[i]!=null) {
					System.out.println(book[i]);
        			}
				}
        	}
        	else {
        		System.out.println("등록된 도서가 없습니다.");
        	}
			
		}catch(IOException | ClassNotFoundException e ) {
			System.out.println("등록된 도서가 없습니다.");
		}
	}
	
}
