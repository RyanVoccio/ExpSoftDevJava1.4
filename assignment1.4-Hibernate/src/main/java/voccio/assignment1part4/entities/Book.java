package voccio.assignment1part4.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Entity
@Table(name = "book")
@NamedQueries({
		@NamedQuery(name=Book.FIND_BOOK_WITH_CATEGORY_AUTHOR_BY_ID,
				query="select distinct b from Book b " +
						"left join fetch b.category c " +
						"left join fetch b.authors a " +
						"where b.id = :id"),
		@NamedQuery(name=Book.FIND_ALL_WITH_CATEGORY_AUTHOR_BY_AUTHOR_ID,
				query="select distinct b from Book b " +
						"left join fetch b.category c " +
						"left join fetch b.authors a " +
						"where a.id = :id"),
		@NamedQuery(name=Book.FIND_ALL_BOOKS,
				query="select distinct b from Book b " +
						"left join fetch b.category c " +
						"left join fetch b.authors a "),
		@NamedQuery(name=Category.GET_CATEGORY_BY_ID,
				query="select distinct c from Category c " +
						"where c.id = :id")
})

public class Book extends AbstractEntity{
	
	public static final String FIND_BOOK_WITH_CATEGORY_AUTHOR_BY_ID = 
			"Book.findBookWithCategoryAndAuthorById";
	public static final String FIND_ALL_WITH_CATEGORY_AUTHOR_BY_AUTHOR_ID = 
			"Book.findAllWithCategoryAndAuthorByAuthorId";
	public static final String FIND_ALL_BOOKS = 
			"Book.findAllBooks";
	
	//private Long id;
	@Column(name = "ISBN")
	private String isbn;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "PRICE")
	private Float price;
	
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;


	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "author_book",
			joinColumns = @JoinColumn(name = "BOOK_ID"),
			inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
	Set<Author> authors = new HashSet<>();
	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	public String getIsbn()
	{
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void addAuthor(Author author) {
		this.authors.add(author);
	}

	public void removeAuthor(Author author) {
		authors.remove(author);
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id.hashCode();
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + price.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (price != other.price)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book -- Id:" + id + ", Category -- Id:" + category.id + ", Isbn: " + isbn + ", Title: " + title + ", Price: $" + price + "]";
	}
}
