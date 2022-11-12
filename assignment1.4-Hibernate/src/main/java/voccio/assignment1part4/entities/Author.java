package voccio.assignment1part4.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "author")
//@NamedQueries({
//	@NamedQuery(name=Author.FIND_ALL_WITH_CATEGORY_AUTHOR_BY_AUTHOR_ID,
//			query="select b from book b " +
//					"join author_book ab on b.id = ab.book_id " +
//					"join author a on ab.author_id = a.id " +
//					"where a.id = :id"
////			query="select distinct b from Book b " +
////					"left join fetch b.category c " +
////					"left join fetch b.authors a" +
////					"where a.id = :id"
//			)
//})



public class Author extends AbstractEntity {
	
//	public static final String FIND_ALL_WITH_CATEGORY_AUTHOR_BY_AUTHOR_ID = 
//			"Author.findAllWithCategoryAndAuthorByAuthorId";

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@ManyToMany
	@JoinTable(name = "author_book",
			joinColumns = @JoinColumn(name = "AUTHOR_ID"),
			inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
	private Set<Book> books = new HashSet<>();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public void setBook(Book book) {
		this.books.add(book);
	}
	
	public void addBook(Book book)
	{
		this.books.add(book);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(description, firstName, lastName);
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
		Author other = (Author) obj;
		return Objects.equals(description, other.description) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		return "Author -- Id:" + id + " First Name: " + firstName + ", Last Name: " + lastName + ", Description: " + description;
	}
	
	
}
