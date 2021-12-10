package model.MariaDBDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import model.BookCover;
import model.IDAO.DAOException;
import utils.PersistenceUnit;

public class BookcoverImpMariaDB {

	public static EntityManager createEM() {
		EntityManagerFactory emf = PersistenceUnit.getInstance();

		return emf.createEntityManager();
	}

	public static EntityTransaction beginsession() {
		EntityManager em = createEM();
		return em.getTransaction();
	}

	public static List<BookCover> getAll() throws DAOException {
		List<BookCover> result = new ArrayList<>();

		return result;
	}

	public static boolean delete(BookCover bc) throws DAOException {
		boolean result = false;
		try {
			EntityManager em = createEM();
			em.getTransaction().begin();
			em.remove(bc);
			em.getTransaction().commit();
			result = true;

		} catch (Exception e) {
			result = false;
			throw new DAOException("Can´t delete", e);
		}
		return result;
	}

	public static boolean save(BookCover bc) throws DAOException {
		boolean result = false;
		try {
			EntityManager em = createEM();
			em.getTransaction().begin();
			em.persist(bc);
			em.getTransaction().begin();
			result = true;
		} catch (Exception e) {
			result = false;
			throw new DAOException("Can´t save", e);
		}

		return result;
	}

	public static BookCover getByID(long id) throws DAOException {
		BookCover result=new BookCover();
		
		return result;
	}

	public static List<BookCover> getByName(String name) throws DAOException {
		List<BookCover> result = new ArrayList<>();

		return result;
	}
}
