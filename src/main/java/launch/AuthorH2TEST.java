package launch;

import model.Author;
import model.IDAO.DAOException;
import model.MariaDBDAO.AuthorImpMariaDB;
import model.h2DAO.AuthorImpH2;

public class AuthorH2TEST {
	
	public static void main(String[] args) {
		getbymailh2();
	}
	static void getbymailh2() {
		
		
		
		try {
			Author b= AuthorImpH2.getByEmail("a@a");
			System.out.println(b.toString());
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
