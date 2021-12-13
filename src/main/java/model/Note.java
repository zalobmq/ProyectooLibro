package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Note")
@NamedQueries({
	//consulta para buscar notas por el nombre
	@NamedQuery(name="findByNoterName",query="SELECT n FROM Note n WHERE n.title =:title"),
	//consulta para traer todos las notas
	@NamedQuery(name="ShowAllNotes",query = "SELECT n FROM Note n "),
	//consulta para buscar notas por libro
	@NamedQuery(name="FindByNotesBook",query="SELECT n FROM Note n WHERE n.book_note.id=:Book_id")
	
})
public class Note implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "tittle")
	private String title;
	@Column(name = "text")
	private String text;
	@ManyToOne()
	@JoinColumn(name = "Book_id")
	private Book book_note;

	public Note(long id, String title, String text) {
		
		this.id = id;
		this.title = title;
		this.text = text;
	}

	public Note(String title, String text) {
		
		this.title = title;
		this.text = text;
		this.book_note = new Book();
	}

	public Note() {
		this.id=-1L;
		this.title = "Not found";
		this.text = "Not found";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	/**
	 * @return the book_note
	 */
	public Book getBook_note() {
		return book_note;
	}

	/**
	 * @param book_note the book_note to set
	 */
	public void setBook_note(Book book_note) {
		this.book_note = book_note;
	}

	

	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", text=" + text + "]";
	}

}
