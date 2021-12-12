package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
@NamedQueries({
		// consulta para buscar libros por el nombre
		@NamedQuery(name = "findByBookName", query = "SELECT b FROM Book b WHERE b.title =:title"),
		// consulta para traer todos los libros
		@NamedQuery(name = "ShowAllBooks", query = "SELECT b FROM Book b "),
		// consulta para buscar libros por autor
		@NamedQuery(name = "FindBookByAuthor", query = "SELECT b FROM Book b WHERE author.id=:author_id")

})
public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "SYPNOSIS")
	private String sypnosis;
	@Column(name = "GENRE")
	private String genre;
	@JoinColumn(name = "book")
	@OneToOne(fetch = FetchType.EAGER)
	private BookCover bookcover;

	@OneToMany(mappedBy = "book_note", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Note> notes;
	@OneToMany(mappedBy = "book_chapter", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Chapter> chapters;
	@ManyToMany(mappedBy = "books_landscape")
	private List<Landscape> landscapes;
	@ManyToMany(mappedBy = "books_character")
	private List<Character> characters;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "books_author")
	private Author author;
	@ManyToOne()
	@JoinColumn(name = "books_saga")
	private Saga saga;

	public Book(Long id, String title, String sypnosis, String genre, List<Chapter> chapters, List<Note> notes,
			List<Landscape> landscapes, List<Character> characters) {
		super();
		this.id = id;
		this.title = title;
		this.sypnosis = sypnosis;
		this.genre = genre;
		this.chapters = chapters;
		this.notes = notes;
		this.landscapes = landscapes;
		this.characters = characters;
	}

	public Book(String title, String sypnosis, String genre, List<Chapter> chapters, List<Note> notes,
			List<Landscape> landscapes, List<Character> characters) {
		super();
		this.title = title;
		this.sypnosis = sypnosis;
		this.genre = genre;
		this.chapters = chapters;
		this.notes = notes;
		this.landscapes = landscapes;
		this.characters = characters;
	}

	public Book(String title, String sypnosis, String genre) {
		super();
		this.title = title;
		this.sypnosis = sypnosis;
		this.genre = genre;
		this.chapters = new ArrayList<Chapter>();
		this.notes = new ArrayList<Note>();
		this.landscapes = new ArrayList<Landscape>();
		this.characters = new ArrayList<Character>();
		this.author = new Author();
		this.saga = new Saga();
	}

	public Book() {
		super();
		this.title = "Not found";
		this.sypnosis = "Not found";
		this.genre = "Not found";
		this.chapters = new ArrayList<Chapter>();
		this.notes = new ArrayList<Note>();
		this.landscapes = new ArrayList<Landscape>();
		this.characters = new ArrayList<Character>();
		this.author = new Author();
		this.saga = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSypnosis() {
		return sypnosis;
	}

	public void setSypnosis(String sypnosis) {
		this.sypnosis = sypnosis;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public List<Landscape> getLandscapes() {
		return landscapes;
	}

	public void setLandscapes(List<Landscape> landscapes) {
		this.landscapes = landscapes;
	}

	public List<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}

	public BookCover getBookcover() {
		return bookcover;
	}

	public void setBookcover(BookCover bookcover) {
		this.bookcover = bookcover;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Saga getSaga() {
		return saga;
	}

	public void setSaga(Saga saga) {
		this.saga = saga;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", sypnosis=" + sypnosis + ", genre=" + genre + ", bookcover="
				+ bookcover + ", notes=" + notes + ", chapters=" + chapters + ", landscapes=" + landscapes
				+ ", characters=" + characters + ", author=" + author.getName() + ", saga=" + saga + "]";
	}

}
