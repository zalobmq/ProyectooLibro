package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Book;
import model.BookCover;
import model.IDAO.DAOException;
import model.MariaDBDAO.BookcoverImpMariaDB;

public class InfoBookController {

	private static  Book book;

	@FXML
    private Label TitleID;

    @FXML
    private Label SynopsysID;

    @FXML
    private ImageView ImageID;


    public static void setBook(Book b) {
		
		book = b;
		
    }
    
	@FXML
	protected void initialize() {
		mostrarInfo();
	}
	
	public void mostrarInfo() {
		
		TitleID.setText(book.getTitle());
		SynopsysID.setText(book.getSypnosis());
		try {
			BookCover bc=BookcoverImpMariaDB.getBookcoverByBook(book);
			System.out.println(bc.getImage());
			System.out.println("TS "+bc.getImage().toString());
			Image image = new Image("file:"+bc.getImage());
			ImageID.setImage(image);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

