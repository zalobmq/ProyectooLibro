package model.MariaDBDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Author;
import model.Book;
import model.Note;
import model.IDAO.DAOException;
import utils.PersistenceUnit;

public class BookImpMariaDB {

	/*
	 * Método que devuelve emf
	 * @Return emf.createEntityManager();
	 * */
	public static EntityManager createEM() {
		EntityManagerFactory emf=PersistenceUnit.getInstance("aplicacionMariaDB");
		
		return emf.createEntityManager();
	}
	/*
	 * Método que crea el objeto para realizar las transacciones
	 * @Return em.getTransaction() 
	 * */
	public static EntityTransaction beginsession() {
		EntityManager em=createEM();
		return em.getTransaction();
	}
	/*
	 * Método que se usa para traer todos los libros de la base de datos
	 * @Return  List<Book> con todos los libros de la base de datos
	 * */
	public static List<Book> getAll() throws DAOException {
		List<Book> result=new ArrayList<>();
		EntityManager em=createEM();
		try {
			em.getTransaction().begin();
			TypedQuery<Book> q=em.createNamedQuery("ShowAllBooks",Book.class);
			result= q.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new DAOException("Can´t find Books",e);
		}finally {
			em.close();
		}
		
		return result;
	}
	/*
	 * Método que borra el libro especificado
	 * @Param Book b que se quiera borrar
	 * @Return Booleano que devuelve verdadero si se ha borrado el libro y falso si no lo ha conseguido borrar
	 * */
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
			throw new DAOException("Can´t delete",e);
		}
		return result;
	}
	
	/*
	 * Método que se usa para guardar un libro
	 * @Param Book
	 * @Return booleano que devuelve verdadero si se ha conseguido guardar el libro y falso si ha fallado
	 * */
	public static boolean save(Book b) throws DAOException {
		boolean result=false;
		try {
			EntityManager em=createEM();
			em.getTransaction().begin();
			em.persist(b);
			em.getTransaction().commit();
			result=true;
		} catch (Exception e) {
			result=false;
			throw new DAOException("Can´t save",e);
		}
		
		return result;
	}

	
	/*
	 * Método que se usa para buscar un libro por id en la base de datos
	 * @Param int id del libro que se quiera buscar
	 * @Return Book que tiene la id correspendiente en caso de que se haya encontrado o id=-1 si el libro no se ha encontrado
	 * 
	 * */
	public static Book getByID(long id) throws DAOException {
		Book result=new Book();
		return result;
	}
	/*
	 * Método que se usa para buscar libros por el titulo
	 * @Param String name con el titulo del libro que se desa buscar
	 * @Return List<Book> con los libros que coincidan con dicho nombre, en caso de no encontrar ninguno devuelve una lista vacia
	 * */
	public static List<Book> getByName(String name) throws DAOException {
		List<Book> result=new ArrayList<Book>();
		
		return result;
	}
	
	/*
	 * Método que se usa para buscar todos los libros de un autor
	 * @Param Author a con el autor del que se quieran obtener los libros
	 * @Return List<Book> con los libros del autor
	 * */
	public static List<Book> getBookByAuthor(Author a) throws DAOException{
		List<Book> result=new ArrayList<>();
		EntityManager em=createEM();
		try {
			em.getTransaction().begin();
			TypedQuery<Book> q=em.createNamedQuery("FindBookByAuthor",Book.class);
			q.setParameter("author_id", a.getId());
			result= q.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new DAOException("Can´t find books",e);
		}finally {
			//en La carga lazy no se debe cerrar la conexion
			//em.close();
		}
		return result;
	}
	
	
	
	

}
