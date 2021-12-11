package model.h2DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import model.BookCover;
import model.IDAO.DAOException;
import utils.PersistenceUnit;

public class BookcoverImpH2 {
	
	/*
	 * Método que devuelve emf
	 * @Return emf.createEntityManager();
	 * */
	public static EntityManager createEM() {
		EntityManagerFactory emf = PersistenceUnit.getInstance();

		return emf.createEntityManager();
	}
	
	/*
	 * Método que crea el objeto para realizar las transacciones
	 * @Return em.getTransaction() 
	 * */
	public static EntityTransaction beginsession() {
		EntityManager em = createEM();
		return em.getTransaction();
	}

	/*
	 * Método que devuelve todas las portadas de los libros
	 * @Return lista de todas las portadas de los libros de la base de datos
	 * */
	public static List<BookCover> getAll() throws DAOException {
		List<BookCover> result = new ArrayList<>();

		return result;
	}

	/*
	 * Método que borra la portada especificada
	 * @Param BookCover que se quiera borrar
	 * @Return Booleano que devuelve verdadero si se ha borrado la portada y falso y no la ha conseguido guardar
	 * */
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
		}finally {
			em.close();
		}
		return result;
	}

	/*
	 * Método que se usa para guardar la portada del libro
	 * @Param Portada del libro
	 * @Return booleano que devuelve verdadero si se ha conseguido guardar la portda del libro
	 * */
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
		}finally {
			em.close();
		}

		return result;
	}

	/*
	 * Método que se usa para buscar una BookCover por id en la base de datos
	 * @Param Long id del BookCover que se quiera buscar
	 * @Return BookCover que tiene la id correspendiente en caso de que se haya encontrado o id=-1 si el BookCover no se ha encontrado
	 * 
	 * */
	public static BookCover getByID(long id) throws DAOException {
		BookCover result = new BookCover();

		return result;
	}

	/*
	 * Método que se usa para buscar BookCover por el nombre
	 * @Param String con el nombre del BookCover que se desa buscar
	 * @Return List<BookCover> con los BookCover que coiincidan con dicho nombre, en caso de no encontrar ninguno devuelve una lista vacia
	 * */
	public static List<BookCover> getByName(String name) throws DAOException {
		List<BookCover> result = new ArrayList<>();

		return result;
	}

}
