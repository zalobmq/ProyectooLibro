package launch;

import model.Author;
import model.IDAO.DAOException;
import model.MariaDBDAO.AuthorImpMariaDB;
import model.h2DAO.AuthorImpH2;

public class AuthorMariaDBTest {

	public static void main(String[] args) {
		
		saveTest();
		

	}
	
	static void saveTest() {
		Author a=new Author("Juanito", "perez","123","a@a");
		try {
			AuthorImpMariaDB.save(a);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
