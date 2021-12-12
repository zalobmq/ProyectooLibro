package controller;



import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Author;
import model.Book;
import model.Saga;
import model.IDAO.DAOException;
import model.MariaDBDAO.AuthorImpMariaDB;
import model.MariaDBDAO.BookImpMariaDB;
import model.MariaDBDAO.SagaImpMariaDB;

public class NewBookController {

	
	private static  Author author;
	/*TEXT FIELD*/
	@FXML
	private TextField TitleID;
	@FXML
	private TextField SagaNameID;
	@FXML
	private TextField GenereID;
	
	/*TEXT AREA*/
	@FXML
	private TextArea SynopsisID;
	
	/*BUTTON*/
	@FXML
	private Button AddBook;
	//@FXML
	// Button AddSagaName;
	
	public static void setAuthor (Author a) {
		
    	author = a;	
    }
	@FXML
	protected void initialize() {
	}
	
	
	public void addBook() {
		
		
		Book newBook = new Book();
		if(TitleID.getText().length()>0 && SynopsisID.getText().length() >0) {
		newBook.setTitle(TitleID.getText());
		newBook.setGenre(GenereID.getText());
		newBook.setAuthor(author);
		newBook.setSypnosis(SynopsisID.getText());
		try {
			System.out.println(newBook);
			author.getbooks_author().add(newBook);
			System.out.println(author.getbooks_author().toString());
			
			BookImpMariaDB.save(newBook);
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
		
		mostrarAlertInfo();
		TitleID.clear();
		SynopsisID.clear();
		}else {
			
			mostrarAlertErrorEmptyFields();
		}
		
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
	    alert.setContentText("LIBRO CREADO CORRECTAMENTE");
	    alert.showAndWait();
	    
	}
	
	
	
	
	
}
