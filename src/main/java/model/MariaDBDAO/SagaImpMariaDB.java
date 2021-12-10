package model.MariaDBDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import model.Saga;
import model.IDAO.DAOException;
import utils.PersistenceUnit;

public class SagaImpMariaDB {
	
	public static EntityManager createEM() {
		EntityManagerFactory emf=PersistenceUnit.getInstance();
		
		return emf.createEntityManager();
	}
	
	public static EntityTransaction beginsession() {
		EntityManager em=createEM();
		return em.getTransaction();
	}


	public static List<Saga> getAll() throws DAOException {
		List<Saga> result=new ArrayList<Saga>();
		
		return result;
	}

	
	public static boolean delete(Saga s) throws DAOException {
		boolean result=false;
		try {
			EntityManager em=createEM();
			em.getTransaction().begin();
			em.remove(s);
			em.getTransaction().commit();
			result =true;
			
		} catch (Exception e) {
			result=false;
			throw new DAOException("Can´t delete");
		}
		return result;
	}

	public static boolean save(Saga s) throws DAOException {
		boolean result=false;
		try {
			EntityManager em=createEM();
			em.getTransaction().begin();
			em.persist(s);
			em.getTransaction().begin();
			result=true;
		} catch (Exception e) {
			result=false;
			throw new DAOException("Can´t save");
		}
		
		return result;
	}

	public static Saga getByID(long id) throws DAOException {
		Saga result=new Saga();
		
		return result;
	}

	public static List<Saga> getByName(String name) throws DAOException {
		List<Saga> result=new ArrayList<>();
		
		return result;
	}

}
