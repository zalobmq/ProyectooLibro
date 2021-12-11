package model.MariaDBDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Book;
import model.Landscape;
import model.Note;
import model.IDAO.DAOException;
import utils.PersistenceUnit;

public class LandscapeImpMariaDB {
	
	/*
	 * Método que devuelve emf
	 * @Return emf.createEntityManager();
	 * */
	public static EntityManager createEM() {
		EntityManagerFactory emf=PersistenceUnit.getInstance();
		
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
	 * Método que se usa para traer todos los paisajes de la base de datos
	 * @Return  List<Landscape> con todos los paisajes de la base de datos
	 * */
	public static List<Landscape> getAll() throws DAOException {
		List<Landscape> result=new ArrayList<Landscape>();
		return result;
	}

	/*
	 * Método que borra el paisaje especificado
	 * @Param Landscape l que se quiera borrar
	 * @Return Booleano que devuelve verdadero si se ha borrado el paisaje y falso si no lo ha conseguido borrar
	 * */
	public static boolean delete(Landscape l) throws DAOException {
		boolean result=false;
		try {
			EntityManager em=createEM();
			em.getTransaction().begin();
			em.remove(l);
			em.getTransaction().commit();
			result =true;
			
		} catch (Exception e) {
			result=false;
			throw new DAOException("Can´t delete",e);
		}
		return result;
	}
	/*
	 * Método que se usa para guardar un paisaje
	 * @Param Landscape l
	 * @Return booleano que devuelve verdadero si se ha conseguido guardar el paisaje y falso si ha fallado
	 * */
	public static boolean save(Landscape l) throws DAOException {
		boolean result=false;
		try {
			EntityManager em=createEM();
			em.getTransaction().begin();
			em.persist(l);
			em.getTransaction().commit();
			result=true;
		} catch (Exception e) {
			result=false;
			throw new DAOException("Can´t save",e);
		}
		
		return result;
	}
	/*
	 * Método que se usa para buscar una nota por id en la base de datos
	 * @Param int id de la nota que se quiera buscar
	 * @Return Note que tiene la id correspendiente en caso de que se haya encontrado o id=-1 si la nota no se ha encontrado
	 * 
	 * */
	public static Landscape getByID(long id) throws DAOException {
		Landscape result=new Landscape();
		
		return result;
	}

	/*
	 * Método que se usa para buscar notas por el titulo
	 * @Param String title con el titulo de la nota que se desa buscar
	 * @Return List<Note> con las notas que coincidan con dicho nombre, en caso de no encontrar ninguno devuelve una lista vacia
	 * */
	public static List<Landscape> getByName(String name) throws DAOException {
		List<Landscape> result=new ArrayList<Landscape>();
		
		return result;
	}
	
	/*
	 * Método que se usa para buscar todos las notas de un libro
	 * @Param Book b con el libro del que se quieran obtener las notas
	 * @Return List<Note> con las notas de ese libro
	 * */
	public static List<Landscape> getLandscapeByBook(Book b) throws DAOException{
		List<Landscape> result=new ArrayList<>();
		EntityManager em=createEM();
		try {
			em.getTransaction().begin();
			TypedQuery<Landscape> q=em.createNamedQuery("FindByLandscapesBook",Landscape.class);
			q.setParameter("Book_id", b.getId());
			result= q.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new DAOException("Can´t find Notes",e);
		}finally {
			em.close();
		}
		return result;
	}

}
