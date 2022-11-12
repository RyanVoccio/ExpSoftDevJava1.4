package voccio.assignment1part4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import voccio.assignment1part4.config.AppConfig;
import voccio.assignment1part4.dao.PublishingDao;
import voccio.assignment1part4.entities.Book;


public class DeleteBookAndAuthor {
	private static Logger logger = LoggerFactory.getLogger(
			DeleteBookAndAuthor.class);

	public static void main(String... args) {
		GenericApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		PublishingDao publishingDao = ctx.getBean(PublishingDao.class);
		
		logger.info("============== Delete book by ID start ==============");
		Long idDelete = 6L;
		Book bookDelete = publishingDao.findBookWithCategoryAndAuthorById(idDelete);
		publishingDao.delete(bookDelete);
		InsertBookAndAuthor.listBooksWithCategoryAndAuthor(
				publishingDao.findAllBooks());
		logger.info("============== Delete book by ID end ==============");
		
		ctx.close();
	}
}