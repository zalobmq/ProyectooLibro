package model.h2DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Book;
import model.Chapter;
import model.IDAO.DAOException;
import utils.PersistenceUnit;

public class ChapterImpH2 {

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
	 * Método que se usa para traer todos los capítulos de la base de datos
	 * @Return  List<Chapter> con todos los capítulos de la base de datos
	 * */
	public static List<Chapter> getAll() throws DAOException {
		List<Chapter> result = new ArrayList<Chapter>();

		return result;
	}
	/*
	 * Método que borra el capítulo especificado
	 * @Param Chapter c que se quiera borrar
	 * @Return Booleano que devuelve verdadero si se ha borrado el capítulo y falso si no lo ha conseguido borrar
	 * */
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
	
	/*
	 * Método que se usa para guardar un capítulo
	 * @Param Chapter c
	 * @Return booleano que devuelve verdadero si se ha conseguido guardar el capítulo y falso si ha fallado
	 * */
	public static boolean save(Chapter c) throws DAOException {
		boolean result = false;
		try {
			EntityManager em = createEM();
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			result = true;
		} catch (Exception e) {
			result = false;
			throw new DAOException("Can´t save", e);
		}

		return result;
	}
	/*
	 * Método que se usa para buscar un capítulo por id en la base de datos
	 * @Param int id del capítulo que se quiera buscar
	 * @Return Chapter que tiene la id correspendiente en caso de que se haya encontrado o id=-1 si el capítulo no se ha encontrado
	 * 
	 * */
	public static Chapter getByID(long id) throws DAOException {
		Chapter result = new Chapter();

		return result;
	}
	
	/*
	 * Método que se usa para buscar capítulos por el nombre
	 * @Param String name con el titulo del capítulo que se desa buscar
	 * @Return List<Chapter> con los capítulos que coincidan con dicho nombre, en caso de no encontrar ninguno devuelve una lista vacia
	 * */
	public static List<Chapter> getByName(String name) throws DAOException {
		List<Chapter> result = new ArrayList<Chapter>();

		return result;
	}
	
	/*
	 * Método que se usa para buscar todos los capítulos de un libro
	 * @Param Book b con el libro del que se quieran obtener los capítulos
	 * @Return List<Chapter> con los capítulos de ese libro
	 * */
	public static List<Chapter> getChapterByBook(Book b) throws DAOException{
		List<Chapter> result=new ArrayList<>();
		EntityManager em=createEM();
		try {
			em.getTransaction().begin();
			TypedQuery<Chapter> q=em.createNamedQuery("FindByChapterBook",Chapter.class);
			result= q.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new DAOException("Can´t find Chapters",e);
		}finally {
			em.close();
		}
		return result;
	}
	

}
