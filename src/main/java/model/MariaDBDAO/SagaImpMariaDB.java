package model.MariaDBDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import model.Chapter;
import model.Saga;
import model.IDAO.DAOException;
import utils.PersistenceUnit;

public class SagaImpMariaDB {
	
	
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
	 * Método que se usa para traer todos las sagas de la base de datos
	 * @Return  List<Saga> con todos las sagas de la base de datos
	 * */
	public static List<Saga> getAll() throws DAOException {
		List<Saga> result=new ArrayList<Saga>();
		
		return result;
	}

	/*
	 * Método que borra la saga especificada
	 * @Param Saga s que se quiera borrar
	 * @Return Booleano que devuelve verdadero si se ha borrado la saga y falso si no lo ha conseguido borrar
	 * */
	public static boolean delete(Saga s) throws DAOException {
		boolean result=false;
		try {
			EntityManager em=createEM();
			em.getTransaction().begin();
			em.remove(s);
			em.getTransaction().commit();
			result =true;
			
		} catch (Exception e) {
			result=false;
			throw new DAOException("Can´t delete");
		}
		return result;
	}
	/*
	 * Método que se usa para guardar una saga
	 * @Param Saga s
	 * @Return booleano que devuelve verdadero si se ha conseguido guardar la saga y falso si ha fallado
	 * */
	public static boolean save(Saga s) throws DAOException {
		boolean result=false;
		try {
			EntityManager em=createEM();
			em.getTransaction().begin();
			em.persist(s);
			em.getTransaction().begin();
			result=true;
		} catch (Exception e) {
			result=false;
			throw new DAOException("Can´t save");
		}
		
		return result;
	}
	
	/*
	 * Método que se usa para actualizar una saga
	 * @Param Saga s
	 * @Return booleano que devuelve verdadero si se ha conseguido actualizar la saga y falso si ha fallado
	 * */
	public static boolean update(Saga s) throws DAOException {
		boolean result = false;
		EntityManager em = createEM();
		try {
			s=em.merge(s);//se relaciona el objeto de java con su tupla en la base de datos para actualizarla
			em.getTransaction().begin(); 
			em.getTransaction().commit();
			
			result = true;
		} catch (Exception e) {
			
			result = false;
			throw new DAOException("Can´t update chapter",e);
		}

		return result;

	}
	/*
	 * Método que se usa para buscar una saga por id en la base de datos
	 * @Param int id de la saga que se quiera buscar
	 * @Return Saga que tiene la id correspendiente en caso de que se haya encontrado o id=-1 si la saga y no se ha encontrado
	 * 
	 * */
	public static Saga getByID(long id) throws DAOException {
		Saga result=new Saga();
		
		return result;
	}
	/*
	 * Método que se usa para buscar Sagas por el nombre
	 * 
	 * @Param String name con el nombre de la nota que se desa buscar
	 * 
	 * @Return List<Saga> con las Sagas que coincidan con dicho nombre, en caso de
	 * no encontrar ninguno devuelve una lista vacia
	 */
	public static List<Saga> getByName(String name) throws DAOException {
		List<Saga> result=new ArrayList<>();
		
		return result;
	}

}
