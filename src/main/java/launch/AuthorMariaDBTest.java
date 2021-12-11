package launch;

import model.Author;
import model.IDAO.DAOException;
import model.MariaDBDAO.AuthorImpMariaDB;
import model.h2DAO.AuthorImpH2;

public class AuthorMariaDBTest {

	public static void main(String[] args) {
		
		//saveTestH2();
		saveTestMariaDB();
		

	}
	
	static void saveTestMariaDB() {
		Author a=new Author("Juanito", "perez","123","a@a");
		try {
			AuthorImpMariaDB.save(a);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void saveTestH2() {
		Author a=new Author("Juanito", "perez","123","a@a");
		
		try {
			AuthorImpH2.save(a);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
