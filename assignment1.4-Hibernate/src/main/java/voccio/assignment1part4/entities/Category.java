package voccio.assignment1part4.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "category")
public class Category extends AbstractEntity {
	
	public static final String GET_CATEGORY_BY_ID = 
			"Category.getCategoryById";
	
	@Column
	private String name;
	
	@OneToMany(mappedBy = "category", cascade=CascadeType.ALL,
			orphanRemoval=true)
	private Set<Book> books = new HashSet<>();
	
//	@ManyToOne
//	@JoinColumn(name = "BOOK_ID")
//	private Book book;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

//	public Book getBook() {
//		return book;
//	}
//
//	public void setBook(Book book) {
//		this.book = book;
//	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(name);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Category -- Id:" + id + " Name: " + name;
	}


}
