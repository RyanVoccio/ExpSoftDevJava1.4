package voccio.assignment1part4;

import voccio.assignment1part4.config.AppConfig;
import voccio.assignment1part4.dao.PublishingDao;
import voccio.assignment1part4.entities.Author;
import voccio.assignment1part4.entities.Book;
import voccio.assignment1part4.entities.Category;

import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;


import java.util.List;

public class FindAllWithCategoryAndAuthorByAuthorId {
	private static Logger logger = LoggerFactory.getLogger(
			FindAllWithCategoryAndAuthorByAuthorId.class);

	public static void main(String... args) {
		GenericApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		PublishingDao publishingDao = ctx.getBean(PublishingDao.class);
		
		logger.info("============== Find books with category and authors by authors ID start ==============");
		Long idFind = 2L;
		logger.info("Listing books by author id:" + idFind);
		
		//Author author = publishingDao.findAllWithCategoryAndAuthorByAuthorId(idFind);
		List<Book> books = publishingDao.findAllWithCategoryAndAuthorByAuthorId(idFind);
		
		books.forEach(b -> {
			logger.info(b.toString());
			
			Category cat = b.getCategory();
			logger.info(cat.toString());
			
			b.getAuthors().forEach(a -> logger.info(a.toString()));
		});
		
		//Book  bookById = publishingDao.findBookWithCategoryAndAuthorById(idFind);
		//listBooksWithCategoryAndAuthor(booksByAuthorId, idFind);
		logger.info("============== Find books with category and authors by authors ID end ==============");
		
		ctx.close();
	}
	
//	public static void listBooksWithCategoryAndAuthor(List<Author> books, Long id) {
//		logger.info(" ---- Listing books by author id: " + id);
//		books.forEach(b -> {
//			logger.info(b.toString());
//			Category cat = b.getCategory();
//			logger.info(cat.toString());
//			
//			b.getAuthors().forEach(a -> logger.info(a.toString()));
//
//		});
//	}		
}
