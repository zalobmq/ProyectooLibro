package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Saga")
public class Saga {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@OneToMany(mappedBy = "saga", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Book> books_saga;

	public Saga(Long id, String name, List<Book> books_saga) {
		super();
		this.id = id;
		this.name = name;
		this.books_saga = books_saga;
	}

	public Saga(String name, List<Book> books_saga) {
		super();
		this.name = name;
		this.books_saga = books_saga;
	}

	public Saga() {
		super();
		this.id = -1L;
		this.name = "Not found";
		this.books_saga = null;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getbooks_saga() {
		return books_saga;
	}

	public void setbooks_saga(List<Book> books_saga) {
		this.books_saga = books_saga;
	}

	@Override
	public String toString() {
		return "Saga [id=" + id + ", name=" + name + ", books_saga=" + books_saga + "]";
	}

}
