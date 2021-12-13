package launch;

import java.util.List;

import model.Author;
import model.Book;
import model.Character;
import model.IDAO.DAOException;
import model.MariaDBDAO.AuthorImpMariaDB;
import model.MariaDBDAO.BookImpMariaDB;
import model.MariaDBDAO.ChapterImpMariaDB;
import model.MariaDBDAO.CharacterImpMariaDB;


public class BookTest {

	public static void main(String[] args) {
		//saveTest();
		//getAllTest();
		addCharacterTest();

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
	//
	static void addCharacterTest() {
		Author a;
		try {
			a = AuthorImpMariaDB.getByEmail("a@a");
			
			List<Book> lb=BookImpMariaDB.getBookByAuthor(a);
			
			Book b=BookImpMariaDB.getByID(2);
			Character c=new Character("Barbara","estreisan",false);
			c.getBooks_character().add(b);
			b.getCharacters().add(c);
			System.out.println(b.getId().toString());
			BookImpMariaDB.update(b);
			//BookImpMariaDB.addCharacter(b, c);
			//System.out.println(b.toString());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
