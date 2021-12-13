package model.MariaDBDAO;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import javax.persistence.TypedQuery;

import model.Author;
import model.Chapter;
import model.IDAO.DAOException;
import utils.PersistenceUnit;

public class AuthorImpMariaDB extends Author {

	/*
	 * Método que devuelve emf
	 * 
	 * @Return emf.createEntityManager();
	 */
	public static EntityManager createEM() {
		EntityManagerFactory emf = PersistenceUnit.getInstance("aplicacionMariaDB");

		return emf.createEntityManager();
	}

	/*
	 * Método que crea el objeto para realizar las transacciones
	 * 
	 * @Return em.getTransaction()
	 */
	public static EntityTransaction beginsession() {
		EntityManager em = createEM();
		return em.getTransaction();
	}

	/*
	 * Método que devuelve todos los autores
	 * 
	 * @Return lista de todos los autores existentes en la base de datos
	 */
	public static List<Author> getAll() throws DAOException {
		List<Author> result = new ArrayList<Author>();

		return result;
	}

	/*
	 * Método que borra el autor especificado
	 * 
	 * @Param Author que se quiera borrar
	 * 
	 * @Return Booleano que devuelve verdadero si se ha borrado el autor y falso si
	 * no lo ha conseguido guardar
	 */
	public static boolean delete(Author a) throws DAOException {
		boolean result = false;
		EntityManager em = createEM();
		try {
			em.getTransaction().begin();
			em.remove(a);
			em.getTransaction().commit();
			result = true;

		} catch (Exception e) {
			result = false;
			throw new DAOException("Can´t delete", e);
		} finally {
			em.close();
		}
		return result;

	}

	/*
	 * Método que se usa para guardar un autor
	 * 
	 * @Param Author
	 * 
	 * @Return booleano que devuelve verdadero si se ha conseguido guardar el autor
	 */
	public static boolean save(Author a) throws DAOException {
		boolean result = false;
		EntityManager em = createEM();
		try {
			em.getTransaction().begin();
			em.persist(a);
			em.getTransaction().commit();
			result = true;
		} catch (Exception e) {
			result = false;
			throw new DAOException("Can´t save", e);
		} finally {
			em.close();
		}

		return result;
	}

	/*
	 * Método que se usa para actualizar un autor
	 * 
	 * @Param Author a
	 * 
	 * @Return booleano que devuelve verdadero si se ha conseguido actualizar el
	 * autor y falso si ha fallado
	 */
	public static boolean update(Author a) throws DAOException {
		boolean result = false;
		EntityManager em = createEM();
		try {
			a = em.merge(a);
			em.getTransaction().begin();
			em.getTransaction().commit();

			result = true;
		} catch (Exception e) {
			result = false;
			throw new DAOException("Can´t update chapter", e);
		}

		return result;

	}

	/*
	 * Método que se usa para buscar un autor por id en la base de datos
	 * 
	 * @Param int id del autor que se quiera buscar
	 * 
	 * @Return Author que tiene la id correspendiente en caso de que se haya
	 * encontrado o id=-1 si el autor no se ha encontrado
	 * 
	 */
	public static Author getByID(long id) throws DAOException {
		Author result = new Author();

		return result;
	}

	/*
	 * Método que se usa para buscar autores por el nombre
	 * 
	 * @Param String name con el nombre del autor que se desa buscar
	 * 
	 * @Return List<Author> con los autores que coincidan con dicho nombre, en caso
	 * de no encontrar ninguno devuelve una lista vacia
	 */
	public static List<Author> getByName(String name) throws DAOException {
		List<Author> result = new ArrayList<Author>();
		EntityManager em = createEM();
		em.getTransaction().begin();
		TypedQuery<Author> q = em.createNamedQuery("findByName", Author.class);
		q.setParameter("name", name);
		result = q.getResultList();
		em.getTransaction().commit();

		return result;

	}

	/*
	 * Método que se usa para buscar un Author por el correo
	 * 
	 * @Param String email del Author que se quiera buscar
	 * 
	 * @Reuturn Author correspondiente al email que se ha introducido, Author vacio
	 * si no se ha encontrado correo que coincida
	 */
	public static Author getByEmail(String email) throws DAOException {
		Author result = new Author();
		EntityManager em = createEM();
		try {
			em.getTransaction().begin();
			TypedQuery<Author> q = em.createNamedQuery("findByEmail", Author.class);
			q.setParameter("email", email);
			result = q.getSingleResult();
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new DAOException("Can´t find Author", e);
		} finally {
			em.close();
		}

		return result;

	}

}
