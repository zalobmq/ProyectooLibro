package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Chapter")
public class Chapter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "CHAPTERNUMBER")
	private int chapterNumber;
	@Column(name = "FINISH")
	private boolean finish;
	
	private List<Note> notes;

	public Chapter(Long id, String name, int chapterNumber, boolean finish, List<Note> notes) {
		super();
		this.id = id;
		this.name = name;
		this.chapterNumber = chapterNumber;
		this.finish = finish;
		this.notes = notes;
	}

	public Chapter(String name, int chapterNumber, boolean finish, List<Note> notes) {
		super();
		this.name = name;
		this.chapterNumber = chapterNumber;
		this.finish = finish;
		this.notes = notes;
	}

	public Chapter() {
		super();
		this.id = -1L;
		this.name = "Not found";
		this.chapterNumber = 0;
		this.finish = true;
		this.notes = null;
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

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Chapter [id=" + id + ", name=" + name + ", chapterNumber=" + chapterNumber + ", finish=" + finish
				+ ", notes=" + notes + "]";
	}

}
