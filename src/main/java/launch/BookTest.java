package launch;

import java.util.List;

import model.Author;
import model.Book;
import model.IDAO.DAOException;
import model.MariaDBDAO.AuthorImpMariaDB;
import model.MariaDBDAO.BookImpMariaDB;


public class BookTest {

	public static void main(String[] args) {
		saveTest();
		//getAllTest();

	}
	static void saveTest() {
		Book b=new Book();
		try {
			Author a=AuthorImpMariaDB.getByID(1);
			b.setAuthor(a);
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
