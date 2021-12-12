package launch;

import java.util.List;

import model.Book;
import model.Chapter;
import model.IDAO.DAOException;
import model.MariaDBDAO.BookImpMariaDB;
import model.MariaDBDAO.ChapterImpMariaDB;

public class ChapterTest {

	public static void main(String[] args) {
		
		saveChapter();
		//getChapterByBook();
		
	}
	
	static void saveChapter() {
		
		Chapter c=new Chapter("El bujero oscuro","Una ladilla se perdio en un bosque de pelos",2,false);
		
		List<Book> lb;
		try {
			lb = BookImpMariaDB.getAll();
			c.setBook_chapter(lb.get(0));
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(c.toString());
		try {
			ChapterImpMariaDB.save(c);
			System.out.println(c.getId());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		c.setText("Cambiamos el texto");
		try {
			ChapterImpMariaDB.update(c);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
