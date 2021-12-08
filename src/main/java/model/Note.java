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
	@Column(name = "ID")
	private Long id;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "TEXT")
	private String text;

	public Note(Long id, String title, String text) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
	}

	public Note(String title, String text) {
		super();
		this.title = title;
		this.text = text;
	}

	public Note() {
		super();
		this.title = "Not found";
		this.text = "Not found";
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
