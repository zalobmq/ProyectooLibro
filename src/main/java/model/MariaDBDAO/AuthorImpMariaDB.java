package model.MariaDBDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import model.Author;
import model.IDAO.DAOException;
import utils.PersistenceUnit;

public class AuthorImpMariaDB{
	
	public static EntityManager createEM() {
		EntityManagerFactory emf=PersistenceUnit.getInstance();
		
		return emf.createEntityManager();
	}
	
	public static EntityTransaction beginsession() {
		EntityManager em=createEM();
		return em.getTransaction();
	}

	
	public static List<Author> getAll() throws DAOException {
		List<Author> result=new ArrayList<Author>();
		
		return result;
	}

	
	public static boolean delete(Author a) throws DAOException {
		boolean result=false;
		try {
			EntityManager em=createEM();
			em.getTransaction().begin();
			em.remove(a);
			em.getTransaction().commit();
			result =true;
			
		} catch (Exception e) {
			result=false;
			throw new DAOException("Can´t delete",e);
		}
		return result;
		
	}

	public static boolean save(Author a) throws DAOException {
		boolean result=false;
		try {
			EntityManager em=createEM();
			em.getTransaction().begin();
			em.persist(a);
			em.getTransaction().begin();
			result=true;
		} catch (Exception e) {
			result=false;
			throw new DAOException("Can´t save",e);
		}
		
		return result;
	}

	

	
	public static Author getByID(long id) throws DAOException {
		Author result=new Author();
		
		return result;
	}

	
	public static List<Author> getByName(String name) throws DAOException {
		List<Author> result=new ArrayList<Author>();
		
		return result;
		
	}
	
	

}
