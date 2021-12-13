package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table(name = "Characters")
@NamedQueries({
	//consulta para buscar personajes por el nombre
	@NamedQuery(name="findByCharacterName",query="SELECT c FROM Character c WHERE c.name =:name"),
	//consulta para traer todos los personajes
	@NamedQuery(name="ShowAllCharacter",query = "SELECT c FROM Character c "),
	//consulta para buscar paisajes por libro
	@NamedQuery(name="FindByCharacterBook",query="SELECT c FROM Character c JOIN c.books_character b on  b.id=:Book_id ")
	
})
public class Character {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "DEATH")
	private boolean death;
	@ManyToMany(cascade = { CascadeType.ALL, CascadeType.MERGE })
	@JoinTable(name = "character_book", joinColumns = { @JoinColumn(name = "Character_id") }, inverseJoinColumns = {
			@JoinColumn(name = "Book_id") })
	private List<Book> books_character;
	
	

	public Character(Long id, String name, String description, boolean death, List<Book> books_character) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.death = death;
		this.books_character = books_character;
	}
	
	public Character(String name, String description, boolean death) {
		super();
		this.name = name;
		this.description = description;
		this.death = death;
		this.books_character = new ArrayList<Book>();
	}

	public Character(Long id, String name, String description, boolean death) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.death = death;
	}

	public Character() {
		super();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDeath() {
		return death;
	}

	public void setDeath(boolean death) {
		this.death = death;
	}

	
	/**
	 * @return the books_character
	 */
	public List<Book> getBooks_character() {
		return books_character;
	}

	/**
	 * @param books_character the books_character to set
	 */
	public void setBooks_character(List<Book> books_character) {
		this.books_character = books_character;
	}

	public List<String> Books_characterString(){
		List<String> result=new ArrayList<>();
		for(Book book: books_character) {
			result.add(book.getTitle());
		}
		return result;
	}
	@Override
	public String toString() {
		return "Character [id=" + id + ", name=" + name + ", description=" + description + ", death=" + death +", Book"+Books_characterString().toString()+ "]";
	}

}
