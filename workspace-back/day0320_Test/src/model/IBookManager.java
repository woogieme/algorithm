package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IBookManager {
	void insert(Book book);
	void delete(String isbn);
	Book selectByIsbn(String isbn);
	List<Book> selectByTitle(String title);
	List<Book> selectAll();
}
