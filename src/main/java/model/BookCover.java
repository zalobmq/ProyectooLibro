package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BookCover")
public class BookCover {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "IMAGE")
	private String image;
	private Book book;

	public BookCover(Long id, String image, Book book) {
		super();
		this.id = id;
		this.image = image;
		this.book = book;
	}

	public BookCover(String image, Book book) {
		super();
		this.image = image;
		this.book = book;
	}

	public BookCover() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "BookCover [id=" + id + ", image=" + image + ", book=" + book + "]";
	}

}
