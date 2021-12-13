package controller;


import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Book;
import model.Character;
import model.IDAO.DAOException;
import model.MariaDBDAO.BookImpMariaDB;
import model.MariaDBDAO.CharacterImpMariaDB;
import sun.security.krb5.internal.crypto.Des;

public class NewCharacterController {
	
	private static  Book book;


	@FXML
	private TextField NameID;
	
	@FXML
	private TextArea DescriptionID;
	
	public static void setBook(Book b) {
		
		book = b;	
    }
	
	@FXML
	protected void initialize() {
		
		
	}
	
	public void addCharacter() {
		
		Character character = new Character();
		
		character.setName(NameID.getText());
		character.setDescription(DescriptionID.getText());
		character.setDeath(false);
		try {
			CharacterImpMariaDB.save(character);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
