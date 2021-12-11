package launch;

import java.util.ArrayList;
import java.util.List;

import model.Author;
import model.Book;
import model.IDAO.DAOException;
import model.MariaDBDAO.AuthorImpMariaDB;
import model.h2DAO.AuthorImpH2;

public class AuthorMariaDBTest {

	public static void main(String[] args) {
		saveTest();
		
		

	}
	
	static void saveTest() {
		Author a=new Author();
		
		try {
			AuthorImpH2.save(a);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
