package launch;

import model.Book;
import model.BookCover;
import model.IDAO.DAOException;
import model.MariaDBDAO.BookImpMariaDB;
import model.MariaDBDAO.BookcoverImpMariaDB;

public class BookcoverTest {

	public static void main(String[] args) {
		//getBookcoverByBook();
		saveBookCover();

	}
	static void saveBookCover() {
		try {
			Book b=BookImpMariaDB.getByID(10);
			System.out.println(b);
			BookCover bc=new BookCover();
			//BookcoverImpMariaDB.save(bc);
			bc.setImage("./imagen");
			bc.setBook(b);
			b.setBookcover(bc);
			BookImpMariaDB.update(b);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
