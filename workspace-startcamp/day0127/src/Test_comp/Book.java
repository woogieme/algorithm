package Test_comp;

import java.io.Serializable;

// VO(Variable Object) == DTO(Data Transfer Object) == Bean
// 변수같은 객체 , 데이터를 저장밖에하지않는 객체 
public class Book implements Serializable, Comparable<Book>{ //Comparable == 비교 가능한 ~ 
	String isbn;
	String title;
	String author;
	String publisher;
	int price;
	String desc;
	int quantity;
	
	public Book() {}

	public Book(String isbn, String title, String author, String publisher, int price, String desc, int quantity) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
		this.quantity = quantity;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", price=" + price + ", desc=" + desc + ", quantity=" + quantity + "]"+"\n";
	}
	@Override
		public int compareTo(Book o) {
			// TODO Auto-generated method stub
//			if(this.price > o.price)
//				return 1;
//			else if (this.price<o.price)
//				return -1;
//			
//			return 0;
		return this.price - o.price; //정수 한정으로 이렇게함 어차피 양수,음수,0으로 나올테니까 but 실수에서는 compareTo 구현 X
		}
	
}
