package model.MariaDBDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import model.Note;
import model.IDAO.DAOException;
import utils.PersistenceUnit;

public class NoteImpMariaDB {
	
	
	public static EntityManager createEM() {
		EntityManagerFactory emf=PersistenceUnit.getInstance();
		
		return emf.createEntityManager();
	}
	
	public static EntityTransaction beginsession() {
		EntityManager em=createEM();
		return em.getTransaction();
	}


	public static List<Note> getAll() throws DAOException {
		List<Note> result=new ArrayList<Note>();
		
		return result;
	}

	public static boolean delete(Note n) throws DAOException {
		boolean result=false;
		try {
			EntityManager em=createEM();
			em.getTransaction().begin();
			em.remove(n);
			em.getTransaction().commit();
			result =true;
			
		} catch (Exception e) {
			result=false;
			throw new DAOException("Can´t delete");
		}
		return result;
	}

	public static boolean save(Note n) throws DAOException {
		boolean result=false;
		try {
			EntityManager em=createEM();
			em.getTransaction().begin();
			em.remove(n);
			em.getTransaction().commit();
			result =true;
			
		} catch (Exception e) {
			result=false;
			throw new DAOException("Can´t delete");
		}
		return result;
	}

	public static Note getByID(long id) throws DAOException {
		Note result=new Note();
		
		return result;
		
	}

	public static List<Note> getByName(String name) throws DAOException {
		List<Note> result=new ArrayList<Note>();
		
		return result;
	}

}
