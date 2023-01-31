package project9;
public interface IBookManager {
	public void add(Book book);
	public Magazine[] getMagazines();
	public Book[] getBooks();
	public void remove(String isbn);
	public Book searchByIsbn(String isbn);
	public Book[] searchByTitle(String title);
	public int getTotalPrice();
	public double getPriceAvg();
	public void sell (String isbn, int quantity) throws QuantityException, ISBNNotFoundException;
	public void buy (String isbn, int quantity) throws ISBNNotFoundException;
	public void loadData();
	public void saveData();
}
