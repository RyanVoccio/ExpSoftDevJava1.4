package voccio.assignment1part4;


import voccio.assignment1part4.config.AppConfig;
import voccio.assignment1part4.dao.PublishingDao;
import voccio.assignment1part4.entities.Author;
import voccio.assignment1part4.entities.Book;
import voccio.assignment1part4.entities.Category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class InsertBookAndAuthor {
	private static Logger logger = LoggerFactory.getLogger(
			InsertBookAndAuthor.class);

	public static void main(String... args) {
		GenericApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		PublishingDao publishingDao = ctx.getBean(PublishingDao.class);
		
		logger.info("============== Insert book with author(s) start ==============");
		Book book = new Book();
		book.setCategory(publishingDao.getCategoryById(4L));
		book.setIsbn("0-02-030665-2");
		book.setTitle("Ball Four");
		book.setPrice(18.75f);
		
		Author author = new Author();
		author.setFirstName("Jim");
		author.setLastName("Bouton");
		author.setDescription("Jim Bouton was an American professional baseball player and best-selling author.");
		book.addAuthor(author);
		
		publishingDao.save(book);
		List<Book> books = publishingDao.findAllBooks();
		listBooksWithCategoryAndAuthor(books);
		logger.info("============== Insert book with author(s) end ==============");
		
		ctx.close();
	}
	
	public static void listBooksWithCategoryAndAuthor(List<Book> books) {
	books.forEach(b -> {
		logger.info(b.toString());
		Category cat = b.getCategory();
		logger.info(cat.toString());
		
		b.getAuthors().forEach(a -> logger.info(a.toString()));
		System.out.println("\n");

		});
	}		
}