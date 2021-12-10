package model.IDAO;

import java.util.List;



public interface IDAO<t>{
	List<t> getAll() throws DAOException;

	boolean delete()throws DAOException;

	boolean save()throws DAOException;

	
	t getByID(long id) throws DAOException;
	List<t> getByName(String name) throws DAOException;

}
