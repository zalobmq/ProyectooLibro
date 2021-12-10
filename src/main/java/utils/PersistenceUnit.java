package utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="servers")
public class PersistenceUnit {
	//esto son pruebas
	private String name;
	
	
	private static EntityManagerFactory emf;
	private static final String PUN="aplicacionMariaDB";
	
	public static EntityManagerFactory getInstance() {
		if(emf==null) {
			emf=Persistence.createEntityManagerFactory(PUN);
		}
		return emf;
	}
	public static EntityManagerFactory getInstance(String name) {
		if(emf==null) {
			emf=Persistence.createEntityManagerFactory(name);
		}
		return emf;
	}

	public PersistenceUnit() {
		super();
	}

	public PersistenceUnit(String name) {
		super();
		this.name = name;
		
	}

	/**
	 * @return the name
	 */
	@XmlElement(name="name")
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the pun
	 */
	public static String getPun() {
		return PUN;
	}



	
	
	

}
