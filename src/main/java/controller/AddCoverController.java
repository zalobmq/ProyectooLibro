package controller;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Book;
import model.BookCover;
import model.IDAO.DAOException;
import model.MariaDBDAO.BookImpMariaDB;
import model.MariaDBDAO.BookcoverImpMariaDB;

public class AddCoverController {

	private Stage stage = this.stage;
	private static  Book book;
	
	
	@FXML
	private Button addCoverID;
	@FXML
	private ImageView ivImagen;
	public static void setBook(Book b) {
		
		book = b;
		
    }
	
	private BookCover cover=new BookCover();
	
	@FXML
	protected void initialize() {
	
		
	}
	
	public void seachImage() {
		
		FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Imagen");
        
     // Agregar filtros para facilitar la busqueda
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        
     // Obtener la imagen seleccionada
        File imgFile = fileChooser.showOpenDialog(stage);
        System.out.println(imgFile.toString());
     
            
        // Mostar la imagen
        if (imgFile != null) {
            Image image = new Image("file:" + imgFile.getAbsolutePath());
				cover.setImage(imgFile.getAbsolutePath());
	            ivImagen.setImage(image);
        }
       
        
	}
	public void addCover() {
		 
		try {
			//BookcoverImpMariaDB.save(cover);
			cover.setBook(book);
			//BookcoverImpMariaDB.update(cover);
			book.setBookcover(cover);
			BookImpMariaDB.update(book);
			
			mostrarAlertInfo();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	private void mostrarAlertInfo() {
	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    alert.setHeaderText(null);
	    alert.setTitle("Info");
	    alert.setContentText("AÑADIDO CORRECTAMENTE");
	    alert.showAndWait();
	    
	}
	
}
