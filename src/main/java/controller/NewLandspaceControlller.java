package controller;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Book;
import model.Character;
import model.Landscape;
import model.IDAO.DAOException;
import model.MariaDBDAO.BookImpMariaDB;
import model.MariaDBDAO.CharacterImpMariaDB;
import model.MariaDBDAO.LandscapeImpMariaDB;

public class NewLandspaceControlller {

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
	
	
	public void addLandspace() {
		
		Landscape landscape = new Landscape();
		landscape.setBooks_landscape(new ArrayList<Book>());
		
		landscape.setName(NameID.getText());
		landscape.setDescription(DescriptionID.getText());
		try {
			LandscapeImpMariaDB.save(landscape);
			System.out.println(book.getLandscapes().toString());
			book.getLandscapes().add(landscape);//lo añado a la lista de personajes del libro
			System.out.println(book.getLandscapes().toString());
			landscape.getBooks_landscape().add(book);
			
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
	    alert.setContentText("PERSONAJE CREADO CORRECTAMENTE");
	    alert.showAndWait();
	    
	}

}
