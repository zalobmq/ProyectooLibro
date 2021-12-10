package model.h2DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import model.Chapter;
import model.IDAO.DAOException;
import utils.PersistenceUnit;

public class ChapterImpH2 {

	public static EntityManager createEM() {
		EntityManagerFactory emf = PersistenceUnit.getInstance();

		return emf.createEntityManager();
	}

	public static EntityTransaction beginsession() {
		EntityManager em = createEM();
		return em.getTransaction();
	}

	public static List<Chapter> getAll() throws DAOException {
		List<Chapter> result = new ArrayList<Chapter>();

		return result;
	}

	public static boolean delete(Chapter c) throws DAOException {

		boolean result = false;
		try {
			EntityManager em = createEM();
			em.getTransaction().begin();
			em.remove(c);
			em.getTransaction().commit();
			result = true;

		} catch (Exception e) {
			result = false;
			throw new DAOException("Can´t delete", e);
		}
		return result;
	}

	public static boolean save(Chapter c) throws DAOException {
		boolean result = false;
		try {
			EntityManager em = createEM();
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().begin();
			result = true;
		} catch (Exception e) {
			result = false;
			throw new DAOException("Can´t save", e);
		}

		return result;
	}

	public static Chapter getByID(long id) throws DAOException {
		Chapter result = new Chapter();

		return result;
	}

	public static List<Chapter> getByName(String name) throws DAOException {
		List<Chapter> result = new ArrayList<Chapter>();

		return result;
	}

}
