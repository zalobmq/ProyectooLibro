package launch;

import javax.persistence.EntityManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Author;
import model.Note;
import model.IDAO.DAOException;
import model.MariaDBDAO.NoteImpMariaDB;
import model.h2DAO.NoteImpH2;
public class testNote {
	private static EntityManager em;
	private static EntityManagerFactory emf;
	public static void main(String[] args) {
		//saveTestH2();
		//test();
		//saveTestMariaDB();
	}
	static void test(){
		
		emf=Persistence.createEntityManagerFactory("aplicacionH2");
		em=emf.createEntityManager();
		em.getTransaction().begin();
		Note n1 = new Note();
		Note n2 = new Note();
		em.persist(n1);
		em.persist(n2);
		em.getTransaction().commit();
	}
	
	static void saveTestH2() {
		Note n1=new Note("Titulo","descricpcion");
		try {
			NoteImpH2.save(n1);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void saveTestMariaDB() {
		Note n1=new Note("Titulo","descricpcion");
		
		try {
			NoteImpMariaDB.save(n1);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
