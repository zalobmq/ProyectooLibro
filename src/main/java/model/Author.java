package model;

import java.util.ArrayList;
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
@Table(name = "Author")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "SURNAME")
	private String surname;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "EMAIL")
	private String email;
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Book> books_author;

	public Author(Long id, String name, String surname, String password, String email, List<Book> books_author) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.email = email;
		this.books_author = books_author;
	}

	public Author(String name, String surname, String password, String email, List<Book> books_author) {
		super();
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.email = email;
		this.books_author = books_author;
	}

	public Author(String name, String surname, String password, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.email = email;
		this.books_author = new ArrayList<Book>();
	}

	public Author() {
		super();
		this.id = -1L;
		this.name = "Not found";
		this.surname = "Not found";
		this.password = "Not found";
		this.email = "Not found";
		this.books_author = new ArrayList<Book>();
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Book> getbooks_author() {
		return books_author;
	}

	public void setbooks_author(List<Book> books_author) {
		this.books_author = books_author;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", surname=" + surname + ", password=" + password + ", email="
				+ email + ", books_author=" + books_author + "]";
	}

}
