package launch;

import model.Book;
import model.IDAO.DAOException;
import model.MariaDBDAO.ChapterImpMariaDB;

public class ChapterTest {

	public static void main(String[] args) {
		getChapterByBook();
		
	}
	static void getChapterByBook() {
		Book b=new Book();
		b.setId(2L);
		try {
			System.out.println(ChapterImpMariaDB.getChapterByBook(b));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
