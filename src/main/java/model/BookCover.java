package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BookCover")
@NamedQueries({
	//consulta para traer todos las portadas
	@NamedQuery(name="ShowAllBookcover",query = "SELECT b FROM BookCover b "),
	//consulta para buscar notas por libro
	@NamedQuery(name="FindByBookcoverBook",query="SELECT b FROM BookCover b WHERE b.book.id=:Book_id")
	
})
public class BookCover {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "IMAGE")
	private String image;
	@OneToOne(mappedBy = "bookcover", cascade = {CascadeType.ALL, CascadeType.MERGE}, orphanRemoval = true, fetch = FetchType.EAGER)
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
		this.id = -1L;
		this.image = "not found";
		this.book = new Book();
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
		return "BookCover [id=" + id + ", image=" + image + ", book=" + book.getTitle() + "]";
	}

}
