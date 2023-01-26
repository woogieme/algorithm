package project9;

public class ISBNNotFoundException extends Exception{
	/**
	 * 
	 */
	private String isbn;
	public ISBNNotFoundException(String isbn) {
		super(isbn+"이 존재하지않습니다.");
		this.isbn=isbn;
	}

	
	public String getIsbn() {
		return isbn;
	}
}
