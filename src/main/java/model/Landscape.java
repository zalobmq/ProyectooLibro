package model;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Landscape")
@NamedQueries({
	//consulta para buscar paisajes por el nombre
	@NamedQuery(name="findByLandscapeName",query="SELECT l FROM Landscape l WHERE l.name =:name"),
	//consulta para traer todos los paisajes
	@NamedQuery(name="ShowAllLandscape",query = "SELECT l FROM Landscape l "),
	//consulta para buscar paisajes por libro
	//@NamedQuery(name="FindByLandscapesBook",query="SELECT l.Landscape_id FROM books_landscape l,   l.Book_id=:Book_id ")
	
})
public class Landscape {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "DESCRIPTION")
	private String description;
	  @ManyToMany(cascade = {
	            CascadeType.ALL,
	            CascadeType.ALL,
	    }  )
	    @JoinTable(
	            name = "Landscape_Book",
	            joinColumns = {@JoinColumn(name = "Landscape_id")},
	            inverseJoinColumns = {@JoinColumn(name = "Book_id")}
	    )	
	private List<Book> books_landscape;
	
	public Landscape(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	

	public Landscape(String name, String description, List<Book> books_landscape) {
		super();
		this.name = name;
		this.description = description;
		this.books_landscape = new ArrayList<Book>();
	}



	public Landscape(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Landscape() {
		super();
		this.id = -1L;
		this.name = "Not found";
		this.description = "Not found";
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

	@Override
	public String toString() {
		return "Landscape [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
}
