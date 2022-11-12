package voccio.assignment1part4;

import voccio.assignment1part4.config.AppConfig;
import voccio.assignment1part4.dao.PublishingDao;
import voccio.assignment1part4.entities.Book;
import voccio.assignment1part4.entities.Category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;


public class FindBookWithCategoryAndAuthorById {
	private static Logger logger = LoggerFactory.getLogger(
			FindBookWithCategoryAndAuthorById.class);

	public static void main(String... args) {
		GenericApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		PublishingDao publishingDao = ctx.getBean(PublishingDao.class);
		
		logger.info("============== Find book with category and authors by ID start ==============");
		Long idFind = 5L;
		Book  bookById = publishingDao.findBookWithCategoryAndAuthorById(idFind);
		logger.info(bookById.toString());
	
		Category cat = bookById.getCategory();
		logger.info(cat.toString());
		
		bookById.getAuthors().forEach(a -> logger.info(a.toString()));
		logger.info("============== Find book with category and authors by ID end ==============");
		
		ctx.close();
	}
}