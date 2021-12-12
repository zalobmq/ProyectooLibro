package launch;

import java.util.List;

import model.Book;
import model.IDAO.DAOException;
import model.MariaDBDAO.BookImpMariaDB;
import model.MariaDBDAO.BookcoverImpMariaDB;
import model.h2DAO.BookImpH2;

public class BookTest {

	public static void main(String[] args) {
		saveTest();
		//getAllTest();

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
	
	static void getAllTest() {
		try {
			List<Book> lb=BookImpMariaDB.getAll();
			System.out.println(lb.toString());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
