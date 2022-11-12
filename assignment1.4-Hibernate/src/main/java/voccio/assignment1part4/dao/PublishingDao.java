package voccio.assignment1part4.dao;

import java.util.List;

import voccio.assignment1part4.entities.Author;
import voccio.assignment1part4.entities.Book;
import voccio.assignment1part4.entities.Category;

public interface PublishingDao {
	Book findBookWithCategoryAndAuthorById(Long id);
	
	List<Book> findAllWithCategoryAndAuthorByAuthorId(Long id);
	
	List<Book> findAllBooks();
	
	Category getCategoryById(Long id);
	
	Book save(Book book);
	
	void delete(Book book);
	
	Author save(Author author);
	
	void delete(Author author);
}
