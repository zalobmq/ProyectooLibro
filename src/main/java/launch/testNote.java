package launch;

import javax.persistence.EntityManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Author;
import model.Note;
public class testNote {
	private static EntityManager em;
	private static EntityManagerFactory emf;
	public static void main(String[] args) {
		Author a = new Author();
		System.out.println(a.toString());
		emf=Persistence.createEntityManagerFactory("aplicacionMariaDB");
		em=emf.createEntityManager();
		em.getTransaction().begin();
		Note n1 = new Note();
		em.persist(n1);
		em.getTransaction().commit();

	}

}
