package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Book;
import model.Chapter;
import model.IDAO.DAOException;
import model.MariaDBDAO.ChapterImpMariaDB;

public class NewChapterController {
	
	private static  Book book;
	/*TEXT FIELD*/
	
	@FXML
	private TextField NumberChapterID;
	@FXML
	private TextField NameChapterID;
	
	public static void setBook(Book b) {
		
		book = b;	
    }
	
	public void addChapter() {
		
		Chapter c = new Chapter();
		if(NumberChapterID.getText().length()>0 && NameChapterID.getText().length() >0) {
			c.setChapterNumber(Integer.parseInt(NumberChapterID.getText()));
			c.setName(NameChapterID.getText());
			c.setFinish(false);
			c.setText("");
			c.setBook_chapter(book);
			book.getChapters().add(c);
		try {
			ChapterImpMariaDB.save(c);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mostrarAlertInfo();
		NumberChapterID.clear();
		NameChapterID.clear();
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
	    alert.setContentText("CAPITULO CREADO CORRECTAMENTE");
	    alert.showAndWait();
	    
	}
}
