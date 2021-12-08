package launch;

import javax.persistence.EntityManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Note;
public class testNote {
	private static EntityManager em;
	private static EntityManagerFactory emf;
	public static void main(String[] args) {
		emf=Persistence.createEntityManagerFactory("aplicacionMariaDB");
		em=emf.createEntityManager();
		em.getTransaction().begin();
		Note n1 = new Note();
		em.persist(n1);
		em.getTransaction().commit();

	}

}
