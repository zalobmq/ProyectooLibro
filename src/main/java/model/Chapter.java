package model;

import java.util.List;

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
@Table(name = "Chapter")
@NamedQueries({
		// consulta para buscar capítulos por el nombre
		@NamedQuery(name = "findByChapterName", query = "SELECT c FROM Chapter c WHERE c.name =:name"),
		// consulta para traer todos los capítulos
		@NamedQuery(name = "ShowAllChapters", query = "SELECT c FROM Chapter c "),
		// consulta para buscar capítulos por libro
		@NamedQuery(name = "FindByChapterBook", query = "SELECT c FROM Chapter c WHERE c.book_chapter.id=:Book_id")

})
public class Chapter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "TEXT")
	private String text;
	@Column(name = "CHAPTERNUMBER")
	private int chapterNumber;
	@Column(name = "FINISH")
	private boolean finish;
	@ManyToOne()
	@JoinColumn(name = "Book_id")
	private Book book_chapter;

	public Chapter(Long id, String name, String text, int chapterNumber, boolean finish) {
		super();
		this.id = id;
		this.name = name;
		this.text = text;
		this.chapterNumber = chapterNumber;
		this.finish = finish;
	}

	public Chapter(String name, String text, int chapterNumber, boolean finish, Book book_chapter) {
		super();
		this.name = name;
		this.text = name;
		this.chapterNumber = chapterNumber;
		this.finish = finish;
		this.book_chapter = book_chapter;
	}

	public Chapter(String name, String text, int chapterNumber, boolean finish) {
		super();
		this.name = name;
		this.text = text;
		this.chapterNumber = chapterNumber;
		this.finish = finish;
		this.book_chapter = new Book();
	}

	public Chapter() {
		super();
		this.id = -1L;
		this.name = "Not found";
		this.text = "Not found";
		this.chapterNumber = 0;
		this.finish = true;
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

	public int getChapterNumber() {
		return chapterNumber;
	}

	public void setChapterNumber(int chapterNumber) {
		this.chapterNumber = chapterNumber;
	}

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Book getBook_chapter() {
		return book_chapter;
	}

	public void setBook_chapter(Book book_chapter) {
		this.book_chapter = book_chapter;
	}

	@Override
	public String toString() {
		return "Chapter [id=" + id + ", name=" + name + ", text=" + text + ", chapterNumber=" + chapterNumber
				+ ", finish=" + finish + ", book_chapter=" + book_chapter.getTitle() + "]";
	}



}
