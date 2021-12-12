package launch;

import model.Book;
import model.BookCover;
import model.IDAO.DAOException;
import model.MariaDBDAO.BookcoverImpMariaDB;

public class BookcoverTest {

	public static void main(String[] args) {
		getBookcoverByBook();

	}
	
	static void getBookcoverByBook() {
		Book b=new Book();
		b.setId(6L);
		try {
			BookCover bc=BookcoverImpMariaDB.getBookcoverByBook(b);
			System.out.println(bc.toString());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
