package model.MariaDBDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Book;
import model.Chapter;
import model.Character;
import model.Landscape;
import model.IDAO.DAOException;
import utils.PersistenceUnit;

public class CharacterImpMariaDB {

	
	/*
	 * Método que devuelve emf
	 * @Return emf.createEntityManager();
	 * */
	public static EntityManager createEM() {
		EntityManagerFactory emf = PersistenceUnit.getInstance("aplicacionMariaDB");

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
	 * Método que se usa para traer todos los personajes de la base de datos
	 * @Return  List<Character> con todos los personajes de la base de datos
	 * */
	public static List<Character> getAll() throws DAOException {
		List<Character> result = new ArrayList<Character>();
		return result;
	}
	
	/*
	 * Método que se usa para borrar un personaje
	 * @Param Character l
	 * @Return booleano que devuelve verdadero si se ha conseguido borrar el personaje y falso si ha fallado
	 * */
	public static boolean delete(Character l) throws DAOException {
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
	
	/*
	 * Método que se usa para guardar un personaje
	 * @Param Character l
	 * @Return boolean que devuelve verdadero si se ha conseguido guardar el personaje y falso si ha fallado
	 * */
	public static boolean save(Character l) throws DAOException {
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
	
	/*
	 * Método que se usa para actualizar un personaje
	 * @Param Character l
	 * @Return booleano que devuelve verdadero si se ha conseguido actualizar el personaje en la base de datos y falso si ha fallado
	 * */
	public static boolean update(Character l) throws DAOException {
		boolean result = false;
		EntityManager em = createEM();
		try {
			l=em.merge(l);//se relaciona el objeto de java con su tupla en la base de datos para actualizarla
			em.getTransaction().begin(); 
			em.getTransaction().commit();
			
			result = true;
		} catch (Exception e) {
			result = false;
			throw new DAOException("Can´t update character",e);
		}

		return result;

	}
	/*
	 * Método que se usa para buscar un personaje por id en la base de datos
	 * @Param int id de la nota que se quiera buscar
	 * @Return Character que tiene la id correspendiente en caso de que se haya encontrado o id=-1 si el personaje no se ha encontrado
	 * 
	 * */
	public static Character getByID(long id) throws DAOException {
		Character result = new Character();

		return result;
	}
	
	/*
	 * Método que se usa para buscar personajes por el nombre
	 * @Param String name con el nombre del personaje que se desa buscar
	 * @Return List<Character> con los personajes que coincidan con dicho nombre, en caso de no encontrar ninguno devuelve una lista vacia
	 * */
	public static List<Character> getByName(String name) throws DAOException {
		List<Character> result = new ArrayList<Character>();

		return result;
	}
	
	/*
	 * Método que se usa para buscar todos las notas de un libro
	 * @Param Book b con el libro del que se quieran obtener las notas
	 * @Return List<Characcter> con los personajes de ese libro
	 * */
	public static List<Character> getCharacterByBook(Book b) throws DAOException{
		List<Character> result=new ArrayList<>();
		EntityManager em=createEM();
		try {
			em.getTransaction().begin();
			TypedQuery<Character> q= em.createNamedQuery("FindByCharacterBook",Character.class);
			q.setParameter("Book_id", b.getId());
			result= q.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new DAOException("Can´t find Character",e);
		}finally {
			em.close();
		}
		return result;
	}

}
