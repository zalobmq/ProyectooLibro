package model.MariaDBDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import model.Book;
import model.IDAO.DAOException;
import utils.PersistenceUnit;

public class BookImpMariaDB {

	public static EntityManager createEM() {
		EntityManagerFactory emf=PersistenceUnit.getInstance();
		
		return emf.createEntityManager();
	}
	
	public static EntityTransaction beginsession() {
		EntityManager em=createEM();
		return em.getTransaction();
	}
	
	public List<Book> getAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean delete(Book b) throws DAOException {
		boolean result=false;
		try {
			EntityManager em=createEM();
			em.getTransaction().begin();
			em.remove(b);
			em.getTransaction().commit();
			result =true;
			
		} catch (Exception e) {
			result=false;
			throw new DAOException("Can´t delete");
		}
		return result;
	}

	public static boolean save(Book b) throws DAOException {
		boolean result=false;
		try {
			EntityManager em=createEM();
			em.getTransaction().begin();
			em.persist(b);
			em.getTransaction().begin();
			result=true;
		} catch (Exception e) {
			result=false;
			throw new DAOException("Can´t save");
		}
		
		return result;
	}

	

	public static Book getByID(long id) throws DAOException {
		Book result=new Book();
		return result;
	}

	public static List<Book> getByName(String name) throws DAOException {
		List<Book> result=new ArrayList<Book>();
		
		return result;
	}
	
	

}
