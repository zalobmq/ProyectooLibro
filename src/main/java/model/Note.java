package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Note")
public class Note implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "tittle")
	private String title;
	@Column(name = "text")
	private String text;

	public Note(long id, String title, String text) {
		
		this.id = id;
		this.title = title;
		this.text = text;
	}

	public Note(String title, String text) {
		
		this.title = title;
		this.text = text;
	}

	public Note() {
		this.id=-1;
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

	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", text=" + text + "]";
	}

}
