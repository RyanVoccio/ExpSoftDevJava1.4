package voccio.assignment1part4.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import voccio.assignment1part4.entities.Author;
import voccio.assignment1part4.entities.Book;
import voccio.assignment1part4.entities.Category;

@SuppressWarnings("unchecked")
@Transactional
@Repository("publishingDao")
public class PublishingDaoImpl implements PublishingDao {
	
	private static final Log logger = LogFactory.getLog(PublishingDaoImpl.class);
	private SessionFactory sessionFactory;
	
	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(readOnly = true)
	public Book findBookWithCategoryAndAuthorById(Long id) {
		return (Book) sessionFactory.getCurrentSession().
				getNamedQuery("Book.findBookWithCategoryAndAuthorById").
				setParameter("id", id).uniqueResult();
	}
	
	@Transactional(readOnly = true)
	public List<Book> findAllWithCategoryAndAuthorByAuthorId(Long id) {
		return sessionFactory.getCurrentSession().
				getNamedQuery("Book.findAllWithCategoryAndAuthorByAuthorId").
				setParameter("id", id).list();
	}
	
	@Transactional(readOnly = true)
	public Category getCategoryById(Long id)
	{
		return (Category) sessionFactory.getCurrentSession().
		getNamedQuery("Category.getCategoryById").
		setParameter("id", id).uniqueResult();
	}
	
	@Transactional(readOnly = true)
	public List<Book> findAllBooks() {
		return sessionFactory.getCurrentSession().getNamedQuery("Book.findAllBooks").list();
	}
	
	public Book save(Book book) {
		sessionFactory.getCurrentSession().saveOrUpdate(book);
		logger.info("Book saved with id: " + book.getId());
		return book;
	}

	public void delete(Book book) {
		sessionFactory.getCurrentSession().delete(book);
		logger.info("Book deleted with id: " + book.getId());
	}
	
	public Author save(Author author) {
		sessionFactory.getCurrentSession().saveOrUpdate(author);
		logger.info("Author saved with id: " + author.getId());
		return author;
	}

	public void delete(Author author) {
		sessionFactory.getCurrentSession().delete(author);
		logger.info("Author deleted with id: " + author.getId());
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
