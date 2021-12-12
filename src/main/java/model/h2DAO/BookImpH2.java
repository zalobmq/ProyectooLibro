package model.h2DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Author;
import model.Book;
import model.IDAO.DAOException;
import utils.PersistenceUnit;

public class BookImpH2 {
	

	public static EntityManager createEM() {
		EntityManagerFactory emf=PersistenceUnit.getInstance("aplicacionH2");
		
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

	

	public static Book getByID(long id) throws DAOException {
		Book result=new Book();
		return result;
	}

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
