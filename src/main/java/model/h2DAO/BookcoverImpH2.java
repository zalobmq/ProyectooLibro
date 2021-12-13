package model.h2DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Book;
import model.BookCover;
import model.IDAO.DAOException;
import utils.PersistenceUnit;

public class BookcoverImpH2 {

	/*
	 * Método que devuelve emf
	 * 
	 * @Return emf.createEntityManager();
	 */
	public static EntityManager createEM() {
		EntityManagerFactory emf = PersistenceUnit.getInstance();

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
	 * Método que devuelve todas las portadas de los libros
	 * 
	 * @Return lista de todas las portadas de los libros de la base de datos
	 */
	public static List<BookCover> getAll() throws DAOException {
		List<BookCover> result = new ArrayList<>();

		return result;
	}

	/*
	 * Método que borra la portada especificada
	 * 
	 * @Param BookCover bc que se quiera borrar
	 * 
	 * @Return Booleano que devuelve verdadero si se ha borrado la portada y falso y
	 * no la ha conseguido guardar
	 */
	public static boolean delete(BookCover bc) throws DAOException {
		boolean result = false;
		EntityManager em = createEM();
		try {
			em.getTransaction().begin();
			em.remove(bc);
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
	 * Método que se usa para guardar la portada del libro
	 * 
	 * @Param BookCover bc
	 * 
	 * @Return booleano que devuelve verdadero si se ha conseguido guardar la portda
	 * del libro
	 */
	public static boolean save(BookCover bc) throws DAOException {
		boolean result = false;
		EntityManager em = createEM();
		try {
			em.getTransaction().begin();
			em.persist(bc);
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
	 * Método que se usa para actualizar una portada
	 * 
	 * @Param BookCover bc
	 * 
	 * @Return booleano que devuelve verdadero si se ha conseguido actualizar la
	 * portada y falso si ha fallado
	 */
	public static boolean update(BookCover bc) throws DAOException {
		boolean result = false;
		EntityManager em = createEM();
		try {
			bc = em.merge(bc);// se relaciona el objeto de java con su tupla en la base de datos para
								// actualizarla
			em.getTransaction().begin();
			em.getTransaction().commit();

			result = true;
		} catch (Exception e) {
			result = false;
			throw new DAOException("Can´t update bookcover", e);
		}

		return result;

	}

	/*
	 * Método que se usa para buscar una BookCover por id en la base de datos
	 * 
	 * @Param Long id del BookCover que se quiera buscar
	 * 
	 * @Return BookCover que tiene la id correspendiente en caso de que se haya
	 * encontrado o id=-1 si el BookCover no se ha encontrado
	 * 
	 */
	public static BookCover getByID(long id) throws DAOException {
		BookCover result = new BookCover();

		return result;
	}

	/*
	 * Método que se usa para buscar BookCover por el nombre
	 * 
	 * @Param String con el nombre del BookCover que se desa buscar
	 * 
	 * @Return List<BookCover> con los BookCover que coiincidan con dicho nombre, en
	 * caso de no encontrar ninguno devuelve una lista vacia
	 */
	public static List<BookCover> getByName(String name) throws DAOException {
		List<BookCover> result = new ArrayList<>();

		return result;
	}
	/*
	 * Método que se usa para buscar todos la portada de un libro
	 * 
	 * @Param Book b con el libro del que se quieran obtener la portada
	 * 
	 * @Return BookCover con la portada de ese libro, en caso de no encontrar la
	 * portada el id es -1
	 */
	public static BookCover getBookcoverByBook(Book b) throws DAOException {
		BookCover result = new BookCover();
		EntityManager em = createEM();
		try {
			em.getTransaction().begin();
			TypedQuery<BookCover> q = em.createNamedQuery("FindByBookcoverBook", BookCover.class);
			q.setParameter("Book_id", b.getId());
			result = q.getSingleResult();
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new DAOException("Can´t find Chapters", e);
		} finally {
			em.close();
		}
		return result;
	}

}
