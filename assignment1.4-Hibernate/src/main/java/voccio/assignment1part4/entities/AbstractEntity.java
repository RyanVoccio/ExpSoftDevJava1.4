package voccio.assignment1part4.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by iuliana.cosmina.
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    /**
	   @Id means it’s the primary key of the object. Hibernate will use it as the unique 
	   identifier when managing the singer   entity instances within its session. Additionally, 
	   the @GeneratedValue annotation tells Hibernate how the id value was generated. 
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false)
	protected Long id;
	
	/**This instructs Hibernate that we would like to use an optimistic locking mechanism, 
	   using the version attribute as a control.
	*/
//	@Version
//	@Column(name = "VERSION")
//	private int version;

	/**
	 * Returns the entity identifier. This identifier is unique per entity. It is used by persistence 
	 * frameworks used in a project, and although is public, it should not be used by application code.
	 * This identifier is mapped by ORM (Object Relational Mapper) to the database primary key of the Person 
	 * record to which the entity instance is mapped.
	 *
	 * @return the unique entity identifier
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the entity identifier. This identifier is unique per entity.  Is is used by persistence frameworks
	 * and although is public, it should never be set by application code.
	 *
	 * @param id the unique entity identifier
	 */
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		AbstractEntity that = (AbstractEntity) o;
		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}
}
