package controller;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Book;
import model.Character;
import model.Note;
import model.IDAO.DAOException;
import model.MariaDBDAO.BookImpMariaDB;
import model.MariaDBDAO.CharacterImpMariaDB;
import model.MariaDBDAO.NoteImpMariaDB;

public class NewNoteController {

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
	
	public void addNote() {
		
	Note note = new Note();
		//character.setBooks_character(new ArrayList<Book>());
		
		note.setTitle(NameID.getText());
		note.setText(DescriptionID.getText());
	
		try {
			NoteImpMariaDB.save(note);//Guardo personaje
			//System.out.println(no.getCharacters().toString());
			book.getNotes().add(note);
			//System.out.println(book.getCharacters().toString());
			note.setBook_note(book);
			
			
			BookImpMariaDB.update(book);//actualizo libro
			mostrarAlertInfo();
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NameID.clear();
		DescriptionID.clear();
		
	}
	
	@FXML
	private void mostrarAlertErrorEmptyFields() {
	    Alert alert = new Alert(Alert.AlertType.ERROR);
	    alert.setHeaderText(null);
	    alert.setTitle("Error");
	    alert.setContentText("DEBES RELLENAR TODOS LOS CAMPOS");
	    alert.showAndWait();
	}
	 
	@FXML
	private void mostrarAlertInfo() {
	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    alert.setHeaderText(null);
	    alert.setTitle("Info");
	    alert.setContentText("NOTA CREADO CORRECTAMENTE");
	    alert.showAndWait();
	    
	}
}
