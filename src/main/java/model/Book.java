package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
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
	private List<Chapter> chapters;
	private List<Note> notes;
	private List<Landscape> landscapes;
	private List<Character> characters;
	
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

	public Book() {
		super();
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

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", sypnosis=" + sypnosis + ", genre=" + genre + ", chapters="
				+ chapters + ", notes=" + notes + ", landscapes=" + landscapes + ", characters=" + characters + "]";
	}
	
	
	
}
