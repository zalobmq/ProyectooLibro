package launch;

import java.util.List;

import model.Author;
import model.IDAO.DAOException;
import model.MariaDBDAO.AuthorImpMariaDB;
import model.h2DAO.AuthorImpH2;

public class AuthorMariaDBTest {

	public static void main(String[] args) {
		
		saveTestH2();
		//saveTestMariaDB();
		getByEmailMariaDB();
		//getByNameMariaDB();
		

	}
	
	static void saveTestMariaDB() {
		Author a=new Author("Juanito", "perez","123","a@a");
		try {
			AuthorImpMariaDB.save(a);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void saveTestH2() {
		Author a=new Author("Juanito", "perez","123","a@a");
		
		try {
			AuthorImpH2.save(a);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void getByNameMariaDB() {
		Author a=new Author("Juanito", "perez","123","a@a");
				
				try {
					AuthorImpMariaDB.save(a);
					List<Author> b= AuthorImpMariaDB.getByName("Juanito");
					System.out.println(b.toString());
				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	static void getByEmailMariaDB() {
		
		try {
			Author b= AuthorImpMariaDB.getByEmail("a@a");
			System.out.println(b.toString());
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
