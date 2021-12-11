package model.MariaDBDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import model.Landscape;
import model.IDAO.DAOException;
import utils.PersistenceUnit;

public class CharacterImpMariaDB {

	public static EntityManager createEM() {
		EntityManagerFactory emf = PersistenceUnit.getInstance("aplicacionH2");

		return emf.createEntityManager();
	}

	public static EntityTransaction beginsession() {
		EntityManager em = createEM();
		return em.getTransaction();
	}

	public static List<Landscape> getAll() throws DAOException {
		List<Landscape> result = new ArrayList<Landscape>();
		return result;
	}

	public static boolean delete(Landscape l) throws DAOException {
		boolean result = false;
		try {
			EntityManager em = createEM();
			em.getTransaction().begin();
			em.remove(l);
			em.getTransaction().commit();
			result = true;

		} catch (Exception e) {
			result = false;
			throw new DAOException("Can´t delete", e);
		}
		return result;
	}

	public static boolean save(Landscape l) throws DAOException {
		boolean result = false;
		try {
			EntityManager em = createEM();
			em.getTransaction().begin();
			em.persist(l);
			em.getTransaction().commit();
			;
			result = true;
		} catch (Exception e) {
			result = false;
			throw new DAOException("Can´t save", e);
		}

		return result;
	}

	public static Landscape getByID(long id) throws DAOException {
		Landscape result = new Landscape();

		return result;
	}

	public static List<Landscape> getByName(String name) throws DAOException {
		List<Landscape> result = new ArrayList<Landscape>();

		return result;
	}

}
