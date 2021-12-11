package launch;

import model.Book;
import model.IDAO.DAOException;
import model.MariaDBDAO.BookImpMariaDB;
import model.MariaDBDAO.BookcoverImpMariaDB;

public class BookTest {

	public static void main(String[] args) {
		saveTest();

	}
	static void saveTest() {
		Book b=new Book();
		try {
			BookImpMariaDB.save(b);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
