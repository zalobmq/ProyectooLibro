package launch;

import model.Book;
import model.IDAO.DAOException;
import model.MariaDBDAO.CharacterImpMariaDB;

public class CharacterTest {

	public static void main(String[] args) {
		characterByBookTest();

	}
	static void characterByBookTest() {
		Book b=new Book();
		b.setId(2L);
		try {
			System.out.println(CharacterImpMariaDB.getCharacterByBook(b).toString());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
