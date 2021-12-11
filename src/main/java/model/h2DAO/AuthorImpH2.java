package model.h2DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import model.Author;
import model.IDAO.DAOException;
import model.IDAO.IDAO;
import utils.PersistenceUnit;

public class AuthorImpH2{
	
	
	
	/*
	 * Método que devuelve emf
	 * @Return emf.createEntityManager();
	 * */
	public static EntityManager createEM() {
		EntityManagerFactory emf=PersistenceUnit.getInstance("aplicacionH2");
		
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
	 * Método que devuelve todos los autores
	 * @Return lista de todos los autores existentes en la base de datos
	 * */
	public static List<Author> getAll() throws DAOException {
		List<Author> result=new ArrayList<Author>();
		
		return result;
	}

	/*
	 * Método que borra el autor especificado
	 * @Param Author que se quiera borrar
	 * @Return Booleano que devuelve verdadero si se ha borrado el autor y falso y no lo ha conseguido guardar
	 * */
	public static boolean delete(Author a) throws DAOException {
		boolean result=false;
		EntityManager em=createEM();
		try {
			em.getTransaction().begin();
			em.remove(a);
			em.getTransaction().commit();
			result =true;
			
		} catch (Exception e) {
			result=false;
			throw new DAOException("Can´t delete",e);
		}finally {
			em.close();
		}
		return result;
	}

	/*
	 * Método que se usa para guardar un autor
	 * @Param Author
	 * @Return booleano que devuelve verdadero si se ha conseguido guardar el autor
	 * */
	public static boolean save(Author a) throws DAOException {
		boolean result=false;
		EntityManager em=createEM();
		try {
			em.getTransaction().begin();
			em.persist(a);
			em.getTransaction().commit();
			result=true;
		} catch (Exception e) {
			result=false;
			throw new DAOException("Can´t save",e);
		}finally {
			em.close();
		}
		
		return result;
	}

	/*
	 * Método que se usa para buscar un autor por id en la base de datos
	 * @Param id del autor que se quiera buscar
	 * @Return Autor que tiene la id correspendiente en caso de que se haya encontrado o id=-1 si el autor no se ha encontrado
	 * 
	 * */
	public static Author getByID(long id) throws DAOException {
		Author result=new Author();
		
		return result;
	}

	/*
	 * Método que se usa para buscar autores por el nombre
	 * @Param String con el nombre del autor que se desa buscar
	 * @Return List<Author> con los autores que coiincidan con dicho nombre, en caso de no encontrar ninguno devuelve una lista vacia
	 * */
	
	public static List<Author> getByName(String name) throws DAOException {
		List<Author> result=new ArrayList<Author>();
		
		return result;
		
	}

}
