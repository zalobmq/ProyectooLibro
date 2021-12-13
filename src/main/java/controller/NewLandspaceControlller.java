package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Book;

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
}
