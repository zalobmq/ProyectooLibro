package launch;

import javax.persistence.EntityManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Note;
import model.IDAO.DAOException;
import model.MariaDBDAO.NoteImpMariaDB;
import model.h2DAO.NoteImpH2;
public class testNote {
	private static EntityManager em;
	private static EntityManagerFactory emf;
	public static void main(String[] args) {
		saveTest();

	}
	{
		emf=Persistence.createEntityManagerFactory("aplicacionH2");
		em=emf.createEntityManager();
		em.getTransaction().begin();
		Note n1 = new Note();
		em.persist(n1);
		em.getTransaction().commit();
	}
	static void saveTest() {
		Note n1 = new Note("Prueba","Probando");
		/*
		try {
			NoteImpH2.save(n1);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		try {
			NoteImpMariaDB.save(n1);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
