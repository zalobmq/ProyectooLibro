package utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="servers")
public class PersistenceUnit {
	private static EntityManagerFactory emf;
	private static final String PUN="aplicacionH2";
	
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



	
	
	

}
