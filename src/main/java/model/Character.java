package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Character")
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
	
	public Character(Long id, String name, String description, boolean death) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.death = death;
	}

	public Character(String name, String description, boolean death) {
		super();
		this.name = name;
		this.description = description;
		this.death = death;
	}

	public Character() {
		super();
		this.id = -1L;
		this.name = "Not found";
		this.description = "Not found";
		this.death = true;
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

	@Override
	public String toString() {
		return "Character [id=" + id + ", name=" + name + ", description=" + description + ", death=" + death + "]";
	}
	
	
	
<<<<<<< HEAD
}
=======
}
>>>>>>> 18f731c1910b868b0f2c24bffdc820c66f35a533
