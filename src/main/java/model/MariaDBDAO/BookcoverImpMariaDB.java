package model.MariaDBDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Book;
import model.BookCover;
import model.Chapter;
import model.IDAO.DAOException;
import utils.PersistenceUnit;

public class BookcoverImpMariaDB {

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
	 * Método que se usa para traer todos las portadas de la base de datos
	 * @Return  List<BookCover> con todos las portadas de la base de datos
	 * */
	public static List<BookCover> getAll() throws DAOException {
		List<BookCover> result = new ArrayList<>();

		return result;
	}
	/*
	 * Método que borra la portada especificada
	 * @Param BookCover bc que se quiera borrar
	 * @Return Booleano que devuelve verdadero si se ha borrado la portada y falso si no lo ha conseguido borrar
	 * */
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
	
	/*
	 * Método que se usa para guardar una portada
	 * @Param BookCover bc
	 * @Return booleano que devuelve verdadero si se ha conseguido guardar la y falso si ha fallado
	 * */
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

	/*
	 * Método que se usa para actualizar una portada
	 * @Param BookCover bc
	 * @Return booleano que devuelve verdadero si se ha conseguido actualizar la portada y falso si ha fallado
	 * */
	public static boolean update(BookCover bc) throws DAOException {
		boolean result = false;
		EntityManager em = createEM();
		try {
			bc=em.merge(bc);//se relaciona el objeto de java con su tupla en la base de datos para actualizarla
			em.getTransaction().begin(); 
			em.getTransaction().commit();
			
			result = true;
		} catch (Exception e) {
			result = false;
			throw new DAOException("Can´t update bookcover",e);
		}

		return result;

	}
	/*
	 * Método que se usa para buscar una portada por id en la base de datos
	 * @Param int id de la portada que se quiera buscar
	 * @Return BookCover que tiene la id correspendiente en caso de que se haya encontrado o id=-1 si la portada no se ha encontrado
	 * 
	 * */
	public static BookCover getByID(long id) throws DAOException {
		BookCover result=new BookCover();
		
		return result;
	}
	
	/*
	 * Método que se usa para buscar portadas por el nombre
	 * @Param String name con el titulo de la portada que se desa buscar
	 * @Return List<BookCover> con las portadas que coincidan con dicho nombre, en caso de no encontrar ninguno devuelve una lista vacia
	 * */

	public static List<BookCover> getByName(String name) throws DAOException {
		List<BookCover> result = new ArrayList<>();

		return result;
	}
	/*
	 * Método que se usa para buscar todos la portada de un libro
	 * @Param Book b con el libro del que se quieran obtener la portada
	 * @Return BookCover con la portada de ese libro, en caso de no encontrar la portada el id es -1
	 * */
	public static BookCover getBookcoverByBook(Book b) throws DAOException{
		BookCover result=new BookCover();
		EntityManager em=createEM();
		try {
			em.getTransaction().begin();
			TypedQuery<BookCover> q=em.createNamedQuery("FindByBookcoverBook",BookCover.class);
			q.setParameter("Book_id", b.getId());
			result= q.getSingleResult();
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new DAOException("Can´t find Chapters",e);
		}finally {
			em.close();
		}
		return result;
	}
}
