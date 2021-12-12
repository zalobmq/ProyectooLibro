package launch;

import model.Author;
import model.Book;
import model.Chapter;
import model.IDAO.DAOException;
import model.MariaDBDAO.AuthorImpMariaDB;
import model.h2DAO.AuthorImpH2;
import model.h2DAO.BookImpH2;
import model.h2DAO.ChapterImpH2;

public class h2test {
	
	public static void main(String[] args) {
		saveBook();
	}
	static void getbymailh2() {

		
		try {
			System.out.println("o.o");
			Author b= AuthorImpH2.getByEmail("a@a");
			System.out.println(b.toString());
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	static void saveBook() {
		Author a;
		Book b=new Book();
		try {
			a = AuthorImpH2.getByEmail("a@a");
			b.setAuthor(a);
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		b.setTitle("alicia en el pais de las maravillas");
		try {
			BookImpH2.save(b);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	static void getbookbyauthor() {
		Author a;
		try {
			a = AuthorImpH2.getByEmail("a@a");
			System.out.println(BookImpH2.getBookByAuthor(a).toString());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static void savechapter() {
		Chapter c = new Chapter();
		
	
		try {
		
			ChapterImpH2.save(c);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*static void getChapterfrombook() {
		Book b = new Book();
		b.setId(2L);
		try {
			System.out.println(ChapterImpH2.getChapterByBook(b));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
}
