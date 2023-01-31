package project9_Array;

/**
 * 잡지 정보를 나타내는 클래스
 */
public class Magazine extends Book{
	int year;
	int month;
	public Magazine() {
		
	}
	
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc,int year, int month) {
		super(isbn,title,author,publisher,price,desc);
		this.year = year;
		this.month = month;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "Magazine [year=" + year + ", month=" + month + ", isbn=" + isbn + ", title=" + title + ", author="
				+ author + ", publisher=" + publisher + ", price=" + price + ", desc=" + desc + "]";
	}
}
